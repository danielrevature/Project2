import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TechStack } from '../entity/techStack';

@Injectable({
  providedIn: 'root'
})
export class TechStackService {

  constructor(private http:HttpClient) { }

  
  addTechStack(techStack:Partial<TechStack>) {
    return this.http.post<any>('/api/techstacks', techStack);
  }

  getAllTechStacks() {
    return this.http.get<TechStack[]>('/api/techstacks');
  }

  getTechStackById(id:Number) {
    return this.http.get<TechStack>(`/api/techstacks/${id}`);
  }

  getTechStacksByUserId(id:Number) {
    return this.http.get<TechStack[]>(`/api/techstacks/user/${id}`);
  }

  updateTechStack(techStack:TechStack) {
    return this.http.put<any>(`/api/techstacks/${techStack.id}`,techStack);
  }

  deleteTechStack(id:Number) {
    return this.http.delete<any>(`/api/techstacks/${id}`);
  }
}
