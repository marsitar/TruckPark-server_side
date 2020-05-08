import {Injectable} from '@angular/core';
import {TruckParkSystemRoles} from './truck-park-system-roles';
import {KeycloakService} from 'keycloak-angular';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
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
}
