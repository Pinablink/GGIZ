import { TestBed } from '@angular/core/testing';

import { DirConsService } from './dir-cons.service';

describe('DirConsService', () => {
  let service: DirConsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DirConsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
