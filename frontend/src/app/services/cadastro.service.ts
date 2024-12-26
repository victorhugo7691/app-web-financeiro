import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CadastroCliente } from '../models/cadastro-cliente';
import { lastValueFrom } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  baseUrl = "https://app-web-financeiro.onrender.com/api/cadastro";

  constructor(private http: HttpClient) { }

  async save(cadastro: CadastroCliente) {
    await lastValueFrom(this.http.post(this.baseUrl, cadastro));
  }

}
