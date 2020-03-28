import {AfterViewInit, Component} from '@angular/core';
import * as L from 'leaflet';
import {TrackDriverService} from '../service/track-driver.service';
import {TruckDriverWay} from '../domain/truck-driver-way';
import 'leaflet/dist/images/marker-shadow.png';

@Component({
  selector: 'app-track-driver',
  templateUrl: './track-driver.component.html',
  styleUrls: ['./track-driver.component.css']
})
export class TrackDriverComponent implements AfterViewInit {
  private map;
  private trackDriverWays: TruckDriverWay[] = [];

  constructor(
    private trackDriverService: TrackDriverService,
  ) { }

  ngAfterViewInit(): void {
    this.initMap();
    this.getAllTruckDriverWays();
  }

  private initMap(): void {
    this.map = L.map('map-track-driver', {
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

  private getAllTruckDriverWays() {
    this.trackDriverService.getTrackDriverService().subscribe(data => {
      this.trackDriverWays = data;
      console.log(data);
      this.trackDriverWays.forEach(trackDriverWay => {
        const lat = trackDriverWay?.coordinate?.lat;
        const lon = trackDriverWay?.coordinate?.lng;
        const marker = L.marker([lat, lon]).addTo(this.map);
      })

    });
  }


}
