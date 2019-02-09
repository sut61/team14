import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PracticeService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getBand(): Observable<any> {
    return this.http.get(this.API + '/Band');
  }

  getRoom(): Observable<any> {
    return this.http.get(this.API + '/Room');
  }

  getTypePractice(): Observable<any> {
    return this.http.get(this.API + '/TypePractice');
  }

  getPractice(): Observable<any> {
    return this.http.get(this.API + '/Practice');
  }

}
