import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { SponserDressComponent } from './sponserdress.component';

describe('SponserDressComponent', () => {
  let component:  SponserDressComponent;
  let fixture: ComponentFixture< SponserDressComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SponserDressComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SponserDressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
