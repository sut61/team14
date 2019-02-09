import { Component, OnInit } from '@angular/core';
import { ManageService } from '../shared/manage/manage.service';
import { PracticeService } from '../shared/practice/practice.service';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';
import { LoginAdminComponent } from '../login-admin/login-admin.component';

@Component({
  selector: 'app-practicetable',
  templateUrl: './practicetable.component.html',
  styleUrls: ['./practicetable.component.css']
})
export class PracticetableComponent implements OnInit {
  displayedColumns: string[] = [
    'id', 'band', 'roomType', 'room', 'date','startTime','endTime','typePractice', 'detail', 'trainer','manager'
  ];

  private username: any;
  manager: Array<any>;
  practice: Array<any>;

  constructor(private manageService:ManageService, private httpClient: HttpClient, private router: Router,
              private rout: ActivatedRoute, private practiceService:PracticeService) {
    if (typeof LoginAdminComponent.userName === 'undefined' || LoginAdminComponent.userName == null) {
      this.router.navigate(['Login/admin'])
    }
    console.log(LoginAdminComponent.userName);
  }

  ngOnInit() {
    this.rout.params.subscribe(params => {
      this.username = params;
      console.log(this.username);
    });

    this.manageService.getManager(LoginAdminComponent.userName).subscribe(data => {
      this.manager = data;
      console.log(this.manager);
    });

    this.practiceService.getPractice().subscribe(data => {
      this.practice = data;
      console.log(this.practice);
    });
  }

  logout() {
    LoginAdminComponent.userName = null;
    this.router.navigate(['Login/admin']);
  }

  goManager(){
    this.router.navigate(['Manager/' + LoginAdminComponent.userName]);
  }

  goPracticeAdd(){
    this.router.navigate(['practice/new/' + LoginAdminComponent.userName]);
  }

  goPractice(){
    this.router.navigate(['practice/table/' + LoginAdminComponent.userName]);
  }

}
