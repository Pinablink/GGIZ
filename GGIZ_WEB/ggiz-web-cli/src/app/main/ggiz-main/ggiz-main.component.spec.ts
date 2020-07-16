import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GgizMainComponent } from './ggiz-main.component';

describe('GgizMainComponent', () => {
  let component: GgizMainComponent;
  let fixture: ComponentFixture<GgizMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GgizMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GgizMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
