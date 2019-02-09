import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { MatCheckboxModule } from '@angular/material';



import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatRadioModule } from '@angular/material/radio';
import { MatSelectModule } from '@angular/material/select';
import { MatSliderModule } from '@angular/material/slider';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatMenuModule } from '@angular/material/menu';
import { MatSidenavModule } from '@angular/material/sidenav';


import { MatGridListModule } from '@angular/material/grid-list';

import { MatStepperModule } from '@angular/material/stepper';
import { MatTabsModule } from '@angular/material/tabs';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatButtonToggleModule } from '@angular/material/button-toggle';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { MoneyService } from './shared/money/money.service';
import { MoneyComponent } from './money/money.component';

import { LoginAdminComponent } from './login-admin/login-admin.component';
import { ManagerComponent } from './manager/manager.component';
import { ManageService } from './shared/manage/manage.service';
import { ContactComponent } from './contact/contact.component';
import { InfomanagerComponent } from './infomanager/infomanager.component';

import { ArtistsService } from './shared/artists/artists.service';
import { ArtistsComponent } from './artists/artists.component';
import { ShowArtistsComponent } from './show-artists/show-artists.component';

import { RegisterComponent } from './register/register.component';
import { RegisterControlService } from 'src/app/shared/register-control/register-control.service';
import { ProfileComponent } from './profile/profile.component';
import { LoginCusComponent } from './login-cus/login-cus.component';
import { PrivilegeVIPComponent } from './privilege-vip/privilege-vip.component';

import { BookComponent } from './book/book.component';
import { BookshowComponent } from './bookshow/bookshow.component';
import { QuereService } from './shared/book/quere.service';

import { PracticeComponent } from './practice/practice.component';
import { PracticetableComponent } from './practicetable/practicetable.component';
import { PracticeService } from './shared/practice/practice.service';

import {
  MatBadgeModule,
  MatBottomSheetModule,
  MatDividerModule,
  MatNativeDateModule,
  MatRippleModule,
  MatTreeModule,
} from '@angular/material';
import { DressComponent } from './Dress/dress.component';
import { SponserDressComponent } from './sponserdress/sponserdress.component';
import { ContractartistComponent } from './contractartist/contractartist.component';

import { AlbumsService } from './shared/albums/albums.service';
import { AlbumsComponent } from './albums/albums.component';
import { SongService } from './shared/song/song.service';
import { SongComponent } from './song/song.component';
import { ViewAlbumsComponent } from'./view-albums/view-albums.component'


const appRoutes: Routes = [
  { path: '', redirectTo: 'login-cus', pathMatch: 'full' },
  { path: 'money', component: MoneyComponent },
  { path: 'artists', component: ArtistsComponent },
  { path: 'show-artists', component: ShowArtistsComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'login-cus', component: LoginCusComponent },
  { path: 'book/:username', component: BookComponent },
  { path: 'bookshow/:username', component: BookshowComponent },
  { path: 'Manager/newManager/:username', component: ManagerComponent },
  { path: 'Manager/newContact/:username', component: ContactComponent },
  { path: 'Manager/:username', component: InfomanagerComponent },
  { path: 'Login/admin', component: LoginAdminComponent },
  { path: 'dress', component: DressComponent },
  { path: 'contract', component: ContractartistComponent },
  { path: 'sponser', component: SponserDressComponent },
  { path: 'practice/new/:username', component: PracticeComponent },
  { path: 'practice/table/:username', component: PracticetableComponent },
  { path: 'albums', component: AlbumsComponent},
  { path:'song/:albumsID',component:SongComponent},
  { path:'view-albums/:albumsID',component:ViewAlbumsComponent},
  { path: 'privilege-vip', component: PrivilegeVIPComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    MoneyComponent,
    LoginAdminComponent,
    ArtistsComponent,
    ShowArtistsComponent,
    RegisterComponent,
    ProfileComponent,
    LoginCusComponent,
    ManagerComponent,
    ContactComponent,
    InfomanagerComponent,
    BookComponent,
    BookshowComponent,
    DressComponent,
    ContractartistComponent,
    SponserDressComponent,
    PracticeComponent,
    PracticetableComponent,
    AlbumsComponent,
    SongComponent,
    ViewAlbumsComponent,
    PrivilegeVIPComponent

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    MatAutocompleteModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatRadioModule,
    MatSelectModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatMenuModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatStepperModule,
    MatTabsModule,
    MatExpansionModule,
    MatButtonToggleModule,
    MatChipsModule,
    MatIconModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    MatDialogModule,
    MatTooltipModule,
    MatSnackBarModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    FormsModule,
    ReactiveFormsModule,
    MatBadgeModule,
    MatBottomSheetModule,
    MatDividerModule,
    MatNativeDateModule,
    MatRippleModule,
    MatTreeModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [MoneyService, ManageService, ArtistsService, RegisterControlService, QuereService, PracticeService,
              AlbumsService,SongService],
  bootstrap: [AppComponent]
})
export class AppModule { }
