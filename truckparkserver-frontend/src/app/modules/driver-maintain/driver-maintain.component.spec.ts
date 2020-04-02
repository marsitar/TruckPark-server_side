import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {DriverMaintainComponent} from './driver-maintain.component';

describe('DriverMaintainComponent', () => {
  let component: DriverMaintainComponent;
  let fixture: ComponentFixture<DriverMaintainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriverMaintainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverMaintainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
