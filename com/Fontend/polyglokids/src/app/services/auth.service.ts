import {
  HttpClient,
  HttpErrorResponse,
  HttpParams,
} from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Router } from '@angular/router';
import { UserStore } from 'app/store/user.store';
import { environment } from 'environments/environment.development';
import { jwtDecode } from 'jwt-decode';
import { BehaviorSubject, Observable, catchError, map, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private readonly JWT_TOKEN = 'JWT_TOKEN';
  private loggedUser?: string;
  private isAuthenticatedSubject = new BehaviorSubject<boolean>(false);
  private router = inject(Router);
  private http = inject(HttpClient);
  private userStore = inject(UserStore);

  constructor() {}

  login(user: { email: string; password: string }): Observable<any> {
    const params = new HttpParams()
      .set('correo', user.email)
      .set('contraseña', user.password);
    return this.http.get(environment.apiUrl + '/auth/signIn', { params }).pipe(
      map((response: any) => {
        return {
          id: response.user.id,
          correo: response.user.correo,
          nombre: response.user.nombre,
          apellido: response.user.apellido,
          roles: response.user.roles,
          token: response.token, // Add this line
        };
      }),
      tap((user: any) => {
        this.doLoginUser(user.correo, JSON.stringify(user.token)); // Change this line
      }),
      catchError((error: HttpErrorResponse) => {
        throw error;
      }),
    );
  }

  private doLoginUser(email: string, token: any) {
    this.loggedUser = email;
    this.storeJwtToken(token);
    this.isAuthenticatedSubject.next(true);
  }

  private storeJwtToken(jwt: string) {
    localStorage.setItem(this.JWT_TOKEN, jwt);
  }

  logout() {
    localStorage.removeItem(this.JWT_TOKEN);
    this.isAuthenticatedSubject.next(false);
  }

  getCurrentAuthUser() {
    return this.http.get('https://api.escuelajs.co/api/v1/auth/profile').pipe;
  }

  isLoggedIn() {
    if (typeof window !== 'undefined') {
      return !!localStorage && !!localStorage.getItem(this.JWT_TOKEN);
    }
    return false;
  }

  isTokenExpired() {
    const tokens = localStorage.getItem(this.JWT_TOKEN);
    if (!tokens) return true;
    const token = JSON.parse(tokens).access_token;
    const decoded = jwtDecode(token);
    if (!decoded.exp) return true;
    const expirationDate = decoded.exp * 1000;
    const now = new Date().getTime();

    return expirationDate < now;
  }

  refreshToken() {
    let tokens: any = localStorage.getItem(this.JWT_TOKEN);
    if (!tokens) return;
    tokens = JSON.parse(tokens);
    let refreshToken = tokens.refresh_token;
    return this.http
      .post<any>('https://api.escuelajs.co/api/v1/auth/refresh-token', {
        refreshToken,
      })
      .pipe(tap((tokens: any) => this.storeJwtToken(JSON.stringify(tokens))));
  }
}
