import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { ArtistsComponent } from 'src/app/artists/artists.component';
import { ArtistsService } from '../shared/artists/artists.service';



@Component({
  selector: 'app-show-artists',
  templateUrl: './show-artists.component.html',
  styleUrls: ['./show-artists.component.css']
})
export class ShowArtistsComponent implements OnInit {
 displayedColumns: string[] = ['artistsID','firstname', 'lastname', 'nickname', 'birthday','phone','gender','manager',
'band','typeMusic'];
  
  Artists:Array<any>;
  genders: Array<any>;
  bands:Array<any>;
  managers:Array<any>;
  typeMusics:Array<any>;

   viewartists: any ={
      artistsID :'',
      firstname : '',
      lastname : '',
      nickname : '',
      birthday: '',
      phone : '',
      gender : '',
      username : '',
      band : '',
      typemusics : ''
  };
  
  
  constructor(private service:ArtistsService,private router: Router, private rout: ActivatedRoute) { }

  ngOnInit() {
    this.service.getShowArtists().subscribe(data => {
      this.Artists = data;
      console.log(this.Artists);
    });
  }
  getGender() {
    this.service.getGender().subscribe(data => {
      this.genders = data;
    })
  }
  getTypeMusic() {
    this.service.getTypeMusic().subscribe(data => {
      this.typeMusics = data;
    })
  }

getManager() {
     this.service.getManager().subscribe(data => {
       this.managers = data;
     })
   }
   getAllBand() {
    this.service.getAllBand().subscribe(data => {
      this.bands = data;
    })
  }

  selectRowArtists(row) {
    this.viewartists.selectartistsID = row.artistsID;
    this.viewartists.selectfirstname = row.firstname;
    this.viewartists.selectlastname = row.lastname;
    this.viewartists.selectnickname = row.nickname;
    this.viewartists.selectbirthday = row.birthday;
    this.viewartists.selectphone = row.phone;
    this.viewartists.selectgender = row.gender;
    this.viewartists.selectusername = row.username;
    this.viewartists.selectband = row.band;
    this.viewartists.selecttypemusics = row.typemusics;
    console.log(this.viewartists.selectartistsID);
    console.log(this.viewartists.selectfirstname);
    console.log(this.viewartists.selectlastname);
    console.log(this.viewartists.selectnickname);
    console.log(this.viewartists.selectbirthday);
    console.log(this.viewartists.selectphone);
    console.log(this.viewartists.selectgender);
    console.log(this.viewartists.selectusernamer);
    console.log(this.viewartists.selectband);
    console.log(this.viewartists.selecttypemusics);
  }
  }
  


