import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder,Validators, FormGroup, FormControl} from '@angular/forms';

@Component({
  selector: 'app-doctorreg',
  templateUrl: './doctorreg.component.html',
  styleUrls: ['./doctorreg.component.css']
})
export class DoctorregComponent implements OnInit {
regGroup:any;
  constructor(private router:Router,private builder:FormBuilder) { }

  ngOnInit() {
    this.regGroup=new FormGroup({
      username: new FormControl('',[Validators.required]),
      idno:new FormControl('',[Validators.required,Validators.pattern('DOC[0-9]5')]),
       email: new FormControl('', [Validators.required, Validators.email]),
      password:new FormControl('',[Validators.required]),
      spec:new FormControl('',[Validators.required]),
      sal:new FormControl('',[Validators.required]),
      
      mobile:new FormControl('',[Validators.required,Validators.pattern('[0-9]10')]),
      dob:new FormControl('',[Validators.required])})
    }
    submit()
    {
      console.log(this.regGroup.value);
      let userdetails=JSON.stringify(this.regGroup.value);
      localStorage.setItem(this.regGroup.value.idno,userdetails);
      console.log(localStorage.value);
      this.router.navigate(['/doctorlogin']);
    }
}
