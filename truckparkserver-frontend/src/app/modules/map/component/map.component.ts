import {AfterViewInit, Component} from '@angular/core';
import {MapService} from '../service/map.service';
import * as L from 'leaflet';
import {Mop} from '../domain/mop';
import 'leaflet/dist/images/marker-shadow.png';

@Component({
  selector: 'app-map',
  templateUrl: '../component/map.component.html',
  styleUrls: ['../component/map.component.css']
})
export class MapComponent implements AfterViewInit {
  private map;
  private mops: Mop[] = [];

  constructor(
    private mapService: MapService
  ) { }

  ngAfterViewInit(): void {
    this.initMap();
    this.addMarkersToElement();
  }

  private initMap(): void {
    this.map = L.map('map', {
      center: [52.095340, 19.486442],
      zoom: 6.5
    });

    const tiles = L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
      maxZoom: 19,
      minZoom: 6,
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);
  }

  private addMarkersToElement(){
    this.mapService.getMops().subscribe( data =>
      {
        this.mops = data;
        this.mops?.forEach(mop => {
          const lat = mop.coordinate?.lat;
          const lon = mop.coordinate?.lng;
          const marker = L.marker([lat, lon]).addTo(this.map).bindPopup(this.generateHtmlPopupMop(mop));
        });
      }
    )
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
}
