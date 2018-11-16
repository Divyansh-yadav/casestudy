import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StorefeedbackComponent } from './storefeedback.component';

describe('StorefeedbackComponent', () => {
  let component: StorefeedbackComponent;
  let fixture: ComponentFixture<StorefeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StorefeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StorefeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
