import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CadastroCliente } from '../models/cadastro-cliente';
import { lastValueFrom } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CadastroService {

  private baseUrl = environment.apiUrl + "/cadastro";

  constructor(private http: HttpClient) { }

  async save(cadastro: CadastroCliente) {
    await lastValueFrom(this.http.post(this.baseUrl, cadastro));
  }

}
