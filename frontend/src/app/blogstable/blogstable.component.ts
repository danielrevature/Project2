import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Blog } from '../entity/blog';
import { BlogService } from '../services/blog.service';

@Component({
  selector: 'app-blogstable',
  templateUrl: './blogstable.component.html',
  styleUrls: ['./blogstable.component.css']
})
export class BlogstableComponent implements OnInit {

  blog:Blog = {
    id: 0,
    userId: 0,
    title: '',
    content: '',
    upVotes: 0,
    downVotes: 0,
    created_at: '',
    updated_at: ''
  }

  blogs!:Blog[];

  constructor(private blogService:BlogService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    // this.searchForBlogs(Number(localStorage.getItem('blog-search-userId')));
  }

  searchForBlogs(id:Number) {
    this.blogService.getPostsByUserId(id).subscribe((blogs:Blog[]) => {
      this.blogs = blogs;
    });
  }

  viewBlog(id:Number, userId:Number, title:string, content:string, upVotes:Number, downVotes:Number) {
    let upBtn:any = document.getElementById('upBtn');
    let dwnBtn:any = document.getElementById('dwnBtn');
    dwnBtn.disabled=false;
    upBtn.disabled=false;

    let blogViewElement:any = document.getElementById('blogView');
    blogViewElement.style.display="block";

    let blogUserId:any = document.getElementById('blogUserId');
    let blogTitle:any = document.getElementById('blogTitle');
    let blogText:any = document.getElementById('blogText');
    let blogUpVotes:any = document.getElementById('upVotes');
    let blogDownVotes:any = document.getElementById('downVotes');

    blogUserId.innerHTML = userId;
    blogTitle.innerHTML = title;
    blogText.value = content;
    blogUpVotes.innerHTML = upVotes;
    blogDownVotes.innerHTML = downVotes;

    this.blog.id = id;
    this.blog.userId = userId;
    this.blog.title = title;
    this.blog.content = content;
    this.blog.upVotes = upVotes;
    this.blog.downVotes = downVotes;
  }

  upVote() {
    let newNum:number = Number(this.blog.upVotes);
    newNum = newNum + 1;
    this.blog.upVotes = newNum;
    let blogUpVotes:any = document.getElementById('upVotes');
    blogUpVotes.innerHTML = newNum;

    this.blogService.updatePost(this.blog).subscribe();

    let upBtn:any = document.getElementById('upBtn');
    let dwnBtn:any = document.getElementById('dwnBtn');
    dwnBtn.disabled=true;
    upBtn.disabled=true;
  }

  downVote() {
    let newNum:number = Number(this.blog.downVotes);
    newNum = newNum + 1;
    this.blog.downVotes = newNum;
    let blogDownVotes:any = document.getElementById('downVotes');
    blogDownVotes.innerHTML = newNum;

    this.blogService.updatePost(this.blog).subscribe();

    let upBtn:any = document.getElementById('upBtn');
    let dwnBtn:any = document.getElementById('dwnBtn');
    upBtn.disabled=true;
    dwnBtn.disabled=true;
  }

  closeBlog() {
    let blogViewElement:any = document.getElementById('blogView');
    blogViewElement.style.display="none";
    window.location.href="/devcorn/blog#top_blog_section";
    this.searchForBlogs(Number(localStorage.getItem('blog-search-userId')));
  }

}
