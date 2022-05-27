import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../entity/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

    addUser(user:Partial<User>) {
      return this.http.post<User>('/api/users', user);
    }
  
    getAllUsers() {
      return this.http.get<User[]>('/api/users');
    }
  
    getUserById(id:Number) {
      return this.http.get<User>(`/api/users/${id}`);
    }
  
    updateUser(user:User) {
      return this.http.put<User>(`/api/users/${user.id}`,user);
    }
  
    deleteUser(id:Number) {
      return this.http.delete(`/api/users/${id}`);
    }
}
