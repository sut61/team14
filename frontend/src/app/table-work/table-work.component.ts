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
  selector: 'app-table-work',
  templateUrl: './table-work.component.html',
  styleUrls: ['./table-work.component.css']
})
export class TableWorkComponent implements OnInit {
    old: Array<any>;
    format: Array<any>;

  displayedColumns: string[] = ['nameArtist','date', 'time', 'place', 'invite','tag','price','old','format','buttom'];

  quere: Array<any>;

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
    this.workService.getAllQuere().subscribe(data => {
      this.quere = data;
      console.log(this.quere);
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

  save(id){



      this.setData.id = id;


      this.httpClient.post('http://localhost:8080/newTableWork/' + this.setData.id + '/' + this.setData.username + '/'+ this.setData.invite + '/' + this.setData.tag + '/' + this.setData.price + '/'+ this.setData.old + '/' + this.setData.format
       ,this.setData)
      .subscribe(
        data => {
          alert(' บันทึกสำเร็จ');
          console.log('PUT Request is successful', data);
        },
        error => {
          alert(' บันทึกไม่สำเร็จ');
          console.log('Error', error);
        }
      );
    }


}
