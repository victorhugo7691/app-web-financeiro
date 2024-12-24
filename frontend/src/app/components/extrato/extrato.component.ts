import { Component, ViewChild } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';  // Importa o MatTableDataSource
import { Transacao } from '../../models/transacao';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from '../../auth.interceptor';
import { ExtratoService } from '../../services/extrato.service';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-extrato',
  standalone: true,
  imports: [MatTableModule, RouterLink, MatButtonModule, MatCardModule, MatPaginatorModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  templateUrl: './extrato.component.html',
  styleUrl: './extrato.component.css'
})
export class ExtratoComponent {
  transacoes!: Transacao[];
  displayedColumns: string[] = ['dataEHora', 'valor', 'tipo'];
  contaId!: string;
  clienteId!: string;
  saldo!: number;
  dataSource!: MatTableDataSource<Transacao>;  // Usando MatTableDataSource

  @ViewChild(MatPaginator) paginator!: MatPaginator;  // Referência do MatPaginator

  constructor(private route: ActivatedRoute, private extratoService: ExtratoService) {}

  ngOnInit(): void {
    this.contaId = this.route.snapshot.paramMap.get('id')!;
    this.clienteId = this.route.snapshot.paramMap.get('cliente')!;
    this.getExtrato(this.contaId);
    this.getConta(this.contaId);
  }

  getExtrato(id: string): void {
    this.extratoService.findTrasacoes(id).subscribe((response: Transacao[]) => {
      this.transacoes = response;
      this.dataSource = new MatTableDataSource(this.transacoes);  // Definindo o dataSource
      this.dataSource.paginator = this.paginator;  // Associando o paginator
    });
  }

  getConta(id: string): void {
    this.extratoService.getConta(id).subscribe(response => {
      this.saldo = response.saldo;
    });
  }
}
