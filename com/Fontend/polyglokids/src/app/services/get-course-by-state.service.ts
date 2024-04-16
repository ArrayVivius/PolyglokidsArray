import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, computed, inject, signal } from '@angular/core';
import { environment } from 'environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class UserCourseByStatusServices {
  private http = inject(HttpClient);

  #state = signal({
    courses: [],
    loading: true,
  });

  public courses = computed(() => this.#state().courses);

  constructor() {
    const jwt = localStorage.getItem('JWT_TOKEN');
    console.log('asddasdawdadsa ' + jwt);
    // const params = new HttpParams().set(
    //   'id',
    //   'e66ee26e-fa80-43ac-aa74-52b4fa021bb3',
    // );
    const headers = {
      Authorization: 'Bearer' + jwt,
    };
    this.http
      .get<any>(
        environment.apiUrl +
          '/UserCourseByStatus/38d437f4-4ca5-4662-8e8f-65455a1afe7e',
        { headers },
      )
      .subscribe((res) => {
        this.#state.set({
          loading: false,
          courses: res,
        });
      });
  }
}
