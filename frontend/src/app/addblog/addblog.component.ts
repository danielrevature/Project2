import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Blog } from '../entity/blog';
import { BlogService } from '../services/blog.service';

@Component({
  selector: 'app-addblog',
  templateUrl: './addblog.component.html',
  styleUrls: ['./addblog.component.css']
})
export class AddblogComponent implements OnInit {

  blog:Partial<Blog> = {
    userId: 0,
    title: '',
    content: '',
    upVotes: 0,
    downVotes: 0,
    created_at: '',
    updated_at: ''
  }

  constructor(private blogService:BlogService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
  }

  addBlog() {
    console.log(this.blog);
    this.blogService.addPost(this.blog).subscribe();
    alert('New Blog Submitted.');
  }

}
