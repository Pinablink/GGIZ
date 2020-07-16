import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GgizNoticiasComponent } from './ggiz-noticias.component';

describe('GgizNoticiasComponent', () => {
  let component: GgizNoticiasComponent;
  let fixture: ComponentFixture<GgizNoticiasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GgizNoticiasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GgizNoticiasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
