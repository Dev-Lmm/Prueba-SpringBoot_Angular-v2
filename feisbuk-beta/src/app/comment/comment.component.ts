import {Component} from '@angular/core';
import {Comment} from "./comment";
import {CommentService} from "../service/comment.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent {

  title:string = "Crete Comment";
  comment:Comment = new Comment();

  constructor(private commentService: CommentService, private route:Router) {}

  create() {
    this.commentService.create(this.comment).subscribe(comment => {
      this.route.navigate(['/user']).then();
    })
  }

}
