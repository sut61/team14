import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterControlService } from 'src/app/shared/register-control/register-control.service';
import { LoginCusComponent } from '../login-cus/login-cus.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  usernameRegister: string;
  nameProfile: string;
  idCardProfile: number;
  birthDayProfile: string;
  genderSelect: number;
  emailProfile: string;
  phoneProfile: number;
  addressProfile: string;
  countrySelect: string;
  pastalCodeProfile: number;

  constructor(private router: Router,
    private registerController: RegisterControlService) {
    if (typeof LoginCusComponent.userName === 'undefined' || LoginCusComponent.userName == null) {
      this.router.navigate(['login'])
    }
    console.log(LoginCusComponent.userName);
  }

  ngOnInit() {
    this.getProfile();
  }
  getProfile() {
    this.registerController.getProfileByUsername(LoginCusComponent.userName).subscribe(data => {
      this.nameProfile = data.name;
      this.emailProfile = data.email;
      this.addressProfile = data.addressDetail;
      this.phoneProfile = data.mobilePhone;

      this.pastalCodeProfile = data.pastalCade;
      this.genderSelect = data.gender.gender;
      this.countrySelect = data.country.countryName;
      console.log(data.profileID);

      this.registerController.getIDCardByProfileId(data.profileID).subscribe(dataC => {
        this.idCardProfile = dataC.cardIdNum;
        this.birthDayProfile = dataC.birthDay;
      });
    });
  }

  logout() {
    LoginCusComponent.userName = null;
    this.router.navigate(['login-cus']);
  }

}

