import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GgizNewsLerComponent } from './ggiz-news-ler.component';

describe('GgizNewsLerComponent', () => {
  let component: GgizNewsLerComponent;
  let fixture: ComponentFixture<GgizNewsLerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GgizNewsLerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GgizNewsLerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
