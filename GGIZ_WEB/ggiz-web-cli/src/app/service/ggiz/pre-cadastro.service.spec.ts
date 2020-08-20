import { TestBed } from '@angular/core/testing';

import { PreCadastroService } from './pre-cadastro.service';

describe('PreCadastroService', () => {
  let service: PreCadastroService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PreCadastroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
