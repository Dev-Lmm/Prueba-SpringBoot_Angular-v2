import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map, Observable} from "rxjs";
import {Profile} from "../profile/profile";

@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private baseUrl = 'http://localhost:8080/api/profile'
  constructor(private http:HttpClient) {}

  getProfiles():Observable<Profile[]> {
    return this.http.get(`${this.baseUrl}/index`).pipe(map(response => response as Profile[]));
  }

  getCurrentProfile(id):Observable<Profile> {
    return this.http.get<Profile>(`${this.baseUrl}/${id}`);
  }

  update(profile: Profile):Observable<Profile> {
    return this.http.put<Profile>(`${this.baseUrl}/${profile.id}`, profile);
  }
}
