import { Transacao } from './../../models/transacao';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatSlideToggleModule,_MatSlideToggleRequiredValidatorModule} from '@angular/material/slide-toggle';
import {MatTableModule} from '@angular/material/table';
import { Cliente } from '../../models/cliente';
import {MatChipsModule} from '@angular/material/chips';
import { MatButtonModule } from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { RouterLink } from '@angular/router';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatCardModule, MatSlideToggleModule, FormsModule, MatTableModule, MatChipsModule, MatButtonModule, MatFormFieldModule, MatInputModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  transacoes: Transacao[] = [
    {id: '01', dataEHora: '10:30', valor: 10.0, tipo: 'credito', contaId: '000092-6'},
    {id: '02', dataEHora: '12:30', valor: 5.0, tipo: 'debito', contaId: '000092-6'},
    {id: '03', dataEHora: '15:30', valor: 2.0, tipo: 'debito', contaId: '000092-6'},
    {id: '04', dataEHora: '16:30', valor: 3.0, tipo: 'credito', contaId: '000092-6'}
  ];

  saldo!: number;
  isOculto: boolean = true;
  cliente!: Cliente;

  transacao: Transacao = {
    id: '05',
    dataEHora: '18:30',
    valor: 1.5,
    tipo: 'debito',
    contaId: '000092-6'
  }

  getTransacoes(): void {
    let updatedTransacoes: Transacao[] = [];
    let transacao: Transacao = {
      id: '05',
      dataEHora: '18:30',
      valor: 1.5,
      tipo: 'debito',
      contaId: '000092-6'
    };

    updatedTransacoes.push(transacao);
    try {
      // transacoesService.getTransacoes(cliente.id).then(transacoes) => {
      //   updatedTransacoes = transacoes;
      // }
      //this.transacoes = updatedTransacoes;
    } catch(error: any) {
      //this.transacoes = [];
      console.log(error.message);
    }
  }

  // transacoes = new MatTableDataSource<Transacao>();

  displayedColumns: string[] = ['id', 'dataEHora', 'valor', 'tipo'];

  Column = {
    id: "",
    valor: "",
    dataEHora: "",
    tipo: ""
  }
  creditVisible: boolean = false;
  debitVisible: boolean = false;
  valorDebito: number = 0;
  valorCredito: number = 0;

  debitar() {
    if (this.debitVisible) {
      this.debitVisible = false;
    } else {
      this.debitVisible = true;
      this.creditVisible = false;
    }
  }
  creditar() {
    if (this.creditVisible) {
      this.creditVisible = false;
    } else {
      this.creditVisible = true;
      this.debitVisible = false;
    }
  }

}
