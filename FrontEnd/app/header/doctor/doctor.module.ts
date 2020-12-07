import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DoctorComponent } from './doctor.component';
import { ViewrequestComponent } from './viewrequest/viewrequest.component';
import { ViewfeedbackComponent } from './viewfeedback/viewfeedback.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    DoctorComponent,
    ViewrequestComponent,
    ViewfeedbackComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
  ],
  exports:[
    DoctorComponent,
    ViewrequestComponent,
    ViewfeedbackComponent,
  ]
})
export class DoctorModule { }
