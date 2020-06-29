import { CadastroModel } from './cadastro.model';
import { PrecadastroService } from './../service/precadastro.service';
import { Component, OnInit } from '@angular/core';
import { ResponseMessageModel } from '../response.message.model';

@Component({
  selector: 'ggiz-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  cadastro: CadastroModel = new CadastroModel();
  responseMessage: ResponseMessageModel;

  constructor(private preCadService: PrecadastroService) { }

  ngOnInit(): void {
  }

  efetuarCadastro() {
    const strUsuario = this.cadastro.usuario;
    const strEmail   = this.cadastro.email;
    const strMsgERR  = 'ERR-CAD';

    if ((strUsuario != null && strEmail != null)
        && (strUsuario.trim().length > 0 && strEmail.trim().length > 0)) {
       this.preCadService.cadUsuario(this.cadastro).subscribe(response => {
       this.responseMessage = response;
       const msgResponseServer = this.responseMessage.message;
       const codResponseServer = this.responseMessage.statusCode;

       if (msgResponseServer === strMsgERR
           && codResponseServer === -100) {
            window.location.href = '/erro';
       } else {
           window.location.href = '/aviso';
       }
      },
      err => {
         console.log('Ocorreu erro na transação que efetua o cadastro', err);
      });

    } else {
      alert('Informe o seu nome de Usuário e Email para efetuar o Cadastro.');
    }


  }

}
