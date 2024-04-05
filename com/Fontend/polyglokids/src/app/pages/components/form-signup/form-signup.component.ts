import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  ValidationErrors,
  ValidatorFn,
  Validators,
} from '@angular/forms';
import { RouterLink } from '@angular/router';
import { SignUpService } from 'app/services/sing.service';
import { strongPasswordRegx } from 'app/utils/regex/hardPassword';
import { Router } from 'express';

@Component({
  selector: 'app-form-signup',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, RouterLink],
  templateUrl: './form-signup.component.html',
  styleUrl: './form-signup.component.scss',
})
export class FormSignupComponent {
  signUpForm: FormGroup;

  constructor(
    private form: FormBuilder,
    private signUpService: SignUpService,
    private router: Router,
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
    this.signUpService.signUp(this.signUpForm).subscribe(
      (response) => {
        this.router.navigate(['/signup']); // Redirigir al componente de registro
      },
      (error) => {
        console.error('Error en la solicitud de registro:', error);
        this.errorMessage =
          'Ocurrió un error durante el registro. Por favor, inténtelo de nuevo más tarde.';
        // Manejar errores (por ejemplo, mostrar un mensaje de error)
      },
    );
  }
}
