import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const clienteId = localStorage.getItem('clienteId');

    if (clienteId) {
      const cloned = req.clone({
        setHeaders: {
          Authorization: `Bearer ${clienteId}` // Adiciona o clienteId no header
        }
      });
      return next.handle(cloned);
    }

    return next.handle(req);
  }
}
