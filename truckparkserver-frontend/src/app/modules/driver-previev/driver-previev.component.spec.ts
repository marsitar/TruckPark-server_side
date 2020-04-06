import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {DriverPrevievComponent} from './driver-previev.component';

describe('DriverPrevievComponent', () => {
  let component: DriverPrevievComponent;
  let fixture: ComponentFixture<DriverPrevievComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriverPrevievComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverPrevievComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
