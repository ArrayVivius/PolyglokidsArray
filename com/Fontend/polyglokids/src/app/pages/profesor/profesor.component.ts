import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTabsModule } from '@angular/material/tabs';
import { DescriptionCourseComponent } from '../components/description-course/description-course.component';
import { UsersTableComponent } from '../components/users-table/users-table.component';
import { CardContactComponent } from '../components/card-contact/card-contact.component';
import { EvalucionesStudiantesComponent } from '../components/evaluciones-studiantes/evaluciones-studiantes.component';
import { ClasesComponent } from '../components/clases/clases.component';
import { InfoCourseComponent } from '../info-course/info-course.component';

@Component({
  selector: 'app-profesor',
  standalone: true,
  imports: [InfoCourseComponent],
  templateUrl: './profesor.component.html',
  styleUrl: './profesor.component.scss',
})
export class ProfesorComponent {}
