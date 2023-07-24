import {Component} from '@angular/core';
import {LoginService} from "../service/login.service";
import {Login} from "../api/request";
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  tittle:string = "Login";

  constructor(private loginService: LoginService, private router:Router) {}

  credentials:Login = {
    email : '',
    password : ''
  };

  login(form: NgForm) {
    this.loginService.login(this.credentials).subscribe(
      response => {
        this.router.navigate(['/user']).then();
      }
    )
  }
}
