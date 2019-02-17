import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowWorkComponent } from './show-work.component';

describe('ShowWorkComponent', () => {
  let component: ShowWorkComponent;
  let fixture: ComponentFixture<ShowWorkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowWorkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowWorkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
