import { Component, OnInit } from '@angular/core';
import { ManageService } from '../shared/manage/manage.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { LoginAdminComponent } from '../login-admin/login-admin.component';
@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  private username: any;
  private sub: any;
  typeContact: Array<any>;

  private manager = {
    id : '',
    name : '',
    username : '',
    password : '',
    gender : [],
    contact : []
  };

  contactSet: any = {
    contact : '',
    type : ''
  };
  constructor(private manageService:ManageService, private httpClient: HttpClient, private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
      this.username = params;
      console.log(this.username);
    });

     this.manageService.getManager(this.username.username).subscribe(data => {
      this.manager = data;
      console.log(this.manager);
    });

    this.manageService.getTypeContact().subscribe(data => {
      this.typeContact = data;
      console.log(this.typeContact);
    });
  }

  add() {

    if (this.contactSet.contact === '' || this.contactSet.type === ''){
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else {
      this.httpClient.post('http://localhost:8080/newContact/' + this.manager.username + '/' + this.contactSet.type + '/' +
        this.contactSet.contact,this.contactSet)
      .subscribe(
        data => {
          if(data) {
            alert('เพิ่มข้อมูลการติดต่อสำเร็จ');
            this.contactSet.contact = '';
            this.contactSet.type = '';
            console.log('PUT Request is successful', data);
          }
        },
        error => {
          console.log('Error', error);
        }
      );
    }
  }

    goManager(){
    this.router.navigate(['Manager/' + LoginAdminComponent.userName]);
  }

  goPractice(){
    this.router.navigate(['practice/table/' + LoginAdminComponent.userName]);
  }

  go() {
    this.router.navigate(['Manager/' + this.username.username]);
  }

  logout() {
    LoginAdminComponent.userName = null;
    this.router.navigate(['Login/admin']);
  }

}
