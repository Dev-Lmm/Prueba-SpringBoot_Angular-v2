import {Component, OnInit} from '@angular/core';
import {Profile} from "../profile/profile";
import {ProfileService} from "../service/profile.service";
import {User} from "./user";
import {UserService} from "../service/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  tittle:string = "Users"
  profiles:Profile[];

  constructor(
    private profileService:ProfileService,
    private userService: UserService,
    private route:Router,
    private activatedRoute:ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.profileService.getProfiles().subscribe(
      profiles => this.profiles = profiles
    );
  }

  login() {
    return this.route.navigate(['/']);
  }

}
