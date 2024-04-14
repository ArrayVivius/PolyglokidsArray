import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { SearchBarComponent } from 'pages/components/search-bar/search-bar.component';
import { CommonModule } from '@angular/common';
import { MatPaginatorModule } from '@angular/material/paginator';
import { RouterLink } from '@angular/router';

interface SelectOptions {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-courses',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    SearchBarComponent,
    MatPaginatorModule,
    RouterLink,
  ],
  templateUrl: './courses.component.html',
  styleUrl: './courses.component.scss',
})
export class CoursesComponent {
  selectedValue = {};

  idioms: SelectOptions[] = [
    { value: 'ingles-0', viewValue: 'Ingles' },
    { value: 'Frances-1', viewValue: 'Frances' },
    { value: 'sabado-2', viewValue: 'Sabado' },
    { value: 'japones-3', viewValue: 'Japones' },
    { value: 'Frances-4', viewValue: 'Frances' },
  ];

  levels: SelectOptions[] = [
    { value: 'basico-0', viewValue: 'Basico' },
    { value: 'intermedio-1', viewValue: 'Intermedio' },
    { value: 'avanzado-2', viewValue: 'Avanzadi' },
  ];

  progress: SelectOptions[] = [
    { value: 'en-curso-0', viewValue: 'En curso' },
    { value: 'inclompleto-1', viewValue: 'inclompleto' },
    { value: 'complado-2', viewValue: 'Completado' },
  ];
}
