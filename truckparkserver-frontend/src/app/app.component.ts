import {Component, OnInit} from '@angular/core';
import {KeycloakProfile} from 'keycloak-js';
import {KeycloakService} from 'keycloak-angular';
import {TruckParkSystemRoles} from './core/truck-park-system-roles';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  isCollapsed = false;
  roles = TruckParkSystemRoles;
  userDetails: KeycloakProfile;

  constructor(private keycloakService: KeycloakService) {}

  async ngOnInit() {
    if (await this.keycloakService.isLoggedIn()) {
      this.userDetails = await this.keycloakService.loadUserProfile();
    }
  }

  async doLogout() {
    await this.keycloakService.logout();
  }

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

