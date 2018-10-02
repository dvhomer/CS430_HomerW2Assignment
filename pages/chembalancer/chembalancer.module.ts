import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ChembalancerPage } from './chembalancer';

@NgModule({
  declarations: [
    ChembalancerPage,
  ],
  imports: [
    IonicPageModule.forChild(ChembalancerPage),
  ],
})
export class ChembalancerPageModule {}
