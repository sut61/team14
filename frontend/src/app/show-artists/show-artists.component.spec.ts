import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowArtistsComponent } from './show-artists.component';

describe('ShowArtistsComponent', () => {
  let component: ShowArtistsComponent;
  let fixture: ComponentFixture<ShowArtistsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowArtistsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowArtistsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
