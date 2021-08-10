import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movie } from 'src/interfaces/movie';
import { MovieService } from 'src/core/movie.service';
import { LoadingController } from '@ionic/angular';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.page.html',
  styleUrls: ['./detail.page.scss'],
})
export class DetailPage implements OnInit {

  private movie: Movie;
  private loadingElement: HTMLIonLoadingElement;

  constructor(
    private _route: ActivatedRoute,
    private _movieService: MovieService,
    private _loadingController: LoadingController) { }

  async ngOnInit() {
    await this.presentLoading();
    await this.loadMovie();
    await this.loadingElement.dismiss();
  }

  private async loadMovie() {
    let movieTitle = this._route.snapshot.paramMap.get("movie");
    if (movieTitle) {
      this.movie = await this._movieService.searchMovie(movieTitle);
    }
  }

  private async presentLoading() {
    this.loadingElement = await this._loadingController.create({
      message: 'Loading...'
    });
    await this.loadingElement.present();
  }
}
