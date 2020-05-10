import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MapPreviewComponent} from './modules/map-preview/map-preview.component';
import {DriverPrevievComponent} from './modules/driver-previev/driver-previev.component';
import {TruckPrevievComponent} from './modules/truck-previev/truck-previev.component';
import {AppAuthGuard} from './app.authguard';
import {TruckParkSystemRoles} from './core/truck-park-system-roles';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/driver-preview', canActivate: [AppAuthGuard] },
  { path: 'map-preview', component: MapPreviewComponent, canActivate: [AppAuthGuard], data: { roles: [TruckParkSystemRoles.DRIVER_READ, TruckParkSystemRoles.TRUCK_READ, TruckParkSystemRoles.MOP_READ, TruckParkSystemRoles.TDW_READ] } },
  { path: 'driver-preview', component: DriverPrevievComponent, canActivate: [AppAuthGuard], data: { roles: [TruckParkSystemRoles.DRIVER_READ, TruckParkSystemRoles.TRUCK_READ] } },
  { path: 'truck-preview', component: TruckPrevievComponent, canActivate: [AppAuthGuard], data: { roles: [TruckParkSystemRoles.TRUCK_READ] } },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AppAuthGuard],
})
export class AppRoutingModule { }
