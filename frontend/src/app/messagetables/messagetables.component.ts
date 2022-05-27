import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from '../entity/message';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-messagetables',
  templateUrl: './messagetables.component.html',
  styleUrls: ['./messagetables.component.css']
})
export class MessagetablesComponent implements OnInit {

  message:Partial<Message> = {
    message: "",
    sender: 0,
    recipient: 0
  }

  messages!:Message[];

  constructor(private messageService:MessageService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.getMessagesByRecipient(Number(localStorage.getItem('userId')));
  }

  getMessagesByRecipient(id:Number) {
    this.messageService.getMessagesByRecipient(id).subscribe((messages:Message[]) => {
      this.messages = messages;
    })

  }

  selectMessage(id:Number, sender:Number) {
    localStorage.setItem('msgId', String(id));
    this.message.sender = Number(localStorage.getItem('userId'));
    this.message.recipient = sender;
    let ansTag:any = document.getElementById('respondToMsg');
    ansTag.style.display="block";
    window.location.href="/devcorn/messages#respond_section";

  }

  sendMessage() {
    this.messageService.addMessage(this.message).subscribe(res => {
      if(res) {
        console.log(res);
      }
    });
    this.messageService.deleteQuestion(Number(localStorage.getItem('msgId'))).subscribe(res => {
      if(res) {
        console.log(res);
      }
    });

    window.setTimeout(function() {
      location.reload();
    }, 2000);
  }

}
