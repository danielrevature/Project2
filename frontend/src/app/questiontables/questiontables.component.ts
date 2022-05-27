import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Question } from '../entity/question';
import { QuestionService } from '../services/question.service';

@Component({
  selector: 'app-questiontables',
  templateUrl: './questiontables.component.html',
  styleUrls: ['./questiontables.component.css']
})
export class QuestiontablesComponent implements OnInit {

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

  questions!:Question[];

  constructor(private questionService:QuestionService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.getAllQuestions();
  }

  getAllQuestions() {
    this.questionService.getAllQuestions().subscribe((questions:Question[]) => {
      this.questions = questions;
    })

  }

  selectAnswer(questionId:Number, userId:Number , language:string, question:string, created_at:string) {
    this.question.id = questionId;
    this.question.userId = userId;
    this.question.language = language;
    this.question.question = question;
    this.question.created_at = created_at;
    let ansTag:any = document.getElementById('answerQuestion');
    ansTag.style.display="block";
    window.location.href="/devcorn/questions#answer_section";
  }

  answerQuestion() {
    this.questionService.updateQuestion(this.question).subscribe();

    window.setTimeout(function() {
      location.reload();
    }, 2000);

  }

}
