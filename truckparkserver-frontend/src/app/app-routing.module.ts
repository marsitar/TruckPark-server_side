import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MapPreviewComponent} from './modules/map-preview/map-preview.component';
import {DriverMaintainComponent} from './modules/driver-maintain/driver-maintain.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/map-preview' },
  { path: 'map-preview', component: MapPreviewComponent },
  { path: 'driver-maintain', component: DriverMaintainComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
