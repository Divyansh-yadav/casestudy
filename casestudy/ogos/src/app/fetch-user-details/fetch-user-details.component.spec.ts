import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchUserDetailsComponent } from './fetch-user-details.component';

describe('FetchUserDetailsComponent', () => {
  let component: FetchUserDetailsComponent;
  let fixture: ComponentFixture<FetchUserDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FetchUserDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FetchUserDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
