import { NgModule, ErrorHandler } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { MyApp } from './app.component';
import { App, NavController } from 'ionic-angular';

import { AboutPage } from '../pages/about/about';
import { HomePage } from '../pages/home/home';

import { SettingsPage } from '../pages/settings/settings';


import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { ChembalancerPage } from '../pages/chembalancer/chembalancer';
import { GenetictablePage } from '../pages/genetictable/genetictable';
import { GenetictableProvider } from '../providers/genetictable/genetictable';


@NgModule({
  declarations: [
    MyApp,
    AboutPage,
    HomePage,
    
    SettingsPage,
    ChembalancerPage,
    GenetictablePage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    AboutPage,
    HomePage,
    
    SettingsPage,
    ChembalancerPage,
    GenetictablePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    GenetictableProvider,
    
    
  ]
})
export class AppModule {}
