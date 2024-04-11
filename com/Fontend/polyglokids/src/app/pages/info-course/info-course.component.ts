import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { CardContactComponent } from '../components/card-contact/card-contact.component';

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  { position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H' },
  { position: 2, name: 'Helium', weight: 4.0026, symbol: 'He' },
  { position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li' },
  { position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be' },
  { position: 5, name: 'Boron', weight: 10.811, symbol: 'B' },
  { position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C' },
  { position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N' },
  { position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O' },
  { position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F' },
  { position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne' },
];

@Component({
  selector: 'app-info-course',
  standalone: true,
  imports: [
    MatTabsModule,
    MatTableModule,
    CommonModule,
    MatPaginator,
    CardContactComponent,
  ],
  templateUrl: './info-course.component.html',
  styleUrl: './info-course.component.scss',
})
export class InfoCourseComponent {
  courseDetails = [
    {
      title: 'Nombre del curso',
      value: 'Nombre del curso',
      icon: 'fa fa-book',
    },
    {
      title: 'Breve descripción',
      value: 'Breve descripción',
      icon: 'fa fa-file-text',
    },
    {
      title: 'Objetivos del curso',
      value: 'Objetivos del curso',
      icon: 'fa fa-bullseye',
    },
    {
      title: 'Contenido del curso',
      value: 'Contenido del curso',
      icon: 'fa fa-list-alt',
    },
    {
      title: 'Duración',
      value: 'Duración',
      icon: 'fa fa-clock',
    },
    {
      title: 'Modalidad',
      value: 'Modalidad',
      icon: 'fa fa-desktop',
    },
    {
      title: 'Requisitos previos',
      value: 'Requisitos previos',
      icon: 'fa fa-check-circle',
    },
    {
      title: 'Material del curso',
      value: 'Material del curso',
      icon: 'fa fa-file-text-o',
    },
    {
      title: 'Metodología de enseñanza',
      value: 'Metodología de enseñanza',
      icon: 'fa fa-graduation-cap',
    },
    {
      title: 'Evaluación',
      value: 'Evaluación',
      icon: 'fa fa-check-square-o',
    },
    {
      title: 'Certificación',
      value: 'Certificación',
      icon: 'fa fa-certificate',
    },
    {
      title: 'Instructor(es)',
      value: 'Instructor(es)',
      icon: 'fa fa-user',
    },
    {
      title: 'Soporte y asistencia',
      value: 'Soporte y asistencia',
      icon: 'fa fa-life-ring',
    },
  ];

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = ELEMENT_DATA;
}
