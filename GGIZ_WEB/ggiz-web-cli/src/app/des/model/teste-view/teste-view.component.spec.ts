import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TesteViewComponent } from './teste-view.component';

describe('TesteViewComponent', () => {
  let component: TesteViewComponent;
  let fixture: ComponentFixture<TesteViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TesteViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TesteViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
