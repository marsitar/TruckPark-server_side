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
  private mops: Mop[];

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
      zoom: 10
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
        console.log(this.mops);
      }
    )
  }

}
