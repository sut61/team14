import { Component, OnInit } from '@angular/core';
import { MoneyService } from '../shared/money/money.service';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';
@Component({
  selector: 'app-money',
  templateUrl: './money.component.html',
  styleUrls: ['./money.component.css']
})
export class MoneyComponent implements OnInit {
  // id ของแต่ละ entity เอาไว้ค้นหา
  ids: any = {
    managerSelect: '',
    dressSelect: '',
    queueSelect: '',
    artistSelect: '',
    testSelect: '',
  };

  //ตัวแปรเรียก id แต่ละ entity
  id_artist: Array<any>;
  id_income: Array<any>;
  id_expenses: Array<any>;
  id_insurance: Array<any>;
  id_manager: Array<any>;
  id_dress: Array<any>;
  id_queue: Array<any>;
  test: Array<any>;

  money: Array<any>;
  queue: any = {
    idQueue: '',
    nameQueue: '',
    idArtist: [],
    nameArtist: '',
    dataArtist: ''
  };

  dress: any = {
    idDress: '',
    nameDress: '',
    idArtist: [],
    nameArtist: '',
    dataArtist: ''
  };


  //
  private priceExpenses: Number;
  private priceIncome: Number;


  artist: any = {};
  income: any = {};

  constructor(private moneyService: MoneyService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {

    this.moneyService.getIdArtist().subscribe(data => {
      this.id_artist = data;
      console.log(this.id_artist);
    });

    this.moneyService.getIdDress().subscribe(data => {
      this.id_dress = data;
      this.test = data;
      console.log(this.id_dress);
    });

    this.moneyService.getIdQueue().subscribe(data => {
      this.id_queue = data;
      console.log(this.id_queue);
    });

    this.moneyService.getIdMoney().subscribe(data => {
      this.money = data;

      console.log(this.money);
    });
  }

  insertMoney() {

    if (this.ids.artistSelect != 0 && this.ids.queueSelect != 0 && this.ids.dressSelect != 0 && this.priceExpenses != null  && this.priceIncome != null) {
      this.moneyService.getFindQueue(this.ids.queueSelect).subscribe(data => {
        this.queue = data;
        console.log(this.queue);

        this.moneyService.getFindDress(this.ids.dressSelect).subscribe(data => {
          this.dress = data;
          console.log(this.dress);

         
            this.httpClient.post('http://localhost:8080/Money/' + this.ids.artistSelect + '/'
              + this.ids.dressSelect + '/' + this.priceExpenses + '/' + this.ids.queueSelect + '/' + this.priceIncome
              , this.ids).subscribe(data => {
                console.log('PUT Request is successful', data);
                alert('บันทึกข้อมูลสำเร็จ');
              },
                error => {
                  console.log('Error', error);
                  alert('บันทึกข้อมูลไม่สำเร็จ');
                });

           
        });
      });
    }
    
    else {
      alert('กรุณาเลือกข้อมูลให้ครบ');
    }

  }

  logout() {
    this.router.navigate(['Login/admin']);
  }


}
