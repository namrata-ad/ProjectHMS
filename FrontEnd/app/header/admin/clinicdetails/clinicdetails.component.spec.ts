import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClinicdetailsComponent } from './clinicdetails.component';

describe('ClinicdetailsComponent', () => {
  let component: ClinicdetailsComponent;
  let fixture: ComponentFixture<ClinicdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClinicdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClinicdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
