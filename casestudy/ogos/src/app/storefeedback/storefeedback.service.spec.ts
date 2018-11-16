import { TestBed } from '@angular/core/testing';

import { StorefeedbackService } from './storefeedback.service';

describe('StorefeedbackService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StorefeedbackService = TestBed.get(StorefeedbackService);
    expect(service).toBeTruthy();
  });
});
