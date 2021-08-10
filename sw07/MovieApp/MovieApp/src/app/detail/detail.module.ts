import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { IonicModule } from '@ionic/angular';
import { DetailPage } from './detail.page';
import { CustomCommonModule } from 'src/core/CustomCommonModule';



const routes: Routes = [
  {
    path: ':movie',
    component: DetailPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    CustomCommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    DetailPage
  ]
})
export class DetailPageModule {}
