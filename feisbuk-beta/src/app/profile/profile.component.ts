import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ProfileService} from "../service/profile.service";
import {Profile} from "./profile";
import {Post} from "../post/post";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  title:string = "MyProfile";
  profile:Profile = new Profile();
  posts:Post[];

  constructor(
    private route:Router,
    private activatedRoute:ActivatedRoute,
    private profileService: ProfileService
  ) {}

  ngOnInit(): void {
    this.loadProfile();
  }

  loadProfile():void {
    this.activatedRoute.params.subscribe( params => {
      let id = params['id'];
      if (id) {
        this.profileService.getCurrentProfile(id).subscribe(
          (profile) => {
            this.profile = profile;
            this.posts =  profile.posts;
            console.log(this.profile);
            console.log(this.posts);
        },
          error => {
          console.error(error);
          }
        );
      }
    });
  }

  update():void {
    this.profileService.update(this.profile).subscribe(profile => {
      this.route.navigate(['/user']).then();
    })

  }

}
