import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrefshopsComponent } from './prefshops.component';

describe('PrefshopsComponent', () => {
  let component: PrefshopsComponent;
  let fixture: ComponentFixture<PrefshopsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrefshopsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrefshopsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
