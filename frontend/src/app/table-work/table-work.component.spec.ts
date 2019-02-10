import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TableWorkComponent } from './table-work.component';

describe('TableWorkComponent', () => {
  let component: TableWorkComponent;
  let fixture: ComponentFixture<TableWorkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TableWorkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TableWorkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
