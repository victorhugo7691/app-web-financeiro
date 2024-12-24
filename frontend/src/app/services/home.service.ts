import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Conta } from '../models/conta';
import { catchError, EMPTY, map, Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar'
import { Cliente } from '../models/cliente';
import { Transacao } from '../models/transacao';
import { lastValueFrom } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient, private snackBar: MatSnackBar) { }

  baseUrl = "http://localhost:8081/api/home";

  findContaByClientId(id: string): Observable<Conta> {
    const url = `${this.baseUrl}/conta/${id}`;
    return this.http.get<Conta>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  findClienteByClientId(id: string): Observable<Cliente> {
    const url = `${this.baseUrl}/cliente/${id}`;
    return this.http.get<Cliente>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  findMiniTrasacoes(id: string): Observable<Transacao[]> {
    const url = `${this.baseUrl}/mini-extrato/${id}`;
    return this.http.get<Transacao[]>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  creditar(ContaId: string, valor: number): Observable<string> {
    const url = `${this.baseUrl}/creditar/${ContaId}?valor=${valor}`;
    return this.http.post<string>(url, null, { responseType: 'text' as 'json' }).pipe(
      map((response) => {
        console.log('Resposta do backend:', response);  // Verifique o que está chegando no frontend
        return response;
      }),
      catchError((e) => this.errorHandler(e))
    );
  }

  debitar(ContaId: string, valor: number): Observable<string> {
    const url = `${this.baseUrl}/debitar/${ContaId}?valor=${valor}`;
    return this.http.post<string>(url, null, { responseType: 'text' as 'json' }).pipe(
      catchError((e) => this.errorHandler(e))
    );
  }

  errorHandler(e: any): Observable<any> {
    console.error('Erro capturado no errorHandler:', e); // Log completo do erro
    this.showMessage('Ocorreu um erro!', true);
    return EMPTY;
  }

  showMessage(msg: string, isError: boolean = false): void {
    console.log("ERRO E " + isError)
    this.snackBar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ['msg-error'] : ['msg-success']
    });
  }
}
