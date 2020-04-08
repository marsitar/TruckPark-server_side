import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Truck} from '../domain/truck';
import {Driver} from '../domain/driver';

@Injectable({
  providedIn: 'root'
})
export class TruckService {

  private truckBaseUrl = "http://localhost:8080/rest/api/trucks";

  constructor(
    private httpClient: HttpClient
  ) { }

  getTruckById(id: number): Observable<Truck>{
    const searchUrl = `${this.truckBaseUrl}/${id}`;
    return this.httpClient.get<Truck>(searchUrl);
  }

  getTrucks(): Observable<Truck[]>{
    const searchUrl = `${this.truckBaseUrl}/all`;
    return this.httpClient.get<Truck[]>(searchUrl);
  }

  addTruck(truck: Truck){
    const searchUrl = `${this.truckBaseUrl}/truck`;
    return this.httpClient.post(searchUrl, truck);
  }

  updateTruck(truck: Truck){
    const searchUrl = `${this.truckBaseUrl}/truck`;
    return this.httpClient.put<Driver>(searchUrl, truck);
  }

  deleteTruck(truckId: number){
    const searchUrl = `${this.truckBaseUrl}/truck/${truckId}`;
    return this.httpClient.delete(searchUrl);
  }
}
