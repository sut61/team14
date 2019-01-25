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

  usernameLogin:string;
  passwordLogin:string;

  constructor(private manageService:ManageService, private httpClient: HttpClient, private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
  }

  login(){
    if(this.usernameLogin == null || typeof this.usernameLogin === 'undefined'|| this.passwordLogin == null || typeof this.passwordLogin ==='undefined'){
      alert("Please fill Username and Password");

    }else{
      this.manageService.getManager(this.usernameLogin).subscribe(data=>{
        console.log(data);
        if(data){
          if(this.passwordLogin == data.password){
            this.router.navigate(['Manager/' + data.username]);
          }
          else{
            alert("Password invalid");
          }
        }else {
          alert("Username invalid");
        }

      },error=>{
          console.log('Error', error);
      })

    }
  }

}
