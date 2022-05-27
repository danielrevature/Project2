import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MessagetablesComponent } from './messagetables.component';

describe('MessagetablesComponent', () => {
  let component: MessagetablesComponent;
  let fixture: ComponentFixture<MessagetablesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MessagetablesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MessagetablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
