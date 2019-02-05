import { Component, OnInit } from '@angular/core';
import { QuereService} from '../shared/book/quere.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { LoginCusComponent } from '../login-cus/login-cus.component';
import { RegisterControlService } from 'src/app/shared/register-control/register-control.service';
@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  private username :any;
  private sub : any;
  band: Array<any>;
  typeWorks: Array<any>;
  user: any;

  setData: any = {
    username :'',
    place : '',
    date : '',
    hour : '',
    hrs : '',
    mins : '',
    artistSelect : '',
    typeWorkSelect : ''
  }
  Quere: any= {
    id: '',
    artistQuere: {},
    membersQuere: {},
    placeQuere: {},
    typeworkQuere: {},
    statusQuere: {}
  }

  constructor(private quereService:QuereService, private httpClient: HttpClient, private router: Router,
    private rout: ActivatedRoute,private registerController: RegisterControlService) {
      if (typeof LoginCusComponent.userName === 'undefined' || LoginCusComponent.userName == null) {
        this.router.navigate(['login'])
      }
      console.log(LoginCusComponent.userName);
     }


  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.username = params;
        this.setData.username = this.username.username;
        console.log(this.username.username);
    })

    this.quereService.getBand().subscribe(data => {
      this.band = data;
      console.log(this.band);
    });

    this.quereService.getTypeWork().subscribe(data => {
      this.typeWorks = data;
      console.log(this.typeWorks);
    });

    this.quereService.getMembers(this.username.username).subscribe(data => {
      this.user = data;
      console.log(this.user);
      console.log(this.user.quereSet[0]);
    });

  }

  save() {
    if (this.setData.artistSelect === '' || this.setData.typeWorkSelect === '' || this.setData.place === '' || this.setData.date === '' ||
    this.setData.hour === '' || this.setData.hrs === '' || this.setData.mins === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else{
      if (this.user.quereSet[0] == undefined || this.user.quereSet[0].statusQuere.statusId != 1) {
        this.httpClient.post('http://localhost:8080/Quere/' + this.setData.place + '/' + this.setData.date + '/' +
        this.setData.hour + '/' + this.setData.hrs + '/' + this.setData.mins + '/' + this.setData.artistSelect + '/' +
        this.setData.username + '/' + this.setData.typeWorkSelect ,this.setData)
        .subscribe(data => {
          if(data){
            alert('การจองเสร็จสิ้น');
            this.router.navigate(['bookshow/' + this.setData.username]);
           console.log('PUT Request is successful', data);
          }
        },
          error => {
            console.log('Error', error);
          }
        );
      }else{
        alert(' ขออภัย พบการจองที่ยังไม่ได้รับการยืนยัน');
      }
    }  
  }

  history(){
    this.router.navigate(['bookshow/' + this.setData.username]);
  }

  logout() {
    LoginCusComponent.userName = null;
    this.router.navigate(['login-cus']);
  }
}
