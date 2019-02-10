import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Router} from '@angular/router';
import { LoginAdminComponent } from '../login-admin/login-admin.component';
export interface PeriodicElements { }

@Component({
  selector: 'app-sponserdress',
  templateUrl: './sponserdress.component.html',
  styleUrls: ['./sponserdress.component.css']
})
export class SponserDressComponent implements OnInit {


  title = 'Sponser';
  sponserdress= '';
  status_id = [] ;
  dress= [];
  artists= [];
  showError : String;
  onClickSubmit(data) {
    if(this.sponserdress != null && data.date != null && data.datere != null){
      data.date = data.date.getTime()
      data.datere = data.datere.getTime()
    }
    console.log(data);
    this.http.post("http://localhost:8080/sponser", data).subscribe(

      data => {
        console.log("POST Request is successful ", data);
        alert("successful")
        this.showError = "สำเร็จ"
      },
      error => {
        console.log("Error", error);
        alert("ข้อมูลผิดพลาด Error")
        this.showError = "ข้อมูลผิดพลาด Error"
      });

  }
  constructor( private http: HttpClient,  private router: Router) {}
  ngOnInit() {

   this.http.get("http://localhost:8080/statusdress").subscribe(
     data => {
       console.log("GET Request is successful ", data);
       for (let index = 0; index < data["length"]; index++) {
         this.status_id.push({
           value: data[index].id,
           viewValue: data[index].statusdress
         })
       }
       console.log(data);

     },
     error => {
       console.log("Error", error);
     }
     );

     this.http.get("http://localhost:8080/dress").subscribe(
       data => {
         console.log("GET Request is successful ", data);
         for (let index = 0; index < data["length"]; index++) {
           this.dress.push({
             value: data[index].id,
             viewValue: data[index].dress
           })
         }
         console.log(data);

       },
       error => {
         console.log("Error", error);
       }
     );

     this.http.get("http://localhost:8080/artists").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.artists.push({
            value: data[index].artistsID,
            viewValue: data[index].band.bandname
          })
        }
        console.log(data);

      },
      error => {
        console.log("Error", error);
      }
    );
}
logout() {
    LoginAdminComponent.userName = null;
    this.router.navigate(['Login/admin']);
  }
  goManager(){
    this.router.navigate(['Manager/' + LoginAdminComponent.userName]);
  }

  goPractice(){
    this.router.navigate(['practice/table/' + LoginAdminComponent.userName]);
  }
}
