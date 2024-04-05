import {
  AbstractControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
} from '@angular/forms';

export class CustomValidators {
  static MatchValidator(source: string, target: string): ValidatorFn {
    return (control: FormGroup) => {
      const sourceCtrl = control.value;
      const targetCtrl = control.controls;

      console.log('sdasdasdas');
      console.log(source);
      console.log(target);
      console.log(sourceCtrl);
      console.log(targetCtrl);
      return sourceCtrl && targetCtrl && sourceCtrl.value !== targetCtrl
        ? { passwordMismatch: true }
        : null;
    };
  }
}
