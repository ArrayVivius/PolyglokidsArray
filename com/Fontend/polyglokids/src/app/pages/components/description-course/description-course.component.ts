import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { CourseDetails } from './description-data';

@Component({
  selector: 'app-description-course',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './description-course.component.html',
  styleUrl: './description-course.component.scss',
})
export class DescriptionCourseComponent {
  courseDetails = CourseDetails;
}
