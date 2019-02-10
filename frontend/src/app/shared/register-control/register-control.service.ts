import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class RegisterControlService {

  constructor(private httpClient: HttpClient) {

  }

  //====== Pofile =======

  public postMember(username: string, password: string): Observable<any> {
    return this.httpClient.post('//localhost:8080/member', {
      "memUser": username,
      "memPassword": password
    });
  }

  public postProfile(
    nameProfile: string,
    genderSelect: number,
    countrySelect: string,
    idCardProfile: number,
    phoneProfile: string,
    addressProfile: string,
    pastalCodeProfile: number,
    member: string): Observable<any> {
    return this.httpClient.post('//localhost:8080/profile/' + genderSelect + '/' + countrySelect + '/' + member, {
      "name": nameProfile,
      "addressDetail": addressProfile,
      "pastalCade": pastalCodeProfile,
      "mobilePhone": phoneProfile
    });
  }


  public postIDCard(
    idCardProfile: number,
    birthDayProfile: string,
    profileID: number): Observable<any> {
    return this.httpClient.post('//localhost:8080/idCard/' + profileID, {
      "cardIdNum": idCardProfile,
      "brithDay": birthDayProfile
    });
  }


  public getCountry(): Observable<any> {
    return this.httpClient.get('//localhost:8080/countrys');
  }
  public getGender(): Observable<any> {
    return this.httpClient.get('//localhost:8080/gender');
  }
  public getIDCardByProfileId(idCardNum: number): Observable<any> {
    return this.httpClient.get('//localhost:8080/idCard/profile/' + idCardNum);
  }

  public getMemberByUsername(username: string): Observable<any> {
    return this.httpClient.get('//localhost:8080/member/' + username);
  }

  public getProfileByUsername(username: string): Observable<any> {
    return this.httpClient.get('//localhost:8080/profile/member/' + username);
  }



  // ========= Privilege VIP ==========


  public postPrivilegeVIP(
    cardNumShow: string, cvvNumShow: string, emailProfile: string,
    monthSelect: string, yearSelect: string,
    profileID: number, bandSelect: string,
    privilegeSelect: string): Observable<any> {
    return this.httpClient.post('//localhost:8080/Privilege/' + monthSelect + '/' + yearSelect + '/'
      + profileID + '/' + bandSelect + '/' + privilegeSelect, {
        "numCredit": cardNumShow,
        "numCvv": cvvNumShow,
        "email": emailProfile
      });
  }

  getShowPrivilege(): Observable<any> {
    return this.httpClient.get('//localhost:8080/Privilege');
  }

  public getVIPbyProfile(profileId: number): Observable<any> {
    return this.httpClient.get('//localhost:8080/Privilege/profile/' + profileId);
  }

  public getPrivilegeVIP(idVIP: number): Observable<any> {
    return this.httpClient.get('//localhost:8080/Privilege/' + idVIP);
  }
  public getBand(): Observable<any> {
    return this.httpClient.get('//localhost:8080/Band');
  }
  public getExpMonth(): Observable<any> {
    return this.httpClient.get('//localhost:8080/expMonth');
  }
  public getExpYear(): Observable<any> {
    return this.httpClient.get('//localhost:8080/expYear');
  }
  public getTypePrivilege(): Observable<any> {
    return this.httpClient.get('//localhost:8080/typePrivilege');
  }
  




}
