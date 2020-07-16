import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GgizTecComponent } from './ggiz-tec.component';

describe('GgizTecComponent', () => {
  let component: GgizTecComponent;
  let fixture: ComponentFixture<GgizTecComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GgizTecComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GgizTecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
