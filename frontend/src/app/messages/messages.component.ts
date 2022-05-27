import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Message } from '../entity/message';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  message:Partial<Message> = {
    message: "",
    sender: 0,
    recipient: 0
  }

  constructor(private messageService:MessageService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
  }

  sendMessage() {
    this.message.sender = Number(localStorage.getItem('userId'));
    this.messageService.addMessage(this.message).subscribe();
    alert('Message sent.');
  }
}
