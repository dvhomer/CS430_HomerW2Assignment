import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { GenetictablePage } from './genetictable';


@NgModule({
  declarations: [
    GenetictablePage,
  ],
  imports: [
    IonicPageModule.forChild(GenetictablePage),
  ],
})
export class GenetictablePageModule {}
