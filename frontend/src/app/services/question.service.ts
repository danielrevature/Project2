import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from '../entity/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http:HttpClient) { }

  addQuestion(question:Partial<Question>) {
    return this.http.post<any>('/api/questions', question);
  }

  getAllQuestions() {
    return this.http.get<Question[]>('/api/questions');
  }

  getQuestionById(id:Number) {
    return this.http.get<Question>(`/api/questions/${id}`);
  }

  updateQuestion(question:Question) {
    return this.http.put<any>(`/api/questions/${question.id}`,question);
  }

  deleteQuestion(id:Number) {
    return this.http.delete<any>(`/api/questions/${id}`);
  }
}
