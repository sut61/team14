import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { throwMatDialogContentAlreadyAttachedError } from '@angular/material';
import { Router, RouterModule } from '@angular/router';
import { ArtistsService } from '../shared/artists/artists.service';

@Component({
  selector: 'app-artists',
  templateUrl: './artists.component.html',
  styleUrls: ['./artists.component.css']
})
export class ArtistsComponent implements OnInit {
    genders: Array<any>;
    bands:Array<any>;
    managers:Array<any>;
    typeMusics:Array<any>;

    setData: any = {
      genderIdSelect: '',
      managerIdSelect: '',
      typeMusicIdSelect: '',
      bandIdSelect: '',

      firstname : '',
      lastname : '',
      nickname : '',
      birthday: '',
      phoneInput : ''
    };
showError = '';
  constructor(private httpClient: HttpClient,private service: ArtistsService,private router: Router) { }

  ngOnInit() {
    this.getGender();
    this.getManager();
    this.getAllBand();
    this.getTypeMusic();
  }

   getAllBand() {
       this.service.getAllBand().subscribe(data => {
         this.bands = data;
       })
     }
    getGender() {
       this.service.getGender().subscribe(data => {
         this.genders = data;
       })
     }

     getTypeMusic() {
            this.service.getTypeMusic().subscribe(data => {
              this.typeMusics = data;
            })
          }

      getManager() {
             this.service.getManager().subscribe(data => {
               this.managers = data;
               console.log(this.managers);
             })
           }
       test(data: any) {
           console.log(data);
         }

         save() {
               this.httpClient.post('http://localhost:8080/artists/create/' + this.setData.firstname + '/' + this.setData.lastname
               + '/'+this.setData.nickname+'/'+this.setData.birthday+'/'+0+this.setData.phoneInput+'/'+this.setData.genderIdSelect+'/'+this.setData.managerIdSelect+'/'+this.setData.bandIdSelect+'/'+this.setData.typeMusicIdSelect,this.setData)
               .subscribe(data => {

                   console.log('PUT Request is successful', data);
                   this.router.navigate(['show-artists']);
                 },
                 error =>{
                     console.log('Error', error);
                     this.showError = "กรอกข้อมูลผิดพลาด"
                   }
                 );
}
logout() {
  this.router.navigate(['Login/admin']);
}
 goManager(){
    this.router.navigate(['Manager/' + this.username.username]);
  }

  goPractice(){
    this.router.navigate(['practice/table/' + this.username.username]);
  }
}
