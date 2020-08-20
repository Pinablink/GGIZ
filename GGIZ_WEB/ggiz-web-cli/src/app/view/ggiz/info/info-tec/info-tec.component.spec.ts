import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InfoTecComponent } from './info-tec.component';

describe('InfoTecComponent', () => {
  let component: InfoTecComponent;
  let fixture: ComponentFixture<InfoTecComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InfoTecComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InfoTecComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
