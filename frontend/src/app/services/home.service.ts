import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Conta } from '../models/conta';
import { catchError, EMPTY, map, Observable } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar'

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient, private snackBar: MatSnackBar) { }

  baseUrl = "http://localhost:8081/home"

  findContaByClientId(id: string): Observable<Conta> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Conta>(url).pipe(
      map((obj) => obj),
      catchError((e) => this.errorHandler(e))
    );
  }

  errorHandler(e: any): Observable<any> {
    this.showMessage('Ocorreu um erro!', true);
    return EMPTY;
  }

  showMessage(msg: string, isError: boolean = false): void {
    console.log("ERO E " + isError)
    this.snackBar.open(msg, 'X', {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ['msg-error'] : ['msg-success']
    });
  }
}
