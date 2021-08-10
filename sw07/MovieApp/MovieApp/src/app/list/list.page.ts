import { Component, OnInit } from '@angular/core';
import { Movie } from 'src/interfaces/movie';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-list',
  templateUrl: 'list.page.html',
  styleUrls: ['list.page.scss']
})
export class ListPage implements OnInit {
  private selectedItem: any;
  favoriteMovies: Movie[] = []

  constructor(
    private _httpClient: HttpClient) { }

  async ngOnInit() {
    for (let i = 1; i <= 5; i++) {
      let movie = await this._httpClient.get<Movie>(`../assets/movies/${i}.json`).toPromise();
      if (movie) {
        this.favoriteMovies.push(movie);
      }
    }
  }
}
