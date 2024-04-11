import { Component } from '@angular/core';

@Component({
  selector: 'app-alert-register',
  standalone: true,
  imports: [],
  templateUrl: './alert-register.component.html',
  styleUrl: './alert-register.component.scss',
})
export class AlertRegisterComponent {
  durationInSeconds = 5;

  constructor(private _snackBar: MatSnackBar) {}

  openSnackBar() {
    this._snackBar.openFromComponent(PizzaPartyAnnotatedComponent, {
      duration: this.durationInSeconds * 1000,
    });
  }
}
