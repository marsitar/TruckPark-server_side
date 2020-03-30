import {AfterViewInit, Component} from '@angular/core';
import * as L from 'leaflet';
import {TruckDriverWay} from '../../domain/truck-driver-way';
import 'leaflet/dist/images/marker-shadow.png';
import {Mop} from '../../domain/mop';
import {Driver} from '../../domain/driver';
import {Truck} from '../../domain/truck';
import {DatePipe} from '@angular/common';
import {TruckService} from '../../service/truck.service';
import {DriverService} from '../../service/driver.service';
import {MopService} from '../../service/mop.service';
import {TruckDriverWayService} from '../../service/truck-driver-way.service';

@Component({
  selector: 'app-map-preview',
  templateUrl: './map-preview.component.html',
  styleUrls: ['./map-preview.component.css']
})
export class MapPreviewComponent implements AfterViewInit {
  private map;
  private mops: Mop[] = [];
  private drivers: Driver[] = [];
  private basemaps: L.groupLayer[] = [];
  private overlays = {};

  constructor(
    private truckService: TruckService,
    private driverService: DriverService,
    private mopService: MopService,
    private truckDriverWayService: TruckDriverWayService,
    private datepipe: DatePipe
  ) { }

  ngAfterViewInit(): void {
    this.generateBaseMapsFromOpenStreet();
    this.initMap();
    this.getAllLayers();
  }

  private initMap(): void {
    this.map = L.map('map-track-driver', {
      center: [52.095340, 19.486442],
      zoom: 6.5,
      layers: this.basemaps,
    });
  }

  private getAllLayers(){

    this.prepareMops();
    this.prepareTruckDriverWays();
  }

  private prepareMops() {

    var mopIcon = this.generateMopIcon();

    let mopsLayer = L.layerGroup();
    this.mopService.getMops().subscribe( mops =>
      {
        this.mops = mops;
        this.mops?.forEach(mop => {
          const lat = mop.coordinate?.lat;
          const lon = mop.coordinate?.lng;
          const marker = L.marker([lat, lon], mopIcon).addTo(mopsLayer).bindPopup(this.generateHtmlPopupMop(mop));
        });
        this.overlays["<span style='color: brown'>Mops</span>"]= mopsLayer;
        console.log('prepareMops()', mops);

        //placed here to because speed of loading
        this.addLayersToLayerControl();
      }
    );
  }

  private prepareTruckDriverWays(){
    this.driverService.getAllDrivers().subscribe(drivers => {
      this.drivers = drivers;
      this.drivers?.forEach( driver => {
        this.truckDriverWayService.getLastTruckDriverWayByDriverId(driver?.id).subscribe(truckDriverWay => {
          this.addTruckDriverWaysMarkerToLayerGroup(truckDriverWay);
        });
      });
    });
  }

  private addTruckDriverWaysMarkerToLayerGroup(truckDriverWay: TruckDriverWay){
    const lat = truckDriverWay?.coordinate?.lat;
    const lon = truckDriverWay?.coordinate?.lng;

    var truckDriverWayIcon= this.generateTruckDriverWayIcon();

    this.driverService.getDriverById(truckDriverWay?.driverId).toPromise().then((driver) => {
      this.truckService.getTruckById(truckDriverWay?.truckId).toPromise().then((truck) => {
        let tempLayerGroup = L.layerGroup();
        const marker = L.marker([lat, lon], truckDriverWayIcon).addTo(tempLayerGroup).bindPopup(this.generateHtmlPopupTruckDriver(truckDriverWay, driver, truck));
        this.overlays[driver?.fullName]= tempLayerGroup;
        this.map.addLayer(tempLayerGroup);
      });
    });
  }

  private addLayersToLayerControl() {
    let basemaps = {
      'Topograficzna': this.basemaps[1],
      'Drogowa': this.basemaps[2],
      'Standardowa': this.basemaps[0],
    };
    L.control.layers(basemaps, this.overlays).addTo(this.map);
    console.log('getAllLayers() overlays', this.overlays);
  }

  private generateBaseMapsFromOpenStreet() {

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      minZoom: 6,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    const topo = L.tileLayer('https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png', {
      maxZoom: 17,
      minZoom: 6,
      attribution: 'Map data: &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, <a href="http://viewfinderpanoramas.org">SRTM</a> | Map style: &copy; <a href="https://opentopomap.org">OpenTopoMap</a> (<a href="https://creativecommons.org/licenses/by-sa/3.0/">CC-BY-SA</a>)'
    });

    var roads = L.tileLayer('https://maps.heigit.org/openmapsurfer/tiles/roads/webmercator/{z}/{x}/{y}.png', {
      maxZoom: 19,
      attribution: 'Imagery from <a href="http://giscience.uni-hd.de/">GIScience Research Group @ University of Heidelberg</a> | Map data &copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
    });

    this.basemaps = [tiles, topo, roads];
  }

