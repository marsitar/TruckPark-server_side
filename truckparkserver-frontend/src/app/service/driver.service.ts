import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Driver} from '../domain/driver';

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  private driverBaseUrl = "http://localhost:8080/rest/api/drivers";

  constructor(
    private httpClient: HttpClient
  ) { }

  getDriverById(id: number): Observable<Driver>{
    const searchUrl = `${this.driverBaseUrl}/driver/${id}`;

    return this.httpClient.get<Driver>(searchUrl);
  }

  getAllDrivers(): Observable<Driver[]>{
    const searchUrl = `${this.driverBaseUrl}/all`;

    return this.httpClient.get<Driver[]>(searchUrl);
  }
}
