import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InfomanagerComponent } from './infomanager.component';

describe('InfomanagerComponent', () => {
  let component: InfomanagerComponent;
  let fixture: ComponentFixture<InfomanagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InfomanagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfomanagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
