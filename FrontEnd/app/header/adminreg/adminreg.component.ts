import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminreg',
  templateUrl: './adminreg.component.html',
  styleUrls: ['./adminreg.component.css']
})
export class AdminregComponent implements OnInit {
regGroup:any;

constructor(private router:Router,private builder:FormBuilder) { }
  ngOnInit() {
    this.regGroup=new FormGroup({
      username: new FormControl('',[Validators.required]),
      idno:new FormControl('',[Validators.required,Validators.pattern('[0-9]9')]),
       email: new FormControl('', [Validators.required, Validators.email]),
      password:new FormControl('',[Validators.required]),
      mobile:new FormControl('',[Validators.required,Validators.pattern('[0-9]10')]),
      })
    }
    submit()
    {
      console.log(this.regGroup.value);
      let userdetails=JSON.stringify(this.regGroup.value);
      localStorage.setItem(this.regGroup.value.idno,userdetails);
      console.log(localStorage.value);
      this.router.navigate(['/adminlogin']);
    }

}
