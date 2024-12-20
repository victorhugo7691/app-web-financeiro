import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor() {}

  isLoggedIn(): boolean {
    // Verifica no localStorage ou sessionStorage se o usuário está logado
    return !!localStorage.getItem('authToken');
  }

  login(accountNumber: number, password: string): boolean {
    // Aqui você faria a verificação com o back-end.
    // Supondo sucesso no login:
    localStorage.setItem('authToken', 'fake-jwt-token');
    return true;
  }

  logout(): void {
    localStorage.removeItem('authToken');
  }
}
