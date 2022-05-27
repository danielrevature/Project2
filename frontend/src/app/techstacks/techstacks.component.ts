import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TechStack } from '../entity/techStack';
import { TechStackService } from '../services/tech-stack.service';

@Component({
  selector: 'app-techstacks',
  templateUrl: './techstacks.component.html',
  styleUrls: ['./techstacks.component.css']
})
export class TechstacksComponent implements OnInit {

  techStack:TechStack = {
    id: 0,
    userId: 0,
    stack: ''
  };

  techStacks!:TechStack[];

  constructor(private techStackService:TechStackService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.getAllTechStacksByUserId();
  }

  getAllTechStacksByUserId() {
    const id = Number(localStorage.getItem('userId'));


    this.techStackService.getTechStacksByUserId(id).subscribe((techStacks:TechStack[]) => {
      this.techStacks = techStacks;
    })
  }

  deleteStack(id:Number) {
    this.techStackService.deleteTechStack(id).subscribe();
    
    window.setTimeout(function() {
      location.reload();
    }, 1000);
  }

  addStack() {
    let userId:Number = Number(localStorage.getItem('userId'));
    this.techStack.userId = userId;
    this.techStackService.addTechStack(this.techStack).subscribe();

    window.setTimeout(function() {
      location.reload();
    }, 1000);
    
  }
}