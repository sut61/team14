import { Component, OnInit } from '@angular/core';
import { RegisterControlService } from 'src/app/shared/register-control/register-control.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-cus',
  templateUrl: './login-cus.component.html',
  styleUrls: ['./login-cus.component.css']
})
export class LoginCusComponent implements OnInit {

  public static userName: string;

  usernameLogin: string;
  passwordLogin: string;

  showError = '';

  constructor(private router: Router,
    private registerController: RegisterControlService) { }

  ngOnInit() {
  }

  login() {
    if (this.usernameLogin == null || typeof this.usernameLogin === 'undefined' || this.passwordLogin == null || typeof this.passwordLogin === 'undefined') {
      alert("Please fill Username and Password");

    } else {
      this.registerController.getMemberByUsername(this.usernameLogin).subscribe(data => {
        if (this.passwordLogin == data.memPassword) {
          LoginCusComponent.userName = data.memUser;
          this.router.navigate(['profile/' + this.usernameLogin]);
        }
      }, error => {
        this.showError = "Username invalid";
      });

    }
  }
}
