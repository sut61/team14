import { Component, OnInit } from '@angular/core';
import { DataSource } from '@angular/cdk/collections';
import { BehaviorSubject } from 'rxjs';
import { Observable } from 'rxjs/Observable';
import { WorkService } from '../shared/work/work.service';

import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { LoginAdminComponent } from '../login-admin/login-admin.component';
import { HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-show-work',
  templateUrl: './show-work.component.html',
  styleUrls: ['./show-work.component.css']
})
export class ShowWorkComponent implements OnInit {
    old: Array<any>;
    format: Array<any>;
    showError = '';
    displayedColumns: string[] = ['nameArtist','date', 'time', 'place', 'invite','tag','price','old','format'];


  quere: Array<any>;
  tablework:Array<any>;
  id: any;


  setData: any = {

    id : '',
    username: '',
    invite: '',
    old : '',
    format : '',
    tag  : '',
    price : ''
  };


  constructor(private workService:WorkService,private router: Router, private rout: ActivatedRoute, private httpClient: HttpClient) { }

  ngOnInit() {

           this.rout.params.subscribe(params => {
           this.id = params
            console.log(this.id)
    });
    this.workService.getAllQuere().subscribe(data => {
      this.quere = data;
      console.log(this.quere);
    });
    this.workService.getAllTablework().subscribe(data => {
      this.tablework = data;
      console.log(this.tablework);
    });

     this.workService.getOld().subscribe(data => {
      this.old = data;
      console.log(this.old);
    });

    this.workService.getFormat().subscribe(data => {
      this.format = data;
      console.log(this.format);
    });

    this.setData.username = LoginAdminComponent.userName;
  }

  save(){



    this.setData.id = this.id.id;

      this.httpClient.post('http://localhost:8080/newTableWork/' + this.setData.id + '/' + this.setData.username + '/'+ this.setData.invite + '/' + this.setData.tag + '/' + this.setData.price + '/'+ this.setData.old + '/' + this.setData.format
       ,this.setData)
      .subscribe(
        data => {
         this.showError = 'บันทึกสำเร็จ';
          console.log('PUT Request is successful', data);
          window.location.reload();

        },
        error => {
          this.showError = 'บันทึกไม่สำเร็จ';
          console.log('Error', error);
        }
      );
    }

goManager(){
    this.router.navigate(['Manager/' + LoginAdminComponent.userName]);
  }

  goPractice(){
    this.router.navigate(['practice/table/' + LoginAdminComponent.userName]);
  }
logout() {
    LoginAdminComponent.userName = null;
    this.router.navigate(['Login/admin']);
  }
}
