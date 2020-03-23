import {AfterViewInit, Component} from '@angular/core';
import {MapService} from '../service/map.service';
import * as L from 'leaflet';
import {Mop} from '../domain/mop';

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
      attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    });

    tiles.addTo(this.map);
  }

  private addMarkersToElement(){
    this.mapService.getMops().subscribe( data =>
      {
        this.mops = data;
        this.mops.forEach(mop => {
          const lat = mop.coordinate?.y;
          const lon = mop.coordinate?.x;
          const marker = L.marker([lon, lat]).addTo(this.map).bindPopup(this.generateHtmlPopup(mop));
          console.log(marker);
        });
      }
    )
  }

  private generateHtmlPopup(mop: Mop): string{

    const freeTruckPlacesNumber = mop?.truckPlaces - mop?.occupiedTruckPlaces;

    const mainHeaderPlace = mop?.place;
    const identificationName = 'Nazwa: '.concat(mop?.identificationName);
    const category = 'Kategoria: '.concat(mop?.category);
    const roadNumber = 'Numer drogi: '.concat(mop?.roadNumber);
    const truckPlaces = 'Liczba miejsc (TIR): '.concat(mop?.truckPlaces?.toString());
    const freeTruckPlaces = 'Wolne miejsca (TIR): '.concat(freeTruckPlacesNumber?.toString());

    return this.buildPopupContent(mainHeaderPlace, identificationName, category, roadNumber, truckPlaces, freeTruckPlaces);
  }

  private buildPopupContent(mainHeaderPlace: string, identificationName: string, category: string, roadNumber: string
                            , truckPlaces: string, freeTruckPlaces: string,): string {
    return mainHeaderPlace
      .concat('<br>')
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
