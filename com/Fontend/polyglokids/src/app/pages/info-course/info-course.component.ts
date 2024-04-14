import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { CardContactComponent } from '../components/card-contact/card-contact.component';
import { DescriptionCourseComponent } from '../components/description-course/description-course.component';
import { UsersTableComponent } from '../components/users-table/users-table.component';
import { EvalucionesStudiantesComponent } from '../components/evaluciones-studiantes/evaluciones-studiantes.component';
import { ClasesComponent } from '../components/clases/clases.component';

@Component({
  selector: 'app-info-course',
  standalone: true,
  imports: [
    MatTabsModule,
    CommonModule,
    MatPaginator,
    DescriptionCourseComponent,
    UsersTableComponent,
    CardContactComponent,
    EvalucionesStudiantesComponent,
    ClasesComponent,
  ],
  templateUrl: './info-course.component.html',
  styleUrl: './info-course.component.scss',
})
export class InfoCourseComponent {}
