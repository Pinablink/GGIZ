import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RbarIComponent } from './rbar-i.component';

describe('RbarIComponent', () => {
  let component: RbarIComponent;
  let fixture: ComponentFixture<RbarIComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RbarIComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RbarIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
