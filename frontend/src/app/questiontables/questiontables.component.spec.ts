import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestiontablesComponent } from './questiontables.component';

describe('QuestiontablesComponent', () => {
  let component: QuestiontablesComponent;
  let fixture: ComponentFixture<QuestiontablesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestiontablesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestiontablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
