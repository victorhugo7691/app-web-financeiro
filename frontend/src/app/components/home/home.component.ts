
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
import { ActivatedRoute, RouterLink } from '@angular/router';
import { HomeService } from '../../services/home.service';
import { Conta } from '../../models/conta';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptor } from '../../auth.interceptor';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [MatCardModule, MatSlideToggleModule, FormsModule, MatTableModule, MatChipsModule, MatButtonModule, MatFormFieldModule, MatInputModule, RouterLink],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  transacoes!: Transacao[];
  saldo: number = 0;
  isOculto: boolean = true;
  cliente!: Cliente;
  conta!: Conta;

  constructor(private route: ActivatedRoute, private homeService: HomeService){}

  ngOnInit(): void {
    const id: string = this.route.snapshot.paramMap.get('id')!;
    this.getCliente(id);
    this.getConta(id);
  }

  getCliente(id: string){
    this.homeService.findClienteByClientId(id).subscribe(response => {
      this.cliente = response;
    });
  }

  getConta(id: string){
    this.homeService.findContaByClientId(id).subscribe(response => {
      this.conta = response;
      this.getMiniTransacoes();
    });
  }

  getMiniTransacoes(){
    this.homeService.findMiniTrasacoes(this.conta.id).subscribe(response => {
      this.transacoes = response;
    });
  }

  displayedColumns: string[] = ['dataEHora', 'valor', 'tipo'];

  Column = {
    id: "",
    valor: "",
    dataEHora: "",
    tipo: ""
  }
  creditVisible: boolean = false;
  debitVisible: boolean = false;
  valor!: number;

  showDebit() {
    if (this.debitVisible) {
      this.debitVisible = false;
    } else {
      this.debitVisible = true;
      this.creditVisible = false;
    }
  }

  creditar() {
    this.homeService.creditar(this.conta.id,this.valor).subscribe(response => {
      this.getConta(this.cliente.id.toString());
      this.getMiniTransacoes();
    });
  }

  debitar() {
    this.homeService.debitar(this.conta.id,this.valor).subscribe(response => {
      this.getConta(this.cliente.id.toString());
      this.getMiniTransacoes();
    });
  }

  showCredit() {
    if (this.creditVisible) {
      this.creditVisible = false;
    } else {
      this.creditVisible = true;
      this.debitVisible = false;
    }
  }

}
