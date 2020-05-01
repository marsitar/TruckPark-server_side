import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {KeycloakService} from 'keycloak-angular';
import {Observable} from 'rxjs';

@Injectable()
export class KeycloakTokenInterceptorService implements HttpInterceptor {

  constructor(
    private keyCloakService: KeycloakService
  ) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(this.addAuthenticationToken(request));
  }

  addAuthenticationToken(request) {
    const accessToken = this.keyCloakService.getToken();

    return request.clone({
      withCredentials: true,
      setHeaders: {
        Authorization: 'Bearer ' + accessToken,
      }
    });
  }
}
