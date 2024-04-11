import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class SnackBarService {
  constructor(private snackBar: MatSnackBar) {}

  DisplayMessange(message: string, isSuccess: boolean) {
    const clss = isSuccess ? 'success' : 'error';
    this.snackBar.open(message, 'close', {
      duration: 7000,
      panelClass: [clss],
      verticalPosition: 'bottom',
      horizontalPosition: 'right',
    });
  }
}
