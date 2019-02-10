import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router';
import { AlbumsService } from '../shared/albums/albums.service';
import { LoginAdminComponent } from '../login-admin/login-admin.component';


@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.css']
})
export class AlbumsComponent implements OnInit {
  displayedColumns: string[] = ['albumsID','name', 'onsale','band','producer','song','view'];

  Albums:Array<any>;
  bands:Array<any>;
  producers:Array<any>;

  private static albumsID:any;

  setData:any ={
    bandIdSelect:'',
    producerIdSelect:'',
    name:'',
    onsale:''
  }

  viewalbums: any ={
    albumsID :'',
    name : '',
    onsale : '',
    band : '',
    producer : ''
};
  showError = '';

  public static getAlbumsID(): number {
    return this.albumsID;
  }

  constructor(private httpClient: HttpClient,private service: AlbumsService,private router: Router) { }

  ngOnInit() {
  this.getAllBand();
  this.getAllProducer();

  this.service.getAllAlbums().subscribe(data => {
    this.Albums = data;
    console.log(this.Albums);
  });

  }
  getAllBand() {
    this.service.getAllBand().subscribe(data => {
      this.bands = data;
    })
  }

  getAllProducer() {
    this.service.getAllProducer().subscribe(data => {
      this.producers = data;
    })
  }
  test(data: any) {
    console.log(data);
  }

  save() {
      this.httpClient.post('http://localhost:8080/albums/create/' + this.setData.bandIdSelect + '/' + this.setData.producerIdSelect + '/'+this.setData.name+'/'+this.setData.onsale,this.setData)
      .subscribe(data => {
          console.log('PUT Request is successful', data);
          window.location.reload();
        },
          error => {
            console.log('Error', error);
            this.showError = "กรอกข้อมูลผิดพลาด"
          }
        );
         }


selectRowAlbums(row) {
  this.viewalbums.selectalbumsID = row.albumsID;
  this.viewalbums.selectname = row.name;
  this.viewalbums.selectonsale = row.onsale;
  this.viewalbums.selectband = row.band;
  this.viewalbums.selectproducer = row.producer;
  console.log(this.viewalbums.selectalbumsID);
  console.log(this.viewalbums.selectname);
  console.log(this.viewalbums.selectonsale);
  console.log(this.viewalbums.selectband);
  console.log(this.viewalbums.selectproducer);
}

song(element): void {
  this.router.navigate(['song/' + element.albumsID ]);
}
view(element):void{
  this.router.navigate(['view-albums/'+element.albumsID]);
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
