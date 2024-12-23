import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../models/login';
import { Conta } from '../models/conta';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8081/login'; // URL do backend para login

  constructor(private http: HttpClient) {}

  login(login: Login): Observable<Conta> {
    return this.http.post<Conta>(this.apiUrl, login);  // Envia a requisição para o backend
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('clienteId'); // Verifica se o clienteId está presente no localStorage
  }

  logout(): void {
    localStorage.removeItem('clienteId'); // Remove o clienteId do localStorage
  }
}
