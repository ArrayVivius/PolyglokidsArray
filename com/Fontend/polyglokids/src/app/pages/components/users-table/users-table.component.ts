import { Component } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatTabsModule } from '@angular/material/tabs';
import { ElementeData } from './user-table-data';
import { CardContactComponent } from '../card-contact/card-contact.component';

@Component({
  selector: 'app-users-table',
  standalone: true,
  imports: [MatTableModule, CardContactComponent],

  templateUrl: './users-table.component.html',
  styleUrl: './users-table.component.scss',
})
export class UsersTableComponent {
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  dataSource = ElementeData;
}
