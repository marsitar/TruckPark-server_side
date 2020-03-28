import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {TruckDriverWay} from '../domain/truck-driver-way';

@Injectable({
  providedIn: 'root'
})
export class TrackDriverService {

  private truckDriverWayBaseUrl = "http://localhost:8080/rest/api/truckdriverways";

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getTrackDriverService(): Observable<TruckDriverWay[]> {
    const searchUrl = `${this.truckDriverWayBaseUrl}/all`;

    return this.httpClient.get<TruckDriverWay[]>(searchUrl);
  }
}
