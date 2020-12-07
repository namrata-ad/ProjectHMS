import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators,FormGroup } from '@angular/forms';

@Component({
  selector: 'app-patientlogin',
  templateUrl: './patientlogin.component.html',
  styleUrls: ['./patientlogin.component.css']
})
export class PatientloginComponent implements OnInit {

  constructor(private router:Router,private builder:FormBuilder) { }

  loginGroup;
  error;
  ngOnInit() {
    this.loginGroup = this.builder.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required]]
    })
  }
  submit() {
    console.log(this.loginGroup.value);
    let userstring = localStorage.getItem(this.loginGroup.value.email);
    console.log(userstring);
    if (userstring != null) {
      let userobj = JSON.parse(userstring);
      console.log(userobj.email === this.loginGroup.value.email && userobj.password === this.loginGroup.value.password);
      if (userobj.email === this.loginGroup.value.email && userobj.password === this.loginGroup.value.password) {
        sessionStorage.setItem('user', userobj.email);
        this.router.navigate(['/patient']);
      }
      else {
        this.error = true;
      }
    }
    else {
      this.error = true;
    }
  }
}
