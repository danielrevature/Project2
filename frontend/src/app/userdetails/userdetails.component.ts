import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { elementAt } from 'rxjs';
import { User } from '../entity/user';

@Component({
  selector: 'app-userdetails',
  templateUrl: './userdetails.component.html',
  styleUrls: ['./userdetails.component.css']
})
export class UserdetailsComponent implements OnInit {

  user: User = {
    id: 0,
    username: '',
    password: '',
    role: '',
    email: '',
    timeAvailable: ''
  }

  // public currentUsername = sessionStorage.getItem('username');

  public showDetails = false;

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.checkRole();
    this.displayUserDetails();
  }

  checkRole() {
    if(localStorage.getItem('user-role') != 'MENTOR') {
      let element = document.getElementById('mentor');
      element!.innerHTML = '';
    }
  }

  displayUserDetails() {
    let newId:any = localStorage.getItem('userId');
    let newUsername:any = localStorage.getItem('user-username');
    let newPassword:any = localStorage.getItem('user-password');
    let newRole:any = localStorage.getItem('user-role');
    let newEmail:any = localStorage.getItem('user-email');
    let newTimeAvailable:any = localStorage.getItem('user-availability');

    this.user.id = newId;
    this.user.username = newUsername;
    this.user.password = newPassword;
    this.user.role = newRole;
    this.user.email = newEmail;
    this.user.timeAvailable = newTimeAvailable;
  }
}