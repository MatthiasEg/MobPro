
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from 'src/interfaces/movie';


@Injectable()
export class MovieService {

    private apiKey = '4f04280a';
    private omdbUrl = 'http://www.omdbapi.com';
    private apiUrl: string;

    constructor(private _httpClient: HttpClient) {
        this.apiUrl = `${this.omdbUrl}?apikey=${this.apiKey}&plot=short&r=json&`;
    }

    public async searchMovie(movieTitle: string): Promise<Movie> {
        const movieTitleWithEscapedSpaces = this.addPlusToSpaces(movieTitle);
        return await this._httpClient.get<Movie>(`${this.apiUrl}t=${movieTitleWithEscapedSpaces}`).toPromise();
    }

    private addPlusToSpaces(movieTitle: string): string {
        return movieTitle.replace(/ +/g, '+');
    }
}
