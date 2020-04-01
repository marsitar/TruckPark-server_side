import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Mop} from '../domain/mop';

@Injectable({
  providedIn: 'root'
})
export class MopService {

  private mopBaseUrl = "http://localhost:8080/rest/api/mops";

  constructor(
    private httpClient: HttpClient
  ) { }

  getMops(): Observable<Mop[]> {
    const searchUrl = `${this.mopBaseUrl}/all`;

    return this.httpClient.get<Mop[]>(searchUrl);
  }
}
