import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {IonicModule} from '@ionic/angular';
import {RouterModule} from '@angular/router';

import {DetailsPage} from './details.page';
import {Movie} from '../../interfaces/Movie';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        RouterModule.forChild([
            {
                path: '',
                component: DetailsPage
            }
        ])
    ],
    declarations: [DetailsPage]
})
export class DetailsModule {


}
