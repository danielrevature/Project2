import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from '../entity/message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private http:HttpClient) { }

  addMessage(message:Partial<Message>) {
    return this.http.post<any>('/api/messages', message);
  }

  getAllMessages() {
    return this.http.get<Message[]>('/api/messages');
  }

  getMessageById(id:Number) {
    return this.http.get<Message>(`/api/messages/${id}`);
  }

  getMessagesByRecipient(id:Number) {
    return this.http.get<Message[]>(`/api/messages/user/${id}`);
  }

  updateMessage(message:Message) {
    return this.http.put<any>(`/api/messages/${message.id}`, message);
  }

  deleteQuestion(id:Number) {
    return this.http.delete<any>(`/api/messages/${id}`);
  }
}
