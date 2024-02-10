import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModelEditComponent } from './model-edit.component';

describe('ModelEditComponent', () => {
  let component: ModelEditComponent;
  let fixture: ComponentFixture<ModelEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModelEditComponent]
    });
    fixture = TestBed.createComponent(ModelEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
