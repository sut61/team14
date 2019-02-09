import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { DressComponent } from './dress.component';


describe('DressComponent', () => {
  let component:  DressComponent;
  let fixture: ComponentFixture< DressComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DressComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});


