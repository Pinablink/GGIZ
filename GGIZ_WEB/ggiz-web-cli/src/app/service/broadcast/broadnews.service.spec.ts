import { TestBed } from '@angular/core/testing';

import { BroadnewsService } from './broadnews.service';

describe('BroadnewsService', () => {
  let service: BroadnewsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BroadnewsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
