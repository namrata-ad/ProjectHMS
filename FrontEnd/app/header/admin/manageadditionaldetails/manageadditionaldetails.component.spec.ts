import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageadditionaldetailsComponent } from './manageadditionaldetails.component';

describe('ManageadditionaldetailsComponent', () => {
  let component: ManageadditionaldetailsComponent;
  let fixture: ComponentFixture<ManageadditionaldetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManageadditionaldetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageadditionaldetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
