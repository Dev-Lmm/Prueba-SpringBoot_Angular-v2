import {User} from "../user/user";
import {Post} from "../post/post";

export class Profile {
  id:number;
  name: string;
  lastName: string;
  birthdate: string
  phoneNumber: string;
  user:User;
  posts:Post[];
}
