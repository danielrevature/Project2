import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Role } from '../entity/role';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private http:HttpClient) { }

  addRole(role:Partial<Role>) {
    return this.http.post<any>('/api/roles', role);
  }

  getAllRoles() {
    return this.http.get<Role[]>('/api/roles');
  }

  getRoleById(id:Number) {
    return this.http.get<Role>(`/api/roles/${id}`);
  }

  updateRole(role:Role) {
    return this.http.put<any>(`/api/roles/${role.id}`,role);
  }

  deleteRole(id:Number) {
    return this.http.delete<any>(`/api/roles/${id}`);
  }
}
