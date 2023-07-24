import {Component, OnInit} from '@angular/core';
import {Post} from "./post";
import {PostService} from "../service/post.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Comment} from "../comment/comment";
import {CommentService} from "../service/comment.service";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  title:string = "Create Post";
  post:Post = new Post();
  comments:Comment[];

  constructor(
    private postService:PostService,
    private route:Router,
    private activatedRoute:ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.loadPost();
  }

  loadPost():void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id'];

      if (id) {
        this.postService.getCurrentPost(id).subscribe((post) => this.post = post);
      }
    })
  }
  create():void {
    this.postService.create(this.post).subscribe(post => {
      this.route.navigate(['/user/profile', this.post.profileId]).then();
    })
  }
}
