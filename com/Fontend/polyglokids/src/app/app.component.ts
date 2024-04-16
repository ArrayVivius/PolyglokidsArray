import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { CommonModule } from '@angular/common';
import { InitDashboardComponent } from './pages/components/init-dashboard/init-dashboard.component';
import { FullCalendarModule } from '@fullcalendar/angular';
import { CoursesComponent } from './pages/courses/courses.component';
import { LoginSectionComponent } from './pages/components/login-section/login-section.component';
import { Component } from '@angular/core';
import { FormSignupComponent } from './pages/components/form-signup/form-signup.component';
import { SearchBarComponent } from 'pages/components/search-bar/search-bar.component';
import { InfoCourseComponent } from './pages/info-course/info-course.component';
import { ProfesorComponent } from './pages/profesor/profesor.component';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    HomeComponent,
    LoginComponent,
    DashboardComponent,
    InitDashboardComponent,
    FullCalendarModule,
    CoursesComponent,
    LoginSectionComponent,
    FormSignupComponent,
    SearchBarComponent,
    InfoCourseComponent,
    ProfesorComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {}
