import { TestBed } from '@angular/core/testing';

import { GgizTokenService } from './ggiz-token.service';

describe('GgizTokenService', () => {
  let service: GgizTokenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GgizTokenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
