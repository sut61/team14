import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { SongService } from '../shared/song/song.service';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css']
})
export class SongComponent implements OnInit {
  albums:Array<any>;
  songs:Array<any>;

  private  albumsID:any;

  setSong:any ={
  albumsID:'',
  songSelectID:''
 }

  setData:any = {
    name : '',
    songtime : ''
  }

showError = '';

  constructor(private httpClient: HttpClient,private service: SongService,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.getAllAlbums();

    this.service.getAllSong().subscribe(data => {
      this.songs = data;
      console.log(this.songs);

    });
}
getAllAlbums() {
  this.rout.params.subscribe(params => {
    this.setSong.albumsID = params.albumsID;
    console.log(this.setSong.albumsID);
  });


}
test(data: any) {
  console.log(data);
}
  save(){
    if (this.setData.name === '' || this.setData. songtime === '') {
                   alert('กรุณากรอกข้อมูลให้ครบถ้วน');
                 } else {
                   this.httpClient.post('http://localhost:8080/song/create/' + this.setData.name + '/' + this.setData.songtime,this.setData)
                   .subscribe(data => {
                       console.log('PUT Request is successful', data);
                       window.location.reload();
                     },
                       error => {
                         console.log('Error', error);
                         this.showError = "name invalid"
                       }
                     );
                      }
  }


add(){
  if (this.setSong.songSelectID === '' ) {
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
  } else {
    this.httpClient.post('http://localhost:8080/albums/addSong/' + this.setSong.albumsID + '/' + this.setSong.songSelectID,this.setSong)
    .subscribe(data => {
        console.log('PUT Request is successful', data);
       // this.router.navigate(['view-albums']);
      },
        error => {
          console.log('Error', error);
        }
      );
       }
}
}



