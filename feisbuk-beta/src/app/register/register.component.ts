import {Component, OnInit} from '@angular/core';
import {UserService} from "../service/user.service";
import {User} from "../user/user";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user:User = new User();
  tittle:string = "Register";

  constructor(private userService:UserService, private router:Router) {}
  ngOnInit(): void {
  }

  create():void {
    this.userService.create(this.user).subscribe(user => {
      this.router.navigate(['/user']).then();
    })
  }
}
