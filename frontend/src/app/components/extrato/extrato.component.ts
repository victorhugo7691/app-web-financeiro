import { Component } from '@angular/core';
import {MatTableModule} from '@angular/material/table';
import { Transacao } from '../../models/transacao';
import {ActivatedRoute, RouterLink} from '@angular/router';
import {MatButtonModule} from '@angular/material/button';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from '../../auth.interceptor';
import { ExtratoService } from '../../services/extrato.service';
import { MatCardModule } from '@angular/material/card';
@Component({
  selector: 'app-extrato',
  standalone: true,
  imports: [MatTableModule, RouterLink, MatButtonModule, MatCardModule],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }],
  templateUrl: './extrato.component.html',
  styleUrl: './extrato.component.css'
})
export class ExtratoComponent {
  transacoes!: Transacao[];
  displayedColumns: string[] = ['id', 'dataEHora', 'valor', 'tipo'];
  contaId!: string;
  clienteId!: string;
  saldo!: number;

  constructor(private route: ActivatedRoute, private extratoService: ExtratoService){}

  ngOnInit(): void{
    this.contaId = this.route.snapshot.paramMap.get('id')!;
    this.clienteId = this.route.snapshot.paramMap.get('cliente')!;
    this.getExtrato(this.contaId);
    this.getConta(this.contaId);
  }

  getExtrato(id: string){
    this.extratoService.findTrasacoes(id).subscribe((response: Transacao[]) => {
      this.transacoes = response;
    });
  }

  getConta(id: string){
    this.extratoService.getConta(id).subscribe(response => {
      this.saldo = response.saldo;
    });
  }
}
