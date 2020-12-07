import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder,FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-patientreg',
  templateUrl: './patientreg.component.html',
  styleUrls: ['./patientreg.component.css']
})
export class PatientregComponent implements OnInit {

  regGroup:any;
  constructor(private router:Router,private builder:FormBuilder) { }

  ngOnInit() {
    this.regGroup=new FormGroup({
      username: new FormControl('',[Validators.required]),
       email: new FormControl('', [Validators.required, Validators.email]),
      password:new FormControl('',[Validators.required]),
      mobile:new FormControl('',[Validators.required,Validators.pattern('[0-9]10')]),
      dob:new FormControl('',[Validators.required]),
      problem:new FormControl('',[Validators.required]),
      place:new FormControl('',[Validators.required]),      
    })
    }
    submit()
    {
      console.log(this.regGroup.value);
      let userdetails=JSON.stringify(this.regGroup.value);
      localStorage.setItem(this.regGroup.value.email,userdetails);
      console.log(localStorage.value);
      this.router.navigate(['/patientlogin']);
    }

}
