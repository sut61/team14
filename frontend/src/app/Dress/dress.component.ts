import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
export interface PeriodicElement { }

@Component({
  selector: 'app-dress',
  templateUrl: './dress.component.html',
  styleUrls: ['./dress.component.css']
})
export class DressComponent implements OnInit {

  title = 'เสื้อผ้าศิลปิน';
  types = [];
  sizes = [];
  events = [];
  namearts = [];

  artist_id: '';
  dress_id: '';
 

  onClickSubmit(data) {

    console.log(data);
    this.http.post("http://localhost:8080/dress", data).subscribe(

      data => {
        console.log("POST Request is successful ", data);
        alert("สำเร็จ")
      },
      error => {
        console.log("Error", error);
        alert("ผิดพลาด ไม่พบ ID Artist " + error)
      });
    
  }
      
    
    constructor( private http: HttpClient) {}
   ngOnInit() {
    
    this.http.get("http://localhost:8080/type").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.types.push({
            value: data[index].id,
            viewValue: data[index].type
          })
        }
        console.log(data);
        
      },
      error => {
        console.log("Error", error);
      }
    );
    this.http.get("http://localhost:8080/size").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.sizes.push({
            value: data[index].id,
            viewValue: data[index].size
          })
        }
        console.log(data);
        
      },
      error => {
        console.log("Error", error);
      }
    );

    this.http.get("http://localhost:8080/event").subscribe(
      data => {
        console.log("GET Request is successful ", data);
        for (let index = 0; index < data["length"]; index++) {
          this.events.push({
            value: data[index].id,
            viewValue: data[index].event
          })
        }
        console.log(data);
        
      },
      error => {
        console.log("Error", error);
      }
    );
  }
}


