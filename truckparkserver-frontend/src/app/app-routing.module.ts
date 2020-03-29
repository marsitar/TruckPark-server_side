import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MapPreviewComponent} from './modules/map-preview/component/map-preview.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/map-preview' },
  { path: 'map-preview', component: MapPreviewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
