import { TestBed } from '@angular/core/testing';

import { OrganiseService } from './organise.service';

describe('OrganiseService', () => {
  let service: OrganiseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrganiseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
