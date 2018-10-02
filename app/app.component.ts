import { Component, ViewChild } from '@angular/core';
import { Nav, Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { SettingsPage } from '../pages/settings/settings';
import { HomePage } from '../pages/home/home';
import { AboutPage } from '../pages/about/about';
import { ChembalancerPage } from '../pages/chembalancer/chembalancer';
import { GenetictablePage } from '../pages/genetictable/genetictable';
import { App, NavController } from 'ionic-angular';

@Component({
  templateUrl: 'app.html'
})

export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage:any = HomePage;
  activePage: any;

  pages: Array < {title: string, pageName: string, component: any, index: number, icon: any}>;

  constructor(public platform: Platform, private statusBar: StatusBar, private splashScreen: SplashScreen) {
    this.initializeApp();

    this.pages = [
      {title: "Home", pageName: "HomePage", component: HomePage, index: 0, icon: "Home"},
      {title: "Genetic Table", pageName:"GenetictablePage", component: GenetictablePage, index: 1, icon: "Genetic Table"},
      {title: "Chemistry Balancer", pageName:"ChembalancerPage", component: ChembalancerPage, index: 2, icon: "Chemical Balancer"},
      {title: "Settings", pageName:"SettingsPage", component: SettingsPage, index: 3, icon: "Settings"},
      {title: "About", pageName:"AboutPage", component: AboutPage, index: 4, icon: "About"}
      
      
    ];

    this.activePage = this.pages[0];

    
    
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }

  openPage(page) {
    this.nav.setRoot(page.component);
    this.activePage = page.component;
  }

  
  checkActive(page) {
    return page = this.activePage;

  }

  


}
