import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {IconsProviderModule} from './icons-provider.module';
import {en_US, NgZorroAntdModule, NZ_I18N} from 'ng-zorro-antd';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {DatePipe, registerLocaleData} from '@angular/common';
import en from '@angular/common/locales/en';
import {MapPreviewComponent} from './modules/map-preview/map-preview.component';
import {DriverMaintainComponent} from './modules/driver-maintain/driver-maintain.component';
import {DriverPrevievComponent} from './modules/driver-previev/driver-previev.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    MapPreviewComponent,
    DriverMaintainComponent,
    DriverPrevievComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    IconsProviderModule,
    NgZorroAntdModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [DatePipe, { provide: NZ_I18N, useValue: en_US}],
  bootstrap: [AppComponent]
})
export class AppModule { }
