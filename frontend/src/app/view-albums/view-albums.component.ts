import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { AlbumsService } from '../shared/albums/albums.service';
import { ActivatedRoute } from '@angular/router';
import { AlbumsComponent } from '../albums/albums.component';

@Component({
  selector: 'app-view-albums',
  templateUrl: './view-albums.component.html',
  styleUrls: ['./view-albums.component.css']
})
export class ViewAlbumsComponent implements OnInit {
  displayedColumns: string[] = ['songID','name', 'time'];

  private sub: any;
  private albumsID: any;
 
  private albums = {
  albumsID:'',
  name:'',
  onsale:'',
  band : [],
  producer: [],
  song: []
  }
  
     
  constructor(private httpClient: HttpClient,private service: AlbumsService,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
      this.albumsID = params;
      console.log(this.albumsID);
    });

    this.service.getAlbumsID(this.albumsID.albumsID).subscribe(data => {
      this.albums = data;
      console.log(this.albums);
    });
    
  }

 
  }

 
  


