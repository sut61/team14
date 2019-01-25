import { Component, OnInit } from '@angular/core';
import { QuereService} from '../shared/book/quere.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {
  private username :any;
  private sub : any;
  artists: Array<any>;
  typeWorks: Array<any>;
  user: any = {
    id : '',
    memuser : '',
    password : '',
    firstName : '',
    email : '',
    mobilePhone : '',
    quereSet: []
  }

  setData: any = {
    place : '',
    date : '',
    hour : '',
    hrs : '',
    mins : '',
    artistSelect : '',
    typeWorkSelect : ''
  }
  Quere: any= {
    id: '',
    artistQuere: {},
    membersQuere: {},
    placeQuere: {},
    typeworkQuere: {},
    statusQuere: {}
  }

  constructor(private quereService:QuereService, private httpClient: HttpClient, private router: Router,
    private rout: ActivatedRoute) { }


  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.username = params
        console.log(this.username.username)
    })

    this.quereService.getArtist().subscribe(data => {
      this.artists = data;
      console.log(this.artists);
    });

    this.quereService.getTypeWork().subscribe(data => {
      this.typeWorks = data;
      console.log(this.typeWorks);
    });

    this.quereService.getMembers(this.username.username).subscribe(data => {
      this.user = data;
      console.log(this.user);
      console.log(this.user.quereSet[0]);
    });

  }

  save() {

    //if (this.user.quereSet[0] == undefined || this.user.quereSet[0].statusQuere.statusId != 1) {
      this.httpClient.post('http://localhost:8080/Quere/' + this.setData.place + '/' + this.setData.date + '/' +
    this.setData.hour + '/' + this.setData.hrs + '/' + this.setData.mins + '/' + this.setData.artistSelect + '/' +
    this.user.memuser + '/' + this.setData.typeWorkSelect ,this.setData,this.user)
    .subscribe(
      data => {
        if(data){
          alert('การจองเสร็จสิ้น');
          this.router.navigate(['bookshow/' + this.user.memuser]);
          console.log('PUT Request is successful', data);
        }
      },
      error => {
        console.log('Error', error);
      }
    );
    /*
    if (this.setData.artistSelect === '' || this.setData.typeWorkSelect === '' || this.setData.place === '' || this.setData.date === '' ||
    this.setData.hour === '' || this.setData.hrs === '' || this.setData.mins === '') {
      alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else{
      if (this.user.quereSet[0] == undefined || this.user.quereSet[0].statusQuere.statusId != 1) {
        this.httpClient.post('http://localhost:8080/Quere/' + this.setData.place + '/' + this.setData.date + '/' +
      this.setData.hour + '/' + this.setData.hrs + '/' + this.setData.mins + '/' + this.setData.artistSelect + '/' +
      this.user.memuser + '/' + this.setData.typeWorkSelect ,this.setData,this.user)
      .subscribe(
        data => {
          if(data){
            alert('การจองเสร็จสิ้น');
            this.router.navigate(['bookshow/' + this.user.memuser]);
            console.log('PUT Request is successful', data);

          }
        },
        error => {
          console.log('Error', error);
        }
      );

      }else{
        alert(' ขออภัย พบการจองที่ยังไม่ได้รับการยืนยัน');
      }
      */
    //}
    
  }

  back(){
    this.router.navigate(['profile/' + this.username]);
  }
  history(){
    this.router.navigate(['bookshow/' + this.user.memuser]);
  }
}
