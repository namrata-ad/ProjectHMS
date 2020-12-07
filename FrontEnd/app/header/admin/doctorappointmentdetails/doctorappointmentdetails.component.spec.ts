import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DoctorappointmentdetailsComponent } from './doctorappointmentdetails.component';

describe('DoctorappointmentdetailsComponent', () => {
  let component: DoctorappointmentdetailsComponent;
  let fixture: ComponentFixture<DoctorappointmentdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DoctorappointmentdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DoctorappointmentdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
