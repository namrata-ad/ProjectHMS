import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MedicalcenterdetailsComponent } from './medicalcenterdetails.component';

describe('MedicalcenterdetailsComponent', () => {
  let component: MedicalcenterdetailsComponent;
  let fixture: ComponentFixture<MedicalcenterdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MedicalcenterdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicalcenterdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
