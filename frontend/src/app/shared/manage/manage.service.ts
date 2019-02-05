import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManageService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getGender(): Observable<any> {
    return this.http.get(this.API + '/gender');
  }

  getManager(username): Observable<any> {
    return this.http.get(this.API + '/Manager/' + username);
  }

  getTypeContact(): Observable<any> {
    return this.http.get(this.API + '/TypeContact');
  }
}
