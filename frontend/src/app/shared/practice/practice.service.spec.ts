import { TestBed, inject } from '@angular/core/testing';

import { PracticeService } from './practice.service';

describe('PracticeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PracticeService]
    });
  });

  it('should be created', inject([PracticeService], (service: PracticeService) => {
    expect(service).toBeTruthy();
  }));
});
