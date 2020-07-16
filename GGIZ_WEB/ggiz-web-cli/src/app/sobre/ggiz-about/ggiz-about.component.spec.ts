import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GgizAboutComponent } from './ggiz-about.component';

describe('GgizAboutComponent', () => {
  let component: GgizAboutComponent;
  let fixture: ComponentFixture<GgizAboutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GgizAboutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GgizAboutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
