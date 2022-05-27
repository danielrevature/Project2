import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blog',
  templateUrl: './blog.component.html',
  styleUrls: ['./blog.component.css']
})
export class BlogComponent implements OnInit {

  model:any = {

  }

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  searchBlogs() {
    localStorage.setItem('blog-search-userId', this.model.userId);
    let blogElement:any = document.getElementById('blogsTables');
    blogElement.style.display="block";
  }

  addBlog() {
    this.router.navigate(['/devcorn/addblog']);
  }

}
