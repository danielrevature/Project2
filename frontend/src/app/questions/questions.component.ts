import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from '../entity/question';
import { QuestionService } from '../services/question.service';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  model:any = {

  }

  question:Question = {
    id: 0,
    userId: 0,
    language: '',
    question: '',
    suggestion: '',
    created_at: '',
    updated_at: ''
  };

  constructor(private questionService:QuestionService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
  }

  addQuestion() {
    this.question.userId = Number(localStorage.getItem('userId'));
    this.questionService.addQuestion(this.question).subscribe();
    alert('Question posted.');
    location.reload();
  }



}
