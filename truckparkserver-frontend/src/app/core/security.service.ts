import {Injectable} from '@angular/core';
import {TruckParkSystemRoles} from './truck-park-system-roles';
import {KeycloakService} from 'keycloak-angular';
import {timer} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  private refreshTimer$ = timer(840000, 840000);

  constructor(private keycloakService: KeycloakService) { }

  isCallerInRole(truckParkSystemRole: TruckParkSystemRoles): boolean {
    return this.keycloakService.isUserInRole(truckParkSystemRole);
  }

  isCallerInRoles(...roles): boolean {
    roles.forEach( role => {
        if (!this.keycloakService.isUserInRole(role)) {
          return false;
        }
      }
    );
    return true;
  }

  getUsername(){
    return this.keycloakService.getUsername();
  }

  refreshToken() {
    return this.refreshTimer$.subscribe( value =>
      this.keycloakService.updateToken(30000).then( refreshed => {
        if(refreshed) {
          console.log('Token has been refreshed.');
        } else {
          console.log('Token is valid.');
        }
    }));
  }
}
