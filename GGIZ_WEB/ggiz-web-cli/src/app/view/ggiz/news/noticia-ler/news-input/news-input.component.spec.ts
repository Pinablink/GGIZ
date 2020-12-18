import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsInputComponent } from './news-input.component';

describe('NewsInputComponent', () => {
  let component: NewsInputComponent;
  let fixture: ComponentFixture<NewsInputComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewsInputComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewsInputComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
