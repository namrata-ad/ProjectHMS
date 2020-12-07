import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header.component';
import { DoctorregComponent } from './doctorreg/doctorreg.component';
import { DoctorloginComponent } from './doctorlogin/doctorlogin.component';
import { PatientloginComponent } from './patientlogin/patientlogin.component';
import { PatientregComponent } from './patientreg/patientreg.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { AdminregComponent } from './adminreg/adminreg.component';
import { DoctorModule } from './doctor/doctor.module';
import { PatientModule } from './patient/patient.module';
import { AdminModule } from './admin/admin.module';


@NgModule({
  declarations: [
   
    DoctorregComponent, 
    DoctorloginComponent, 
    PatientloginComponent, 
    PatientregComponent, 
    AdminloginComponent, 
    AdminregComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterModule,
    DoctorModule,
    PatientModule,
    AdminModule,
  ],
  exports: [
    // HeaderComponent,
    DoctorloginComponent,
    DoctorregComponent,
    PatientloginComponent,
    PatientregComponent,
    AdminloginComponent,
    AdminregComponent,
  ]
})
export class HeaderModule {
  
 }
