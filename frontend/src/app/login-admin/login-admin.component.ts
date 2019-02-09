import { Component, OnInit } from '@angular/core';
import { ManageService } from '../shared/manage/manage.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {
  public static userName:string;

  usernameLogin = '';
  passwordLogin = '';

  showError = '';
  constructor(private manageService:ManageService, private httpClient: HttpClient, private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
  }

  login(){
    if(this.usernameLogin == '' || this.passwordLogin == ''){
      this.showError = 'Please fill in Username and Password';

    }else{
      this.manageService.getManager(this.usernameLogin).subscribe(data=>{
        console.log(data);
        if(data){
          if(this.passwordLogin == data.password){
            LoginAdminComponent.userName = data.username;
            this.router.navigate(['Manager/' + data.username]);
          }
          else{
            this.showError = 'Password invalid';
          }
        }else {
          this.showError = 'Username invalid';
        }

      },error=>{
          console.log('Error', error);
      })

    }
  }

}
