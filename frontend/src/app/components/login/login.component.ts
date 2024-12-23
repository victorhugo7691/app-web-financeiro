import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Login } from '../../models/login';
import { Conta } from '../../models/conta';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, MatCardModule, MatButtonModule, RouterLink, MatFormFieldModule, MatInputModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  user: Login = {
    numeroDaConta: 0,
    senha: ''
  }

  constructor(private authService: AuthService, private router: Router) {}

  login(): void {

    this.authService.login(this.user).subscribe({
      next: (response: Conta) => { // Especifica o tipo de resposta como Conta
        localStorage.setItem('clienteId', response.clienteId.toString()); // Armazena o clienteId no localStorage
        this.router.navigate(['/home']); // Redireciona para a página home
      },
      error: (err) => {
        alert('Falha na tentativa de login, verifique o número da conta e senha!');
      }
    });
  }
}
