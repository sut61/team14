import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookshowComponent } from './bookshow.component';

describe('BookshowComponent', () => {
  let component: BookshowComponent;
  let fixture: ComponentFixture<BookshowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookshowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
