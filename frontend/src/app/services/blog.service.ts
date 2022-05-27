import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Blog } from '../entity/blog';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  constructor(private http:HttpClient) { }

  addPost(blog:Partial<Blog>) {
    return this.http.post<any>('/api/blogs', blog);
  }

  getAllPosts() {
    return this.http.get<Blog[]>('/api/blogs');
  }

  getPostById(id:Number) {
    return this.http.get<Blog>(`/api/blogs/${id}`);
  }

  getPostsByUserId(id:Number) {
    return this.http.get<Blog[]>(`/api/blogs/user/${id}`);
  }

  updatePost(blog:Blog) {
    return this.http.put<any>(`/api/blogs/${blog.id}`, blog);
  }

  deletePost(id:Number) {
    return this.http.delete<any>(`/api/blogs/${id}`);
  }
}
