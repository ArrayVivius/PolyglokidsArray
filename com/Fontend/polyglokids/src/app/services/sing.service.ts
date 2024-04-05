import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class SignUpService {
  private apiUrl = 'https://api.example.com'; // URL de tu API

  constructor(private http: HttpClient) {}

  signUp(user: any) {
    return this.http.post(environment.apiUrl + '/auth/signIn', user);
  }
}