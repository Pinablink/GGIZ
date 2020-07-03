import { HttpErrorResponse } from '@angular/common/http';
import { CadastroModel } from './cadastro.model';
import { PrecadastroService } from './../service/precadastro.service';
import { Component, OnInit, TemplateRef } from '@angular/core';
import { ResponseMessageModel } from '../response.message.model';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Router } from '@angular/router';

@Component({
  selector: 'ggiz-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  cadastro: CadastroModel = new CadastroModel();
  responseMessage: ResponseMessageModel;
  serverNotFound: string;
  sendCad: boolean;
  modalRef: BsModalRef;
  constructor(private preCadService: PrecadastroService, private router: Router, private modalService: BsModalService) { }

  ngOnInit(): void {
    this.sendCad = false;
  }

  efetuarCadastro(template: TemplateRef<any>) {
    const strUsuario = this.cadastro.usuario;
    const strEmail   = this.cadastro.email;
    const strMsgERR  = 'ERR-CAD-USER';
    const strMsgSucess = 'SYS-SUCESS';

    if ((strUsuario != null && strEmail != null)
        && (strUsuario.trim().length > 0 && strEmail.trim().length > 0)
        && (this.validUsuario()) && (this.validEmail())) {

       this.sendCad = true;
       this.preCadService.cadUsuario(this.cadastro).subscribe(response => {
       this.responseMessage = response;
       const msgResponseServer = this.responseMessage.message;
       const codResponseServer = this.responseMessage.statusCode;

       if (msgResponseServer === strMsgERR) {
          this.serverNotFound = 'false';
          this.router.navigate(['/erro', this.serverNotFound]);
       } else if (msgResponseServer === strMsgSucess) {
           window.location.href = '/aviso';
       }
      },
        err => {
          if (err.name === 'HttpErrorResponse') {
            this.serverNotFound = 'true';
            this.router.navigate(['/erro', this.serverNotFound]);
          }
        }
      );

    } else {
      this.modalRef = this.modalService.show(template);
    }
  }

  private validUsuario(): boolean {
    let ret: boolean;
    const index = this.cadastro.usuario.length;
    let targetChar: number;

    ret = true;

    for (let i = 0; i <= index - 1; i++) {
       targetChar = this.cadastro.usuario.charCodeAt(i);

       if (!(targetChar >= 97 && targetChar <= 122)) {
        ret =  false;
        break;
       }
    }
    return ret;
  }

  private validEmail(): boolean {
    const regexpEmail = new RegExp('^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$');
    return regexpEmail.test(this.cadastro.email);
  }

}
