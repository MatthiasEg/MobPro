import {Component, OnInit} from '@angular/core';
import {NavController} from 'ionic-angular';
import {NativePage} from '../native/native.page';

@Component({
    selector: 'app-home',
    templateUrl: 'home.page.html',
    styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

    public battery: string;

    constructor(
        public navCtrl: NavController
    ) {

    }

    pushNativePage() {
        this.navCtrl.push(NativePage);
    }

    ngOnInit() {
    }
}
