import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';



@Injectable()
export class SongService {
  constructor(private http: HttpClient) { }

  public API = '//localhost:8080';

  getAllSong():Observable<any>{
    return this.http.get('//localhost:8080/Song');
  }

  getAllAlbums(albumsID:number) : Observable<any>{
    return this.http.get('//localhost:8080/albums'+albumsID);
  }
}
