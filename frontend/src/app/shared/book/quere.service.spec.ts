import { TestBed, inject } from '@angular/core/testing';

import { QuereService } from './quere.service';

describe('QuereService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QuereService]
    });
  });

  it('should be created', inject([QuereService], (service: QuereService) => {
    expect(service).toBeTruthy();
  }));
});
