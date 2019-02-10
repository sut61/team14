import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class WorkService {

  constructor(private http: HttpClient) { }
  public API = '//localhost:8080';

   getAllQuere() : Observable<any>{
      return this.http.get('//localhost:8080/Queres');
    }
  getOld(): Observable<any> {
    return this.http.get(this.API + '/Olds');
  }
  getFormat(): Observable<any> {
    return this.http.get(this.API + '/Formats');
  }


}
