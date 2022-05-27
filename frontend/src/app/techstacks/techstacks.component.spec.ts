import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TechstacksComponent } from './techstacks.component';

describe('TechstacksComponent', () => {
  let component: TechstacksComponent;
  let fixture: ComponentFixture<TechstacksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TechstacksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TechstacksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
