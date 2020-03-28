import {TestBed} from '@angular/core/testing';

import {TrackDriverService} from './track-driver.service';

describe('TrackDriverService', () => {
  let service: TrackDriverService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TrackDriverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
