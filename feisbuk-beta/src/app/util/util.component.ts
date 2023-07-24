import {Component, OnInit} from '@angular/core';
import {User} from "../user/user";
import {UserService} from "../service/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-util',
  templateUrl: './util.component.html',
  styleUrls: ['./util.component.css']
})
export class UtilComponent implements OnInit{
  user:User = new User();
  users:User[];
  tittle:string = "Edit User";

  constructor(private userService:UserService, private router: Router, private activatedRoute:ActivatedRoute) {}
  ngOnInit(): void {
    this.loadUser()
  }

  loadUser():void {
    this.activatedRoute.params.subscribe(params => {
      let id = params['id'];
      if (id) {
        this.userService.getCurrentUser(id).subscribe((user) => this.user = user);
      }
    });
  }

  edit():void {
    this.userService.edit(this.user).subscribe(user => {
      this.router.navigate(['/user']).then();
    })
  }

  delete(user:User):void {
    this.userService.delete(user.id).subscribe(
      response => {
        this.router.navigate(['/user'])
      })
  }
}
