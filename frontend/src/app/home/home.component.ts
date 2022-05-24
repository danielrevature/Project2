import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public userId = localStorage.getItem('userId');
  public name = localStorage.getItem('user-name');
  public username = localStorage.getItem('user-username');
  public password = localStorage.getItem('user-password');
  public role = localStorage.getItem('user-role');

  constructor(private http: HttpClient, private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => false;
  }

  ngOnInit(): void {
    this.http.get<any>('/api/list').subscribe(res => {
      if (res) {
        console.log('List', res);
      } else {
        alert("Failed to query list.")
      }
    })
  }

  displayUserDetails() {
    this.http.get<any>('/api/users/1').subscribe(res => {
      if (res) {
        console.log(res);
        let user = res;
        let role = user.role;
        localStorage.setItem('userId', user.user_id);
        localStorage.setItem('user-name', user.name);
        localStorage.setItem('user-username', user.username);
        localStorage.setItem('user-password', user.password);
        localStorage.setItem('user-role', role.role_name);
      }
    })
  }

}
