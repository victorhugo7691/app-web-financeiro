import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Component } from '@angular/core';
import { AuthService } from '../../auth.service';
import { Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, MatCardModule, MatButtonModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  accountNumber!: number;
  password: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  login(): void {

    if (this.authService.login(this.accountNumber, this.password)) {
      this.router.navigate(['/home']);
    } else {
      alert('Falha na tentativa de login, verifique o número da conta e senha!');
    }
  }
}
