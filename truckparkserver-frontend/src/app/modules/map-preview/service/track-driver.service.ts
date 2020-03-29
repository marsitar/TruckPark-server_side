import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {TruckDriverWay} from '../domain/truck-driver-way';
import {Truck} from '../domain/truck';
import {Driver} from '../domain/driver';

@Injectable({
  providedIn: 'root'
})
export class TrackDriverService {

  private truckDriverWayBaseUrl = "http://localhost:8080/rest/api/truckdriverways";
  private truckBaseUrl = "http://localhost:8080/rest/api/trucks";
  private driverBaseUrl = "http://localhost:8080/rest/api/drivers";


  constructor(
    private httpClient: HttpClient
  ) {
  }

  getTrackDriverService(): Observable<TruckDriverWay[]> {
    const searchUrl = `${this.truckDriverWayBaseUrl}/all`;

    return this.httpClient.get<TruckDriverWay[]>(searchUrl);
  }

  getTruckById(id: number): Observable<Truck>{
    const searchUrl = `${this.truckBaseUrl}/${id}`;

    return this.httpClient.get<Truck>(searchUrl);
  }


  getDriverById(id: number): Observable<Driver>{
    const searchUrl = `${this.driverBaseUrl}/driver/${id}`;

    return this.httpClient.get<Driver>(searchUrl);
  }

  getAllDrivers(): Observable<Driver[]>{
    const searchUrl = `${this.driverBaseUrl}/all`;

    return this.httpClient.get<Driver[]>(searchUrl);
  }

  getLastTruckDriverWayByDriverId(driverId: number): Observable<TruckDriverWay>{
    const searchUrl = `${this.truckDriverWayBaseUrl}/lasttruckdriverwaybydriverid/${driverId}`;

    return this.httpClient.get<TruckDriverWay>(searchUrl);
  }
}
