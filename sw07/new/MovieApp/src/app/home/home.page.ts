import {Component} from '@angular/core';
import {NativePage} from '../native/native.page';
import {NavController} from '@ionic/angular';

@Component({
    selector: 'app-home',
    templateUrl: 'home.page.html',
    styleUrls: ['home.page.scss'],
})
export class HomePage {

    constructor(public navCtrl: NavController) {

    }

    pushNativePage() {
        this.navCtrl.navigateForward();
    }
}
