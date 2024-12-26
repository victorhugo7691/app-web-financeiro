import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom, Observable } from 'rxjs';
import { Transacao } from '../models/transacao';
import { Conta } from '../models/conta';

@Injectable({
  providedIn: 'root'
})
export class ExtratoService {

  baseUrl = "https://app-web-financeiro.onrender.com/api/extrato";

  constructor(private http: HttpClient) { }

  findTrasacoes(id: string): Observable<Transacao[]> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Transacao[]>(url);
  }

  getConta(id: string): Observable<Conta> {
    const url = `${this.baseUrl}/conta/${id}`;
    return this.http.get<Conta>(url);
  }
}
