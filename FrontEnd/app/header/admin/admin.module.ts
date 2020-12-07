import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminComponent } from './admin.component';
import { RouterModule } from '@angular/router';
import { PatientdetailsComponent } from './patientdetails/patientdetails.component';
import { DoctordetailsComponent } from './doctordetails/doctordetails.component';
import { ClinicdetailsComponent } from './clinicdetails/clinicdetails.component';
import { MedicalcenterdetailsComponent } from './medicalcenterdetails/medicalcenterdetails.component';
import { HospitaldetailsComponent } from './hospitaldetails/hospitaldetails.component';
import { ManageadditionaldetailsComponent } from './manageadditionaldetails/manageadditionaldetails.component';
import { ManagelocationComponent } from './managelocation/managelocation.component';
import { SettingsComponent } from './settings/settings.component';
import { RatingsComponent } from './ratings/ratings.component';
import { DoctorappointmentdetailsComponent } from './doctorappointmentdetails/doctorappointmentdetails.component';


@NgModule({
  declarations: [
    AdminComponent,
    PatientdetailsComponent,
    DoctordetailsComponent,
    ClinicdetailsComponent,
    MedicalcenterdetailsComponent,
    HospitaldetailsComponent,
    ManageadditionaldetailsComponent,
    ManagelocationComponent,
    SettingsComponent,
    RatingsComponent,DoctorappointmentdetailsComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
  ],
  exports: [
    AdminComponent,
    PatientdetailsComponent,
    DoctordetailsComponent,
    ClinicdetailsComponent,
    MedicalcenterdetailsComponent,
    HospitaldetailsComponent,
    ManageadditionaldetailsComponent,
    ManagelocationComponent,
    SettingsComponent,
    RatingsComponent,DoctorappointmentdetailsComponent
  ]
})
export class AdminModule { }
