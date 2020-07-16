import { CadastroModel } from './../cadastro/cadastro.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrecadastroService {

  constructor(private http: HttpClient) { }

  cadUsuario(refCadastro: CadastroModel): Observable<any> {
     return this.http.post('http://191.252.103.83:8080/ggiz/api/v1/pre/cad', refCadastro);
  }

  handleError(error: HttpErrorResponse) {
    return throwError(error);
  }
}
