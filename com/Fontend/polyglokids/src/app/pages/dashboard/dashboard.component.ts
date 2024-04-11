import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { AuthService } from 'app/services/auth.service';
import {
  SideNavToggle,
  SidenavComponent,
} from '../components/sidenav/sidenav.component';
import { MatGridListModule } from '@angular/material/grid-list';
import { InitDashboardComponent } from '../components/init-dashboard/init-dashboard.component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    RouterOutlet,
    CommonModule,
    SidenavComponent,
    MatGridListModule,
    InitDashboardComponent,
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss',
})
export class DashboardComponent {
  authService = inject(AuthService);
  user?: any;
  navCollapser: Boolean;
  sizeWithNavCollapse: string = 'dashboard-container';

  constructor() {
    // this.authService.getCurrentAuthUser().subscribe((r) => {
    //   console.log(r);
    //   this.user = r;
    // });
    this.navCollapser = false;
  }

  onToggleSideNav(event: SideNavToggle) {
    this.navCollapser = event.collapsed;
    this.sizeWithNavCollapse = this.navCollapser
      ? 'dashboard-container collapsed'
      : 'dashboard-container';
    console.log('test ' + this.navCollapser);
  }
}