  private generateHtmlPopupTruckDriver(truckDriverWay: TruckDriverWay, driver: Driver, truck: Truck): string {

    const trackDriverName = ''.concat('<p class="popup-header">', driver?.fullName, '</p>');
    const truckBrandModel = ''.concat('<a class="popup-simple-row-label">', 'Model: ', '</a>', '<span class="popup-simple-row-value">', truck?.brand, ' ',truck?.model , '</span>');
    const fuel = ''.concat('<a class="popup-simple-row-label">', 'Paliwo: ', '</a>', '<span class="popup-simple-row-value">', truckDriverWay?.fuel?.toString(), '</span>');
    const distance = ''.concat('<a class="popup-simple-row-label">', 'Kilometraż: ', '</a>', '<span class="popup-simple-row-value">', truckDriverWay?.distance?.toString(), '</span>');
    const time = ''.concat('<a class="popup-simple-row-label">', 'Godzina: ', '</a>', '<span class="popup-simple-row-value">', this.datepipe.transform(truckDriverWay?.resultTime, 'dd-MM-yyyy'), '</span>');
    const date = ''.concat('<a class="popup-simple-row-label">', 'Data: ', '</a>', '<span class="popup-simple-row-value">', this.datepipe.transform(truckDriverWay?.resultTime, 'HH:mm:ss'), '</span>');

    return this.buildPopupContentTruckDriver(trackDriverName, truckBrandModel, fuel, distance, time, date);
  }

  private buildPopupContentTruckDriver(trackDriverName: string, truckBrandModel: string, fuel: string, distance: string
    , time: string, date: string): string {
    return trackDriverName
      .concat(truckBrandModel)
      .concat('<br>')
      .concat(fuel)
      .concat('<br>')
      .concat(distance)
      .concat('<br>')
      .concat(time)
      .concat('<br>')
      .concat(date);
  }

  private generateHtmlPopupMop(mop: Mop): string{

    const freeTruckPlacesNumber = mop?.truckPlaces - mop?.occupiedTruckPlaces;

    const mainHeaderPlace = ''.concat('<p class="popup-header">', mop?.place, '</p>');
    const identificationName = ''.concat('<a class="popup-simple-row-label">', 'Nazwa: ', '</a>', '<span class="popup-simple-row-value">', mop?.identificationName, '</span>');
    const category = ''.concat('<a class="popup-simple-row-label">', 'Kategoria: ', '</a>', '<span class="popup-simple-row-value">', mop?.category, '</span>');
    const roadNumber = ''.concat('<a class="popup-simple-row-label">', 'Numer drogi: ', '</a>', '<span class="popup-simple-row-value">', mop?.roadNumber, '</span>');
    const truckPlaces = ''.concat('<a class="popup-simple-row-label">', 'Liczba miejsc (TIR): ', '</a>', '<span class="popup-simple-row-value">', mop?.truckPlaces?.toString(), '</span>');
    const freeTruckPlaces = ''.concat('<a class="popup-simple-row-label">', 'Wolne miejsca (TIR): ', '</a>', '<span class="popup-simple-row-value">', freeTruckPlacesNumber?.toString(), '</span>');

    return this.buildPopupContentMop(mainHeaderPlace, identificationName, category, roadNumber, truckPlaces, freeTruckPlaces);
  }

  private buildPopupContentMop(mainHeaderPlace: string, identificationName: string, category: string, roadNumber: string
    , truckPlaces: string, freeTruckPlaces: string): string {

    return mainHeaderPlace
      .concat(identificationName)
      .concat('<br>')
      .concat(category)
      .concat('<br>')
      .concat(roadNumber)
      .concat('<br>')
      .concat(truckPlaces)
      .concat('<br>')
      .concat(freeTruckPlaces);
  }

  private generateMopIcon(): any {
    var mopIcon = {
      icon: L.icon({
        iconSize: [ 20, 20 ],
        iconAnchor: [ 0, 0 ],
        iconUrl: 'assets/parking.svg',
      })
    };

    return mopIcon;
  }

  private generateTruckDriverWayIcon(): any {
    var truckDriverWayIcon = {
      icon: L.icon({
        iconSize: [ 30, 30 ],
        iconAnchor: [ 0, 0 ],
        iconUrl: 'assets/truck-dark-grey.svg',
      })
    };

    return truckDriverWayIcon;
  }
}
