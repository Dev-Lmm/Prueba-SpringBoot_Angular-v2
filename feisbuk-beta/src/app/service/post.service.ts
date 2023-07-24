import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Post} from "../post/post";
import {map, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseUrl = 'http://localhost:8080/api/posts';
  constructor(private http:HttpClient) {}

  getPosts(): Observable<Post[]> {
    return this.http.get(`${this.baseUrl}/index`).pipe(
      map(response => response as Post[])
    );
  }

  getCurrentPost(id):Observable<Post> {
    return this.http.get<Post>(`${this.baseUrl}/${id}`)
  }

  create(post:Post): Observable<Post> {
    return this.http.post<Post>(`${this.baseUrl}/create`, post);
  }


}
