import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegisterControlService } from 'src/app/shared/register-control/register-control.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  @ViewChild('stepper') stepper;
  isLinear = false;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;

  genders: Array<any>;
  countrys: Array<any>;

  usernameRegister: string;
  passwordRegister: string;
  repeatPassword: string;

  nameProfile: string;
  idCardProfile: number;
  birthDayProfile: string;
  genderSelect: number;
  emailProfile: string;
  phoneProfile: string;
  addressProfile: string;
  countrySelect: string;
  pastalCodeProfile: number;

  showError1 = '';
  showError2 = '';

  constructor(private router: Router,
    private registerController: RegisterControlService,
    private _formBuilder: FormBuilder) { }

  ngOnInit() {
    this.firstFormGroup = this._formBuilder.group({
      firstCtrl: ['', Validators.required],
    });
    this.secondFormGroup = this._formBuilder.group({
      secondCtrl: ['', Validators.required],
    });
    this.thirdFormGroup = this._formBuilder.group({
      thirdCtrl: ['', Validators.required],
    });

    this.getGendertoList();
    this.getCountrytoList();
  }
  getGendertoList() {
    this.registerController.getGender().subscribe(data => {
      this.genders = data;
    });
  }
  getCountrytoList() {
    this.registerController.getCountry().subscribe(data => {
      this.countrys = data;
    });
  }

  register() {
    if (this.passwordRegister == this.repeatPassword) {
      this.registerController.postMember(this.usernameRegister, this.passwordRegister).subscribe(data => {
        console.log(data);
        this.changeStep(1);
      },
        error => {
          console.log(error);
        });
    } else {
      this.showError1 = "Password does not match";
    }
  }

  changeStep(index: number) {
    this.stepper.selectedIndex = index;
  }
  
  saveProfile() { 
    this.registerController.postProfile(
      this.nameProfile, 
      this.genderSelect, this.countrySelect,
      this.idCardProfile, this.phoneProfile,
      this.addressProfile, this.pastalCodeProfile,
      this.usernameRegister).subscribe(data => {
        console.log(data);
        this.registerController.postIDCard(this.idCardProfile, this.birthDayProfile, data.profileID).subscribe(data => {
          this.router.navigate(['login-cus']);
          console.log(data);
          
        });
      },
        error => {
          console.log(error);
          this.showError2 = "Your Profile Invalid";
        });
  }



}

