import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogstableComponent } from './blogstable.component';

describe('BlogstableComponent', () => {
  let component: BlogstableComponent;
  let fixture: ComponentFixture<BlogstableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlogstableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BlogstableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
