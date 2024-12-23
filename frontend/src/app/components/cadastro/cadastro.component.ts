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
  ],
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.css',
  providers: [BrowserAnimationsModule]
})
export class CadastroComponent {
  cadastro: CadastroCliente = {
    nomeDoCliente: '',
    idade: 0,
    email: '',
    numeroDaConta: 0,
    senha: ''
  }
  async onSubmit() {
    try {
      console.log(this.cadastro);
    } catch(error: any) {
      console.error(error.message);
    }
  }
}
