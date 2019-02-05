import { TestBed } from '@angular/core/testing';

import { RegisterControlService } from './register-control.service';

describe('RegisterControlService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegisterControlService = TestBed.get(RegisterControlService);
    expect(service).toBeTruthy();
  });
});
