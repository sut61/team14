import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable()
export class AlbumsService {

  constructor(private http: HttpClient) { }

  public API = '//localhost:8080';

  getAllAlbums() : Observable<any>{
    return this.http.get('//localhost:8080/albums');
  }

  getAlbumsID(albumsID:number) : Observable<any>{
    return this.http.get('//localhost:8080/album/'+albumsID);
  }
  getAllBand() : Observable<any>{
    return this.http.get('//localhost:8080/Band');
  }

  getAllProducer() : Observable<any>{
    return this.http.get('//localhost:8080/Producer');
  }
  getAllSong() : Observable<any>{
    return this.http.get('//localhost:8080/Song');
  }

  private albums = new BehaviorSubject('default message');
  currentMessage = this.albums.asObservable();

  adder(name: string) {
    this.albums.next(name);
  }
}
