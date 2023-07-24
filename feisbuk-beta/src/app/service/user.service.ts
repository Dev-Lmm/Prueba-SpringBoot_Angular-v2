import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../user/user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8080/api/users'

  constructor(private http: HttpClient) {}

  create(user:User): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}/register`, user);
  }

  delete(id:number):Observable<User> {
    return this.http.delete<User>(`${this.baseUrl}/${id}`);
  }

  edit(user:User):Observable<User> {
    return this.http.put<User>(`${this.baseUrl}/${user.id}`, user);
  }

  getCurrentUser(id):Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/${id}`)
  }
}
