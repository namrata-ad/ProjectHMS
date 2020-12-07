import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder,Validators,FormGroup} from '@angular/forms';


@Component({
  selector: 'app-doctorlogin',
  templateUrl: './doctorlogin.component.html',
  styleUrls: ['./doctorlogin.component.css']
})
export class DoctorloginComponent implements OnInit {

  constructor(private router: Router, private builder: FormBuilder) { }
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
        this.router.navigate(['doctor']);
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


