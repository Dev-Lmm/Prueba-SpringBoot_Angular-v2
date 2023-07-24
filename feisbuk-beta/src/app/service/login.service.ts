import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Login} from "../api/request";
import {map, Observable} from "rxjs";
import {Response} from "../api/response";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseUrl = 'http://localhost:8080/api/users'

  constructor(private http: HttpClient) {}

  login(request:Login): Observable<Response> {
    return this.http.post(`${this.baseUrl}/`, request, {observe: 'response'})
      .pipe(map((response:HttpResponse<any>) => {
        return response.body;
      }));
  }
}
