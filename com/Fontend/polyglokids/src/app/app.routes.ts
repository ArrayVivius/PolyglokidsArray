import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { authGuard } from './utils/auth.guard';
import { CoursesComponent } from './pages/courses/courses.component';
import { InitDashboardComponent } from './pages/components/init-dashboard/init-dashboard.component';
import { LoginSectionComponent } from './pages/components/login-section/login-section.component';
import { FormSignupComponent } from './pages/components/form-signup/form-signup.component';
import { InfoCourseComponent } from './pages/info-course/info-course.component';

export const routes: Routes = [
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [authGuard],
    children: [
      {
        path: '',
        component: InitDashboardComponent,
        canActivate: [authGuard],
      },
      {
        path: 'course',
        component: CoursesComponent,
        canActivate: [authGuard],
      },

      {
        path: 'course/:id',
        component: InfoCourseComponent,
        canActivate: [authGuard],
      },
    ],
  },
  {
    path: 'login',
    component: LoginComponent,
    children: [
      { path: '', component: LoginSectionComponent },
      {
        path: 'signup',
        component: FormSignupComponent,
      },
    ],
  },
  { path: '', component: HomeComponent },
];
