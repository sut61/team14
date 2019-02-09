import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrivilegeVIPComponent } from './privilege-vip.component';

describe('PrivilegeVIPComponent', () => {
  let component: PrivilegeVIPComponent;
  let fixture: ComponentFixture<PrivilegeVIPComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrivilegeVIPComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrivilegeVIPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
