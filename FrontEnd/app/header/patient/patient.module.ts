import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PatientComponent } from './patient.component';
import { RouterModule } from '@angular/router';
import { FeedbackComponent } from './feedback/feedback.component';
import { ViewstatusComponent } from './viewstatus/viewstatus.component';



@NgModule({

  declarations: [
    PatientComponent,
    FeedbackComponent,
    ViewstatusComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
  ],
  exports:[
    PatientComponent,
    ViewstatusComponent,
    FeedbackComponent,
  ]
})
export class PatientModule { }
