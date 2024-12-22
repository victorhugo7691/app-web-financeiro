import { Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { CadastroComponent } from './components/cadastro/cadastro.component';

export const routes: Routes = [
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "home",
    canActivate: [AuthGuard],
    component: HomeComponent
  },
  {
    path: "cadastro",
    component: CadastroComponent
  },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];
