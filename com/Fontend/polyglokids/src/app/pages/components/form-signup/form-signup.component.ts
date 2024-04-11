import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  ValidationErrors,
  ValidatorFn,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { SignUpService } from 'app/services/sing.service';
import { SnackBarService } from 'app/services/snackBar.service';
import { strongPasswordRegx } from 'app/utils/regex/hardPassword';

@Component({
  selector: 'app-form-signup',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './form-signup.component.html',
  styleUrl: './form-signup.component.scss',
})
export class FormSignupComponent {
  signUpForm: FormGroup;
  router = inject(Router);

  constructor(
    private form: FormBuilder,
    private signUpService: SignUpService,
    private snackBarService: SnackBarService,
  ) {
    this.signUpForm = this.form.group({
      correo: ['', [Validators.required, Validators.email]],
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      contraseña: [
        '',
        [
          Validators.required,
          Validators.pattern(strongPasswordRegx),
          this.MatchValidator('confirmacioncontraseña', 'contraseña'),
          this.PasswordValidator(),
        ],
      ],
      confirmacioncontraseña: [
        '',
        [
          Validators.required,
          this.MatchValidator('confirmacioncontraseña', 'contraseña'),
        ],
      ],
    });
  }

  MatchValidator(source: string, target: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      if (!this.signUpForm) return null;
      const sourceCtrl = this.signUpForm.get(source)?.value;
      const targetCtrl = this.signUpForm.get(target)?.value;
      console.log(sourceCtrl, targetCtrl);
      if (sourceCtrl === targetCtrl) return null;
      else return { passwordMismatch: true };
    };
  }

  hasErrors(controlName: string, errorType: string) {
    return (
      this.signUpForm.get(controlName)?.hasError(errorType) &&
      this.signUpForm.get(controlName)?.touched
    );
  }
  passwordFormField() {
    return this.signUpForm.get('contraseña');
  }

  PasswordValidator(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const value = control.value;
      const errors: ValidationErrors = {};

      if (!/[A-Z]/.test(value)) {
        errors['uppercase'] = true;
      }
      if (!/[a-z]/.test(value)) {
        errors['lowercase'] = true;
      }
      if (!/\d/.test(value)) {
        errors['digit'] = true;
      }
      if (!/[!@#$%^&*()\-_=+{};:,<.>]/.test(value)) {
        errors['special'] = true;
      }
      if (value.length < 8) {
        errors['length'] = true;
      }

      return Object.keys(errors).length ? errors : null;
    };
  }

  enviar() {
    this.signUpService.signUp(this.signUpForm).subscribe({
      next: (data) => {
        this.snackBarService.DisplayMessange(
          'El registro se realizo con exito',
          true,
        );
        this.router.navigate(['/login']);
      },
      error: (error) => {
        console.error('Error en la solicitud de registro:', error);
        const errorMessage =
          'Ocurrió un error durante el registro. Por favor, inténtelo de nuevo más tarde.';
      },
    });
  }
}
