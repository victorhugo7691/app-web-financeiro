import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../models/login';
import { Conta } from '../models/conta';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient) {}

  login(login: Login): Observable<Conta> {
    return this.http.post<Conta>(`${this.apiUrl}/login`, login);  // Envia a requisição para o backend
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('clienteId'); // Verifica se o clienteId está presente no localStorage
  }

  logout(): void {
    localStorage.removeItem('clienteId'); // Remove o clienteId do localStorage
  }
}
