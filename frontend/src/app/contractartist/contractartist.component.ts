import { Component, OnInit } from '@angular/core';
import { MoneyService } from '../shared/money/money.service';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
import { LoginAdminComponent } from '../login-admin/login-admin.component';
@Component({
  selector: 'app-contractartist',
  templateUrl: './contractartist.component.html',
  styleUrls: ['./contractartist.component.css']
})
export class ContractartistComponent implements OnInit {
  //ตัวแปรเรียก id แต่ละ entity
  id_artist: Array<any>;
  id_income: Array<any>;
  id_hire: Array<any>;
  id_type: Array<any>;
  id_manager: Array<any>;
  id_dress: Array<any>;
  id_queue: Array<any>;

  id_contract: any = {
    nameArtist: '',
    hiremoney: '',
    typecontract: '',
    nameManager: '',
    idType:[],
    idHie:[],
    idArtit:[],
    manager:[],
  };

  ids: any = {
    managerSelect: '',
    typeSelect: '',
    hireSelect: '',
    artistSelect: '',
    testSelect: '',
  };
  quereService: any;
  user: any;

  hire : any;
  hiremoney: Number;
  constructor(private moneyService: MoneyService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {

    this.moneyService.getIdArtist().subscribe(data => {
      this.id_artist = data;
      console.log(this.id_artist);
    });

    this.moneyService.getIdManager().subscribe(data => {
      this.id_manager = data;
      console.log(this.id_manager);
    });

    this.moneyService.getIdHire().subscribe(data => {
      this.id_hire = data;
      console.log(this.id_hire);
    });

    this.moneyService.getIdType().subscribe(data => {
      this.id_type = data;
      console.log(this.id_type);
    });

    this.moneyService.getIdContract().subscribe(data => {
      this.id_contract = data;
      console.log(this.id_contract);
    });
  }

  insertContract() {


    if (this.ids.artistSelect != 0 && this.ids.typeSelect != 0 && this.hiremoney != null  && this.ids.managerSelect != 0) {

       this.httpClient.post('http://localhost:8080/Contract/' + this.ids.artistSelect + '/'
              + this.ids.typeSelect + '/' + this.hiremoney + '/' + this.ids.managerSelect
              , this.ids).subscribe(data => {
                console.log('PUT Request is successful', data);
                alert('บันทึกข้อมูลสำเร็จ');
              },
                error => {
                  console.log('Error', error);
                  alert('บันทึกข้อมูลไม่สำเร็จ');
            });

    }

    else {
      alert('กรุณาเลือกข้อมูลให้ครบ');
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
