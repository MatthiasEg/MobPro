import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Movie} from '../../interfaces/Movie';
import {NavController} from '@ionic/angular';

@Component({
  selector: 'app-search',
  templateUrl: './search.page.html',
  styleUrls: ['./search.page.scss'],
})
export class SearchPage implements OnInit {

  searchQuery: string;

  constructor(
      private httpClient: HttpClient,
      private navController: NavController
  ) {

  }

  ngOnInit() {
  }

  searchButtonPressed() {
    const movieJson = this.httpClient.get('http://www.omdbapi.com/?apikey=4f04280a&plot=short&r=json&t=' + this.searchQuery);

    async function presentAlert() {
      const alertController = document.querySelector('ion-alert-controller');
      await alertController.componentOnReady();

      const alert = await alertController.create({
        header: 'Error',
        subHeader: 'here is the subtitle',
        message: 'Ups, something went wrong. Server message was: "Movie not found!"',
        buttons: ['TRY AGAIN...']
      });
      return await alert.present();
    }

    movieJson.subscribe(data => {
      const movie: Movie = <Movie>data;
      // const detailModule = new DetailsPage();
      if (movie.Response === 'True') {
        // this.navController.push(detailModule.getPage());
      } else {
        presentAlert();
      }
    });
  }

}
