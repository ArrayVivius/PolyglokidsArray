import { TestBed } from '@angular/core/testing';

import { GetCourseByStateService } from './get-course-by-state.service';

describe('GetCourseByStateService', () => {
  let service: GetCourseByStateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetCourseByStateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
