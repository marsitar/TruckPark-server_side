import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MapPreviewComponent} from './modules/map-preview/map-preview.component';
import {DriverPrevievComponent} from './modules/driver-previev/driver-previev.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/driver-preview' },
  { path: 'map-preview', component: MapPreviewComponent },
  { path: 'driver-preview', component: DriverPrevievComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
