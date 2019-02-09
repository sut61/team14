import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PracticetableComponent } from './practicetable.component';

describe('PracticetableComponent', () => {
  let component: PracticetableComponent;
  let fixture: ComponentFixture<PracticetableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PracticetableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PracticetableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
