import { CadastroModel } from './../cadastro/cadastro.model';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PrecadastroService {

  constructor(private http: HttpClient) { }

  cadUsuario(refCadastro: CadastroModel): Observable<any> {
     return this.http.post('http://localhost:8080/ggiz/api/v1/pre/cad', refCadastro);
  }
}
