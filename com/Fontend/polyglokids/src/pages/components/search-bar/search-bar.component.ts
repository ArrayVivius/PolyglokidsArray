import { Component } from '@angular/core';
import { MatIconButton } from '@angular/material/button';
import { MatIcon } from '@angular/material/icon';

@Component({
  selector: 'app-search-bar',
  standalone: true,
  imports: [MatIconButton, MatIcon],
  templateUrl: './search-bar.component.html',

  styleUrl: './search-bar.component.scss',
})
export class SearchBarComponent {}
