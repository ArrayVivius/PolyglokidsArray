import { Injectable, inject } from '@angular/core';
import { HttpBackend, HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'environments/environment.development';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class SignUpService {
  constructor(
    private http: HttpClient,
    private handler: HttpBackend,
  ) {
    this.http = new HttpClient(handler);
  }

  signUp(user: FormGroup) {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
    });
    console.log(environment.apiUrl + '/auth/signUp');
    const form = user.getRawValue();
    const serialize = JSON.stringify(form);
    console.log(user.controls);
    return this.http.post(environment.apiUrl + '/auth/signUp', serialize, {
      headers,
    });
  }
}
