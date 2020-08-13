import { HttpErrorResponse } from '@angular/common/http';
import { CadastroModel } from './cadastro.model';
//import { PrecadastroService } from './../service/precadastro.service';
import { Component, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { ResponseMessageModel } from './../model/response.message.model';
import { BsModalService, BsModalRef } from 'ngx-bootstrap/modal';
import { Router } from '@angular/router';

@Component({
  selector: 'ggiz-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
  @ViewChild('cadDupTemplate') cadDupTemplate: TemplateRef<any>;
  @ViewChild('cadMailUserDupTemplate') cadMailUserDupTemplate: TemplateRef<any>;
  @ViewChild('cadMailDup') cadMailDup: TemplateRef<any>;
  @ViewChild('errSys') errSys: TemplateRef<any>;
  cadastro: CadastroModel = new CadastroModel();
  responseMessage: ResponseMessageModel;
  sendCad: boolean;
  modalRef: BsModalRef;
  modalRefCadDupUser: BsModalRef;
  modalRefCadMailDupUser: BsModalRef;
  modalRefCadMailDup: BsModalRef;
  modalRefErrSys: BsModalRef;
  cadUsuario: boolean;
  avisoError: boolean;
  avisoSucess: boolean;
  about: boolean;

  //constructor(private preCadService: PrecadastroService, private modalService: BsModalService) { }
  // constructor(private preCadService: PrecadastroService, private router: Router, private modalService: BsModalService) { }
  constructor(private modalService: BsModalService) { }

  ngOnInit(): void {
    this.cadUsuario = true;
    this.sendCad = false;
    this.avisoError = false;
    this.avisoSucess = false;
  }

  /*efetuarCadastro(template: TemplateRef<any>): void {
    const strUsuario = this.cadastro.usuario;
    const strEmail   = this.cadastro.email;
    const strMsgERR  = 'ERR-CAD-USER';
    const strMsgDupEmail = 'ERR-DUP-EMAIL';
    const strMsgSucess = 'SYS-SUCESS';
    const strMsgDupUser = 'ERR-DUP-USER';
    const strMsgDupMuser = 'ERR-DUP-MAILUSER';

    if ((strUsuario != null && strEmail != null)
        && (strUsuario.trim().length > 0 && strEmail.trim().length > 0)
        && (this.validUsuario()) && (this.validEmail())) {

       this.sendCad = true;
       this.preCadService.cadUsuario(this.cadastro).subscribe(response => {
       this.responseMessage = response;
       const msgResponseServer = this.responseMessage.message;
       const codResponseServer = this.responseMessage.statusCode;

       if (msgResponseServer === strMsgSucess) {
          this.avisoSucess = true;
          this.avisoError = false;
          this.cadUsuario = false;
        // Para futura analise
        // window.location.href = '/aviso';
       }
      },
        err => {
          if (err.name === 'HttpErrorResponse') {

            const msgResponseErrorServer = err.error.message;
            console.log(msgResponseErrorServer);
            if (msgResponseErrorServer === strMsgDupUser) {
              this.sendCad = false;
              this.modalRefCadDupUser = this.modalService.show(this.cadDupTemplate);
             } else if (msgResponseErrorServer === strMsgDupEmail) {
              this.sendCad = false;
              this.modalRefCadMailDup = this.modalService.show(this.cadMailDup);
             } else if (msgResponseErrorServer === strMsgDupMuser) {
              this.sendCad = false;
              this.modalRefCadMailDupUser = this.modalService.show(this.cadMailUserDupTemplate);
            } else if (msgResponseErrorServer === strMsgERR) {
              this.sendCad = false;
              this.modalRefErrSys = this.modalService.show(this.errSys);
            } else {
              this.cadUsuario = false;
              this.avisoError = true;
              this.avisoSucess = false;
             }

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

  public returnCad(): void {
    this.sendCad = false;
    this.cadUsuario = true;
    this.avisoError = false;
    this.avisoSucess = false;
  }

  public showAbout(): void {
    this.cadUsuario = false;
    this.about = true;
  }
*/

}
