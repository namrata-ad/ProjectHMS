import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { DoctorloginComponent } from './header/doctorlogin/doctorlogin.component';
import { PatientloginComponent } from './header/patientlogin/patientlogin.component';
import { PatientregComponent } from './header/patientreg/patientreg.component';
import { DoctorregComponent } from './header/doctorreg/doctorreg.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ViewrequestComponent } from './header/doctor/viewrequest/viewrequest.component';
import { ViewfeedbackComponent } from './header/doctor/viewfeedback/viewfeedback.component';
import { DoctorComponent } from './header/doctor/doctor.component';
import { PatientComponent } from './header/patient/patient.component';
import { ViewstatusComponent } from './header/patient/viewstatus/viewstatus.component';
import { FeedbackComponent } from './header/patient/feedback/feedback.component';
import { AdminregComponent } from './header/adminreg/adminreg.component';
import { AdminloginComponent } from './header/adminlogin/adminlogin.component';
import { AdminComponent } from './header/admin/admin.component';
import { ClinicdetailsComponent } from './header/admin/clinicdetails/clinicdetails.component';
import { DoctorappointmentdetailsComponent } from './header/admin/doctorappointmentdetails/doctorappointmentdetails.component';
import { DoctordetailsComponent } from './header/admin/doctordetails/doctordetails.component';
import { ManageadditionaldetailsComponent } from './header/admin/manageadditionaldetails/manageadditionaldetails.component';
import { HospitaldetailsComponent } from './header/admin/hospitaldetails/hospitaldetails.component';
import { ManagelocationComponent } from './header/admin/managelocation/managelocation.component';
import { MedicalcenterdetailsComponent } from './header/admin/medicalcenterdetails/medicalcenterdetails.component';
import { PatientdetailsComponent } from './header/admin/patientdetails/patientdetails.component';
import { RatingsComponent } from './header/admin/ratings/ratings.component';
import { SettingsComponent } from './header/admin/settings/settings.component';



const routes: Routes = [

  {path:'header',component:HeaderComponent},
  {path:'doctorlogin',component:DoctorloginComponent,children:[
    {path:'doctorreg',component:DoctorregComponent}]},
  {path:'doctorreg',component:DoctorregComponent},
  {path:'patientlogin',component:PatientloginComponent,children:[
    {path:'patientreg',component:PatientregComponent}]},
  {path:'patientreg',component:PatientregComponent},
  {path:'viewrequest',component:ViewrequestComponent},
  {path:'viewfeedback',component:ViewfeedbackComponent},
  {path:'doctor',component:DoctorComponent},
  {path:'patient',component:PatientComponent},
  {path:'viewstatus',component:ViewstatusComponent},
  {path:'feedback',component:FeedbackComponent},
  {path:'adminreg',component:AdminregComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'admin',component:AdminComponent},
  {path:'clinicdetails',component:ClinicdetailsComponent},
  {path:'doctorappointmentdetails',component:DoctorappointmentdetailsComponent},
  {path:'doctordetails',component:DoctordetailsComponent},
  {path:'hospitaldetails',component:HospitaldetailsComponent},
  {path:'manageadditionaldetails',component:ManageadditionaldetailsComponent},
  {path:'managelocation',component:ManagelocationComponent},
  {path:'medicalcenterdetails',component:MedicalcenterdetailsComponent},
  {path:'patientdetails',component:PatientdetailsComponent},
  {path:'ratings',component:RatingsComponent},
  {path:'settings',component:SettingsComponent},
  {path:'**',component:HeaderComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes),

  ReactiveFormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
