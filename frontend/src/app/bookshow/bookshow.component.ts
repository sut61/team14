import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { QuereService} from '../shared/book/quere.service';
import { LoginCusComponent } from '../login-cus/login-cus.component';
import { RegisterControlService } from 'src/app/shared/register-control/register-control.service';
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

  user: any;
  userQueue: any;

  /*Quere: any= {
    id: '',
    artistQuere: {},
    membersQuere: {},
    placeQuere: {},
    typeworkQuere: {},
    statusQuere: {}
  }*/

  constructor(private quereService:QuereService, private httpClient: HttpClient, private router: Router,
    private rout: ActivatedRoute,private registerController: RegisterControlService) {
      if (typeof LoginCusComponent.userName === 'undefined' || LoginCusComponent.userName == null) {
        this.router.navigate(['login'])
      }
      console.log(LoginCusComponent.userName);
     }

  ngOnInit() {
       this.sub = this.rout.params.subscribe(params => {
           this.username = params
            console.log(this.username)
    })
        this.quereService.getMembers(this.username.username).subscribe(data => {
         this.user = data;
        console.log(this.user);
    });

    this.quereService.getQueres(this.username.username).subscribe(data => {
      this.userQueue = data;
       console.log(this.userQueue);
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

  logout() {
    LoginCusComponent.userName = null;
    this.router.navigate(['login-cus']);
  }
}
