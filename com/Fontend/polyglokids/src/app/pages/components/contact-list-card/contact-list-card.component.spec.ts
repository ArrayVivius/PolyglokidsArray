import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactListCardComponent } from './contact-list-card.component';

describe('ContactListCardComponent', () => {
  let component: ContactListCardComponent;
  let fixture: ComponentFixture<ContactListCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContactListCardComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ContactListCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
