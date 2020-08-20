import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { GGizTokenModel } from './../../../../model/ggiz-token.model';
import { NewsService } from './../../../../service/ggiz/news.service';
import { TokenService } from './../../../../service/ggiz/token.service';
import { PNewsModel } from './../../../../model/pnews.model';

@Component({
  selector: 'ggiz-noticia',
  templateUrl: './noticia.component.html',
  styleUrls: ['./noticia.component.css']
})
export class NoticiaComponent implements OnInit {

  public pNews: PNewsModel[];
  public notContent: boolean;
  public viewNews: boolean;
  public errServer: boolean;
  public errServerToken: boolean;

   constructor(private service: NewsService, private route: Router) {}

  /*constructor(private route: Router, private serviceToken: GgizTokenService){
    super();
  }*/

  public ngOnInit(): void {
    /*this.serviceToken.getToken().subscribe((ggizToken: GGizTokenModel) =>
    {
       this.ggizToken = ggizToken;
       alert('Token Obtido ' + this.ggizToken.token);
    },
      err => {
        if (err.name === 'HttpErrorResponse') {
          const msgResponseErrorServer = err.error.message;
          console.log('Teste de obtencao de token... Erro Ocorrido');
        }
      }
    );*/
    this.service.getNews().subscribe( (pNews: PNewsModel[]) =>
     {
       this.pNews = pNews;

       if (this.pNews.length >= 0) {
         this.notContent = false;
         this.errServer = false;
         this.viewNews = true;
       }
     },
     err => {

      if (err.name === 'HttpErrorResponse') {

        const msgResponseErrorServer = err.error.message;

        if (msgResponseErrorServer === 'ERR-NEWS-NOT-FOUND') {
          this.notContent = true;
          this.errServer = false;
          this.viewNews = false;
        } else if (msgResponseErrorServer === 'ERR-TOKEN-UNKNOWN') {
          this.notContent = false;
          this.errServer = false;
          this.viewNews = false;
          this.errServerToken = true;
        } else {
          this.notContent = false;
          this.errServer = true;
          this.viewNews = false;
         }

      }

     }
    );

  }

  public showNews(id: string, titulo: string): void {
    this.route.navigate(['noticia', id, titulo]);
  }

}
