import { NgModule } from '@angular/core';
import { FooterComponent } from 'src/app/footer/footer.component';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';

@NgModule({
  imports: [
    CommonModule,
    IonicModule
  ],
  declarations: [
    FooterComponent
  ],
  exports: [FooterComponent]
})
export class CustomCommonModule {}
