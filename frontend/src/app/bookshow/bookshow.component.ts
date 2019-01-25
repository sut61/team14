import { Component, OnInit } from '@angular/core';
import { QuereService} from '../shared/quere.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-bookshow',
  templateUrl: './bookshow.component.html',
  styleUrls: ['./bookshow.component.css']
})
export class BookshowComponent implements OnInit {
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
  };

  /*Quere: any= {
    id: '',
    artistQuere: {},
    membersQuere: {},
    placeQuere: {},
    typeworkQuere: {},
    statusQuere: {}
  }*/

  constructor(private quereService:QuereService, private httpClient: HttpClient, private router: Router,
    private rout: ActivatedRoute) { }

  ngOnInit() {
       this.sub = this.rout.params.subscribe(params => {
           this.username = params
            console.log(this.username.username)
    })
        this.quereService.getMembers(this.username.username).subscribe(data => {
         this.user = data;
          console.log(this.user);
    });
  }
       cancel() {
    this.httpClient.post('http://localhost:8080/Quere/cancel/' + this.user.quereSet[0].id,this.user)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
          location.reload();
          alert('ยกเลิกการจองสำเร็จ');
        },
        error => {
          console.log('Error', error);
        }
      );
  }
     back(){
    this.router.navigate(['book/' + this.username.username]);
  }
}
