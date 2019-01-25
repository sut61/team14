import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginCusComponent } from './login-cus.component';

describe('LoginCusComponent', () => {
  let component: LoginCusComponent;
  let fixture: ComponentFixture<LoginCusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginCusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginCusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
