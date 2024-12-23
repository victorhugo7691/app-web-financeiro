import { Component } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { Transacao } from '../../models/transacao';
import {RouterLink} from '@angular/router';
import {MatButtonModule} from '@angular/material/button';
@Component({
  selector: 'app-extrato',
  standalone: true,
  imports: [MatTableModule, RouterLink, MatButtonModule],
  templateUrl: './extrato.component.html',
  styleUrl: './extrato.component.css'
})
export class ExtratoComponent {
  transacoes: Transacao[] = [
    {id: '01', dataEHora: '10:30', valor: 10.0, tipo: 'credito', contaId: '000092-6'},
    {id: '02', dataEHora: '12:30', valor: 5.0, tipo: 'debito', contaId: '000092-6'},
    {id: '03', dataEHora: '15:30', valor: 2.0, tipo: 'debito', contaId: '000092-6'},
    {id: '04', dataEHora: '16:30', valor: 3.0, tipo: 'credito', contaId: '000092-6'}
  ];
  displayedColumns: string[] = ['id', 'dataEHora', 'valor', 'tipo'];
}
