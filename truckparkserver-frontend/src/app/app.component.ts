import {Component, OnInit} from '@angular/core';
import {KeycloakProfile} from 'keycloak-js';
import {KeycloakService} from 'keycloak-angular';
import {TruckParkSystemRoles} from './core/truck-park-system-roles';
import {SecurityService} from './core/security.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  isCollapsed = false;
  roles = TruckParkSystemRoles;
  userDetails: KeycloakProfile;

  constructor(private keycloakService: KeycloakService,
              public securityService: SecurityService) {}

  async ngOnInit() {
    if (await this.keycloakService.isLoggedIn()) {
      this.userDetails = await this.keycloakService.loadUserProfile();
    }
    this.securityService.refreshToken();
  }

  async doLogout() {
    await this.keycloakService.logout();
  }
}

