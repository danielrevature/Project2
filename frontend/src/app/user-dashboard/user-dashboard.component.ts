import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { User } from '../entity/user';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  modelDeleteAccount: any = {};
  modelRole: any = {
    id: 0,
    rolename: ''
  };

  user:User = {
    id: 0,
    username: '',
    password: '',
    role: '',
    email: '',
    timeAvailable: 'morning'
  }

  constructor(private titleService: Title, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.titleService.setTitle('User Dashboard');
    this.checkRole();
  }

  checkRole() {
    if(localStorage.getItem('user-role') != 'MENTOR') {
      let element = document.getElementById('mentor');
      element!.innerHTML = '';
    }
  }

  updateDetails() {
    this.modelRole.rolename = localStorage.getItem('user-role');

    if(this.modelRole.rolename == 'LEARNER') {
      this.modelRole.id = 3;
    }else if(this.modelRole.rolename == "MENTOR") {
      this.modelRole.id = 2;
    }else if (this.modelRole.rolename == "ADMIN") {
      this.modelRole.id = 1;
    }else {
      alert('Error retrieving Role. Please sign out/in and try again.');
      return;
    }

    if(this.user.email == '' || this.user.password == '' || this.modelRole.rolename == '' ||
      this.user.timeAvailable == '' || this.user.username == '') {
        alert('Please fill out all fields with current or new information before saving.');
        return;
      }

    let url = 'api/users/' + localStorage.getItem('userId');
    this.http.put<any>(url, {
      username: this.user.username,
      password: this.user.password,
      role: this.modelRole,
      timeAvailable: this.user.timeAvailable,
      enabled: true,
      email: this.user.email,
      credentialsNonExpired: true,
      accountNonExpired: true,
      accountNonLocked: true
    }).subscribe(res => {
        if (res) {
          alert("Account Updated. For security purposes, please sign in again.");
          this.router.navigate(['/logout']);
        } else {
          alert("No Response. Updated Failed.");
        }
    });

  }

  deleteAccount() {
    let deleteText = this.modelDeleteAccount.deleteText;
    if(deleteText == 'deleteMyAccount') {
      alert('Account will be deleted.');

      let url = 'api/users/' + localStorage.getItem('userId');
      this.http.delete<any>(url, {})
      .subscribe(res => {
        if (res) {
          console.log(res);
          this.router.navigate(['/logout']);
        } else {
          alert("No Response. Delete failed.");
        }
      });
    }
  }

}
