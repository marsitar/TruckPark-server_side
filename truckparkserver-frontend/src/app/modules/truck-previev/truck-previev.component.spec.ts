import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {TruckPrevievComponent} from './truck-previev.component';

describe('TruckPrevievComponent', () => {
  let component: TruckPrevievComponent;
  let fixture: ComponentFixture<TruckPrevievComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TruckPrevievComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TruckPrevievComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
