import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterControlService } from 'src/app/shared/register-control/register-control.service';
import { LoginCusComponent } from '../login-cus/login-cus.component';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-privilege-vip',
  templateUrl: './privilege-vip.component.html',
  styleUrls: ['./privilege-vip.component.css']
})
export class PrivilegeVIPComponent implements OnInit {


  bands: Array<any>;
  privileges: Array<any>;
  months: Array<any>;
  years: Array<any>;

  profileID: number;
  nameProfile: string;
  phoneProfile: string;
  
  emailProfile: string;
  cardNumShow: string;
  cvvNumShow: string;
  monthSelect: string;
  yearSelect: string;
  bandSelect : string;
  privilegeSelect : string;

  showError = '';
  showCompleat = '';
  private username: any;


  constructor(private router: Router, private httpClient: HttpClient,
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
    this.getBand();
    this.getTypePrivilege();
    this.getExpMonth();
    this.getExpYear();
  }

  getProfile() {
    this.registerController.getProfileByUsername(LoginCusComponent.userName).subscribe(data => {
      this.profileID = data.profileID;
      this.nameProfile = data.name;
      this.phoneProfile = data.mobilePhone;
    });
  }
  getExpMonth() {
    this.registerController.getExpMonth().subscribe(data => {
      this.months = data;
    });
  }

  getExpYear() {
    this.registerController.getExpYear().subscribe(data => {
      this.years = data;
    });
  }
  getBand() {
    this.registerController.getBand().subscribe(data => {
      this.bands = data;
    });
  }
  getTypePrivilege() {
    this.registerController.getTypePrivilege().subscribe(data => {
      this.privileges = data;
    });
  }

  logout() {
    LoginCusComponent.userName = null;
    this.router.navigate(['login-cus']);
  }
  goBook() {
    this.router.navigate(['book/' + this.profileID]);
  }


  savePrivilege() {
    this.registerController.postPrivilegeVIP(
      this.cardNumShow, this.cvvNumShow, this.emailProfile,
      this.monthSelect, this.yearSelect,
      this.profileID, this.bandSelect, this.privilegeSelect
    ).subscribe(data => {
      this.showCompleat = "Compleat Privilege";
      console.log(data);
    },
      error => {
        console.log(error);
        this.showError = "กรุณากรอกข้อมูลให้ถูกต้อง";
      });
  }

  goProfile(){
    this.router.navigate(['profile/' + this.username]);
  }

}
