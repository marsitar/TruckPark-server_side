import {BrowserModule} from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {IconsProviderModule} from './icons-provider.module';
import {en_US, NgZorroAntdModule, NZ_I18N} from 'ng-zorro-antd';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DatePipe, registerLocaleData} from '@angular/common';
import pl from '@angular/common/locales/pl';
import {MapPreviewComponent} from './modules/map-preview/map-preview.component';
import {DriverPrevievComponent} from './modules/driver-previev/driver-previev.component';
import {TruckPrevievComponent} from './modules/truck-previev/truck-previev.component';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';
import {initializer} from './utils/app-init';

registerLocaleData(pl);

@NgModule({
  declarations: [
    AppComponent,
    MapPreviewComponent,
    DriverPrevievComponent,
    TruckPrevievComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    IconsProviderModule,
    NgZorroAntdModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    KeycloakAngularModule
  ],
  providers: [DatePipe, { provide: NZ_I18N, useValue: en_US},
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      multi: true,
      deps: [KeycloakService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
