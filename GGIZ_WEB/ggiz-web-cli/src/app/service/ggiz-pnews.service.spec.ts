import { TestBed } from '@angular/core/testing';

import { GgizPnewsService } from './ggiz-pnews.service';

describe('GgizPnewsService', () => {
  let service: GgizPnewsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GgizPnewsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
