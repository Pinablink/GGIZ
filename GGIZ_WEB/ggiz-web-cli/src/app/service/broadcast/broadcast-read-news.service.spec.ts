import { TestBed } from '@angular/core/testing';

import { BroadcastReadNewsService } from './broadcast-read-news.service';

describe('BroadcastReadNewsService', () => {
  let service: BroadcastReadNewsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BroadcastReadNewsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
