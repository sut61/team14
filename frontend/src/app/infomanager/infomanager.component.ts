import { Component, OnInit } from '@angular/core';
import { ManageService } from '../shared/manage/manage.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-infomanager',
  templateUrl: './infomanager.component.html',
  styleUrls: ['./infomanager.component.css']
})
export class InfomanagerComponent implements OnInit {
  private username: any;
  private sub: any;

  private manager = {
    id : '',
    name : '',
    username : '',
    password : '',
    gender : [],
    contact : []
  };
  constructor(private manageService:ManageService, private httpClient: HttpClient, private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
      this.username = params;
      console.log(this.username);
    });

    this.manageService.getManager(this.username.username).subscribe(data => {
      this.manager = data;
      console.log(this.manager);
    });
  }

  goAdd() {
    this.router.navigate(['Manager/newContact/' + this.username.username]);
  }

  addManager() {
    this.router.navigate(['Manager/newManager/' + this.username.username]);
  }

  goManager(){
    this.router.navigate(['Manager/' + this.username.username]);
  }

  logout() {
    this.router.navigate(['Login/admin']);
  }
}
