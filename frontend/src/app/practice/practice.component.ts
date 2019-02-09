import { Component, OnInit } from '@angular/core';
import { ManageService } from '../shared/manage/manage.service';
import { PracticeService } from '../shared/practice/practice.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { LoginAdminComponent } from '../login-admin/login-admin.component';

@Component({
  selector: 'app-practice',
  templateUrl: './practice.component.html',
  styleUrls: ['./practice.component.css']
})
export class PracticeComponent implements OnInit {
  private username: any;
  manager: Array<any>;
  typePractice: any;
  room: Array<any>;
  band: Array<any>;

  showError = '';

  practiceSet: any = {
    trainer: '',
    date: '',
    startTime: '',
    endTime: '',
    detail: '',
    idRoom: '',
    idType: '',
    idBand: '',
    username: ''
  };

  constructor(private manageService:ManageService, private httpClient: HttpClient, private router: Router,
              private rout: ActivatedRoute, private practiceService:PracticeService){
    console.log(LoginAdminComponent.userName);
  }

  ngOnInit() {
    this.rout.params.subscribe(params => {
      this.username = params;
      console.log(this.username);
    });

     this.manageService.getManager(this.username.username).subscribe(data => {
      this.manager = data;
      this.practiceSet.username = this.username.username;
      console.log(this.manager);
    });

    this.practiceService.getTypePractice().subscribe(data => {
      this.typePractice = data;
      console.log(this.typePractice);
    });

    this.practiceService.getRoom().subscribe(data => {
      this.room = data;
      console.log(this.room);
    });

  this.practiceService.getBand().subscribe(data => {
      this.band = data;
      console.log(this.band);
    });

  }

  save(){
    console.log(this.practiceSet);
    if (this.practiceSet.date === '' || this.practiceSet.startTime === '' || this.practiceSet.endTime === '' ||
      this.practiceSet.detail === '' || this.practiceSet.idRoom === '' || this.practiceSet.idType === '' ||
      this.practiceSet.idBand === ''){
        this.showError = 'Please fill out this form.';
    }else{
      if(this.practiceSet.trainer === ''){
        this.practiceSet.trainer = 'none';
      }
      this.httpClient.post('http://localhost:8080/newPractice/' + this.practiceSet.trainer + '/' + this.practiceSet.date + '/' +
        this.practiceSet.startTime + '/' + this.practiceSet.endTime + '/' + this.practiceSet.detail + '/' +
        this.practiceSet.idRoom  + '/' + this.practiceSet.idType + '/' + this.practiceSet.idBand + '/' +
        this.practiceSet.username,this.practiceSet)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
          if(data){
                  this.router.navigate(['practice/table/' + LoginAdminComponent.userName]);
          }
        },
        error => {
          this.showError = 'การใส่ข้อมูลผิดพลาด';
          console.log('Error', error);
        }
      );
    }
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
