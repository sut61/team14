import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterControlService } from 'src/app/shared/register-control/register-control.service';
import { LoginCusComponent } from '../login-cus/login-cus.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  displayedColumns: string[] = ['band', 'privilege'];

  idVIP : number;
  idProfile: number;
  usernameRegister: string;
  nameProfile: string;
  idCardProfile: number;
  birthDayProfile: string;
  genderSelect: number;
  phoneProfile: string;
  addressProfile: string;
  countrySelect: string;
  pastalCodeProfile: number;
  
  privilegeSelect: string;
  bandSelect: string;

  showError = '';
  private username: any;

  constructor(private router: Router,
    private registerController: RegisterControlService,private rout: ActivatedRoute) {

    if (typeof LoginCusComponent.userName === 'undefined' || LoginCusComponent.userName == null) {
      this.router.navigate(['login'])
    }
    console.log(LoginCusComponent.userName);

  }

  ngOnInit() {
    this.rout.params.subscribe(params => {
      this.username = params;
      console.log(this.username);
    });

    this.getProfile();

  }

  getProfile() {
    this.registerController.getProfileByUsername(LoginCusComponent.userName).subscribe(data => {
      this.idProfile = data.profileID;
      this.nameProfile = data.name;
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

  goBook() {
    this.router.navigate(['book/' + this.idProfile]);
  }
  goProfile(){
    this.router.navigate(['profile/' + this.idProfile]);
  }

 
}

