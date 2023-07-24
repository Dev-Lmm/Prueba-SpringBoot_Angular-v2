import {Comment} from "../comment/comment";

export class Post {
  id:number;
  title:string;
  text:string;
  publicationDate:string;
  profileId:number;
  comments:Comment[]
}
