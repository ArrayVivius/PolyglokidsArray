import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root',
})
export class SnackBarServiceService {
  constructor(private snackBar: MatSnackBar) {}

  mostrarMensaje(message: string, isSuccess: boolean) {
    const clase = isSuccess ? 'success-message' : 'error-message';
    this.snackBar.open(message, 'close', {
      duration: 7000,
      panelClass: [clase],
      verticalPosition: 'bottom',
      horizontalPosition: 'right',
    });
  }
}
