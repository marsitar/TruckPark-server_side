import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MapPreviewComponent} from './modules/map-preview/map-preview.component';
import {DriverPrevievComponent} from './modules/driver-previev/driver-previev.component';
import {TruckPrevievComponent} from './modules/truck-previev/truck-previev.component';
import {AppAuthGuard} from './app.authguard';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/driver-preview', canActivate: [AppAuthGuard], data: { roles: ['USER'] } },
  { path: 'map-preview', component: MapPreviewComponent, canActivate: [AppAuthGuard], data: { roles: ['USER'] } },
  { path: 'driver-preview', component: DriverPrevievComponent, canActivate: [AppAuthGuard], data: { roles: ['USER'] } },
  { path: 'truck-preview', component: TruckPrevievComponent, canActivate: [AppAuthGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [AppAuthGuard],
})
export class AppRoutingModule { }
