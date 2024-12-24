import { Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { CadastroComponent } from './components/cadastro/cadastro.component';
import { ExtratoComponent } from './components/extrato/extrato.component';
export const routes: Routes = [
  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "home/:id",
    canActivate: [AuthGuard],
    component: HomeComponent,

  },
  {
    path: "extrato/:id/:cliente",
    canActivate: [AuthGuard],
    component: ExtratoComponent
  },
  {
    path: "cadastro",
    component: CadastroComponent
  },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];
