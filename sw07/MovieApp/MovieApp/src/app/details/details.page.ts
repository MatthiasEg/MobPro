import {Component, OnInit} from '@angular/core';
import {Movie} from '../../interfaces/Movie';

@Component({
    selector: 'app-details',
    templateUrl: 'details.page.html',
    styleUrls: ['details.page.scss']
})
export class DetailsPage {

    constructor(movie: Movie) {

    }

    public getPage() {
        return DetailsPage;
    }

}
