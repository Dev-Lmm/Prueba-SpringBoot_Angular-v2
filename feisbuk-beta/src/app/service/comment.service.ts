import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Comment} from "../comment/comment";

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private baseUrl = 'http://localhost:8080/api/comments'
  constructor(private http:HttpClient) {}

  create(comment:Comment): Observable<Comment> {
    return this.http.post<Comment>(`${this.baseUrl}/create`, comment);
  }
}
