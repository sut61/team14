import { Component, OnInit } from '@angular/core';
import { ManageService } from '../shared/manage/manage.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {
  private username: any;
  genders: Array<any>;
  managerSet: any = {
    name : '',
    gender : '',
    username : '',
    password : ''
  };
  manager: any;

  constructor(private manageService:ManageService, private httpClient: HttpClient, private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
    this.rout.params.subscribe(params => {
      this.username = params;
      console.log(this.username);
    });

    this.manageService.getGender().subscribe(data => {
      this.genders = data;
      console.log(this.genders);
    });
  }

  save() {

    if (this.managerSet.name === '' || this.managerSet.gender === '' || this.managerSet.username === '' || this.managerSet.password === ''){
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else {
      this.httpClient.post('http://localhost:8080/newManager/' + this.managerSet.name + '/' + this.managerSet.gender + '/' +
        this.managerSet.username + '/' + this.managerSet.password ,this.managerSet)
      .subscribe(
        data => {
          this.manager = data;
          console.log('PUT Request is successful', data);
          if(data){
                  this.router.navigate(['Manager/newContact/' + this.manager.username]);
          }
        },
        error => {
          console.log('Error', error);
        }
      );
    }

  }

  logout() {
    this.router.navigate(['Login/admin']);
  }

  back(){
    this.router.navigate(['Manager/' + this.username.username]);
  }

  goManager(){
    this.router.navigate(['Manager/' + this.username.username]);
  }


}
