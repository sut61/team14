import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class MoneyService {

  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getIdArtist(): Observable<any> {
    return this.http.get(this.API + '/Artist');
  }

  getIdIncome(): Observable<any> {
    return this.http.get(this.API + '/Income');
  }

  getIdExpenses(): Observable<any> {
    return this.http.get(this.API + '/Expenses');
  }

  getIdDress(): Observable<any> {
    return this.http.get(this.API + '/Dress');
  }

  getIdQueue(): Observable<any> {
    return this.http.get(this.API + '/Queue');
  }

  getIdManager(): Observable<any> {
    return this.http.get(this.API + '/Manager');
  }

  getIdMoney(): Observable<any> {
    return this.http.get(this.API + '/Money');
  }

  getFindQueue(id): Observable<any> {
    return this.http.get(this.API + '/findQueue/' + id);
  }
  getFindDress(id): Observable<any> {
    return this.http.get(this.API + '/findDress/' + id);
  }


  public postArtist(dataArtist:String,nameArtist:String):Observable<any>{
    return  this.http.post('//localhost:8080/artist',{
      "dataArtist":dataArtist,
      "nameArtist":nameArtist,
      
});
  }

  

}
