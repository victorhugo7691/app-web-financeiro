import { CadastroService } from './../../services/cadastro.service';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatTableModule } from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import { CadastroCliente } from '../../models/cadastro-cliente';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatCardModule,
    MatSlideToggleModule,
    FormsModule,
    MatTableModule,
    MatChipsModule,
    MatButtonModule,
    MatInputModule,
    RouterLink,
  ],
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.css',
  providers: [BrowserAnimationsModule]
})
export class CadastroComponent {
  cadastro: CadastroCliente = {
    nomeDoCliente: '',
    idade: null,
    email: '',
    numeroDaConta: null,
    senha: ''
  }

  constructor(private cadastroService: CadastroService, private router: Router) { }

  async onSubmit() {
    try {
      this.cadastroService.save(this.cadastro);
      this.router.navigate(['/login']);
    } catch(error: any) {
      console.error(error.message);
    }
  }
}
