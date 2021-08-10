import { Component, OnInit } from '@angular/core';
import { MovieService } from 'src/core/movie.service';
import { Movie } from 'src/interfaces/movie';
import { AlertController, NavController } from '@ionic/angular';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-search',
  templateUrl: './search.page.html',
  styleUrls: ['./search.page.scss'],
})
export class SearchPage implements OnInit {

  searchTerm: string = "";

  constructor(
    private _movieService: MovieService,
    private _alertController: AlertController,
    private _navController: NavController) { }
    private _httpClient: HttpClient

  ngOnInit() {
  }

  public async searchForMovie() {
    let movieResult = await this._movieService.searchMovie(this.searchTerm);
    if (movieResult.Response == 'True') {
      this.routeToDetailView(movieResult);
    } else {
      await this.showErrorAlert(movieResult.Error);
    }
  }

  private async showErrorAlert(errorMessage: string) {
    const alert = await this._alertController.create({
      header: 'Error',
      message: errorMessage,
      buttons: ['Try again']
    });
    return await alert.present();
  }
  private routeToDetailView(movieResult: Movie) {
    this._navController.navigateForward(['/detail', movieResult.Title]);
  }
}
