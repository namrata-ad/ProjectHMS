import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  constructor(private router:Router, private builder: FormBuilder) { }
  loginGroup;
  error;
  ngOnInit() {
    this.loginGroup = this.builder.group({
      idno: ['', [Validators.required]],
      password: ['', [Validators.required]]
    })
  }
  submit() {
    console.log(this.loginGroup.value);
    let userstring = localStorage.getItem(this.loginGroup.value.idno);
    console.log(userstring);
    if (userstring != null) {
      let userobj = JSON.parse(userstring);
      console.log(userobj.idno === this.loginGroup.value.idno && userobj.password === this.loginGroup.value.password);
      if (userobj.idno === this.loginGroup.value.idno && userobj.password === this.loginGroup.value.password) {
        sessionStorage.setItem('user', userobj.idno);
        this.router.navigate(['/admin']);
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
