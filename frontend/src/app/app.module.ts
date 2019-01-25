import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import {MatCheckboxModule} from '@angular/material';


import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatRadioModule} from '@angular/material/radio';
import {MatSelectModule} from '@angular/material/select';
import {MatSliderModule} from '@angular/material/slider';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatMenuModule} from '@angular/material/menu';
import {MatSidenavModule} from '@angular/material/sidenav';


import {MatGridListModule} from '@angular/material/grid-list';

import {MatStepperModule} from '@angular/material/stepper';
import {MatTabsModule} from '@angular/material/tabs';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatChipsModule} from '@angular/material/chips';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatPaginatorModule} from '@angular/material/paginator';

import { MoneyService } from './shared/money/money.service';
import { ManageService } from './shared/manage/manage.service';

import { MoneyComponent } from './money/money.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';

import {ArtistsService} from './shared/artists/artists.service';
import { ArtistsComponent } from './artists/artists.component';

import { ShowArtistsComponent } from './show-artists/show-artists.component';

import { RegisterComponent } from './register/register.component';
import { RegisterControlService } from 'src/app/shared/register-control/register-control.service';
import {ProfileComponent} from './profile/profile.component';
import { LoginCusComponent } from './login-cus/login-cus.component';

const appRoutes: Routes = [

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
    LoginCusComponent

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
    RouterModule.forRoot([
      { path:'money', component:MoneyComponent},
      {path:'artists',component:ArtistsComponent},
      {path:'show-artists',component:ShowArtistsComponent},
      {path:'register',component:RegisterComponent},
      {path:'profile',component:ProfileComponent},
      {path:'login-cus',component:LoginCusComponent}
    ])
  ],
  providers: [MoneyService,ManageService,ArtistsService,RegisterControlService],
  bootstrap: [AppComponent]
})
export class AppModule { }
