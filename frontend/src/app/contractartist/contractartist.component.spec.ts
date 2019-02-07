import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContractartistComponent } from './contractartist.component';

describe('ContractartistComponent', () => {
  let component: ContractartistComponent;
  let fixture: ComponentFixture<ContractartistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContractartistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContractartistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
