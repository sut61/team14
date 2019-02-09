import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAlbumsComponent } from './view-albums.component';

describe('ViewAlbumsComponent', () => {
  let component: ViewAlbumsComponent;
  let fixture: ComponentFixture<ViewAlbumsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAlbumsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAlbumsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
