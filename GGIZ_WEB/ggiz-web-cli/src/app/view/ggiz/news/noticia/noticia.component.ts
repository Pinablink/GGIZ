import { Component, OnInit, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

import { BroadnewsService } from './../../../../service/broadcast/broadnews.service';
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
  public errServerTokenOff: boolean;
  public errServerTokenInvalid: boolean;

  constructor(private bnService: BroadnewsService, private nwservice: NewsService, private service: TokenService, private route: Router) {}

  public ngOnInit(): void {
    this.bnService.getEmitter().emit(true);
    const vl: boolean = this.service.existToken();

    this.notContent = false;
    this.viewNews = false;
    this.errServer = false;
    this.errServerToken = false;
    this.errServerTokenOff = false;
    this.errServerTokenInvalid = false;

    if (vl) {
      this.loadNews(this.service.getToken());
    } else {
        this.loadToken();
    }

  }

  public loadToken(): void {
    this.service.loadToken().subscribe((ggizToken: GGizTokenModel) =>
    {
      this.bnService.getEmitter().emit(false);
      this.service.setToken(ggizToken.token);
      this.loadNews(ggizToken);
    },
      err => {

        this.bnService.getEmitter().emit(false);

        if (err.name === 'HttpErrorResponse') {
          const msgResponseErrorServer = err.error.message;
          if ( msgResponseErrorServer == null) {
            this.errServerTokenOff = true;
          } else {
            this.errServerTokenOff = false;
          }

        }
      }
    );

  }

  public loadNews(ggizToken: GGizTokenModel): void {
    this.nwservice.getNews(ggizToken.token).subscribe( (pNews: PNewsModel[]) =>
     {
       this.bnService.getEmitter().emit(false);
       this.pNews = pNews;
       if (this.pNews.length >= 0) {
         this.notContent = false;
         this.errServer = false;
         this.viewNews = true;
       }
     },
     err => {
      this.bnService.getEmitter().emit(false);

      if (err.name === 'HttpErrorResponse') {

        const msgResponseErrorServer = err.error.message;

        if (msgResponseErrorServer === 'ERR-NEWS-NOT-FOUND') {
          this.notContent = true;
          this.errServer = false;
          this.viewNews = false;
          this.errServerTokenInvalid = false;
        } else if (msgResponseErrorServer === 'ERR-TOKEN-UNKNOWN') {
          this.notContent = false;
          this.errServer = false;
          this.viewNews       = false;
          this.errServerTokenInvalid = false;
          this.errServerToken = true;
        } else if (msgResponseErrorServer === 'ERR-TOKEN-INVALID') {
          this.notContent = false;
          this.errServer = false;
          this.viewNews       = false;
          this.errServerToken = false;
          this.errServerTokenInvalid = true;
        } else if (msgResponseErrorServer === 'ERR-TOKEN-EXPIRED') {
            this.loadToken();
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
