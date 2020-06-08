import { Injectable } from '@angular/core';
import { HttpInterceptor } from '@angular/common/http';
import { HttpRequest } from '@angular/common/http';
import { HttpHandler } from '@angular/common/http';
import { HttpEvent, HttpHeaders } from '@angular/common/http';
import { Injector } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private inj: Injector) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.getToken();
    if (token) {
      request = request.clone({
        setHeaders: {
          Authorization: `Basic ${this.getToken()}`
        }
      });
    } else {
      request = request.clone();
    }
    return next.handle(request);
  }
  getToken(): string {
    const username = localStorage.getItem('username');
    const password = localStorage.getItem('password');
    return btoa(username + ':' + password);
  }

}
