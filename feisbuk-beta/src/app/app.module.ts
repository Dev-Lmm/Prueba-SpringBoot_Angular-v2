import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {LoginComponent} from './login/login.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {RouterModule, Routes} from "@angular/router";
import {ProfileComponent} from './profile/profile.component';
import {PostComponent} from './post/post.component';
import {CommentComponent} from './comment/comment.component';
import {UserComponent} from './user/user.component';
import { RegisterComponent } from './register/register.component';
import { UtilComponent } from './util/util.component';

const routes : Routes = [
  {path: '', redirectTo: '/login', pathMatch: "full"},
  {path: 'login', component: LoginComponent},
  {path: 'user', component: UserComponent},
  {path: 'user/create', component: RegisterComponent},
  {path: 'user/config/:id', component: UtilComponent},
  {path: 'user/profile/:id', component: ProfileComponent},
  {path: 'post', component:PostComponent},
  {path: 'post/create', component:PostComponent},
  {path: 'post/:id', component:PostComponent},
  {path: 'comment/create', component:CommentComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ProfileComponent,
    PostComponent,
    CommentComponent,
    UserComponent,
    RegisterComponent,
    UtilComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
