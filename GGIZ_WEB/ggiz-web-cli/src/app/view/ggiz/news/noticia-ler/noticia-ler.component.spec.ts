import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NoticiaLerComponent } from './noticia-ler.component';

describe('NoticiaLerComponent', () => {
  let component: NoticiaLerComponent;
  let fixture: ComponentFixture<NoticiaLerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NoticiaLerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NoticiaLerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
