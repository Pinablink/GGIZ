import { AfterViewInit, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TokenService } from './../../../../service/ggiz/token.service';
import { NewsService } from './../../../../service/ggiz/news.service';
import { GGizNewsLerModel } from './../../../../model/ggiz-news-ler-model';
import { GGizTokenModel } from './../../../../model/ggiz-token.model';
import { BroadnewsService } from './../../../../service/broadcast/broadnews.service';
// import { NgShowReadNewsDirective } from './../../../../shared/ng-show-read-news.directive';
import { BroadcastReadNewsService } from './../../../../service/broadcast/broadcast-read-news.service';
import { DirConsService } from './../../../../service/ggiz/dir-cons.service';

@Component({
  selector: 'ggiz-noticia-ler',
  templateUrl: './noticia-ler.component.html',
  styleUrls: ['./noticia-ler.component.css']
})
export class NoticiaLerComponent implements OnInit  {

  public idNews: string;
  public tituloNews: string;
  public ggiznewsOb: GGizNewsLerModel;
  public viewNews: boolean;
  public notNews: boolean;
  public errServer: boolean;
  public lerrServerToken: boolean;
  public lerrServerTokenOff: boolean;
  public lerrServerTokenInvalid: boolean;
  private texto: string;

  constructor(private bnService: BroadnewsService,
              private tokenservice: TokenService,
              private routed: ActivatedRoute,
              private service: NewsService) {
  }

  ngOnInit(): void {
    this.bnService.getEmitter().emit(true);
    const vl: boolean = this.tokenservice.existToken();

    this.notNews = false;
    this.errServer = false;
    this.lerrServerToken = false;
    this.lerrServerTokenOff = false;
    this.lerrServerTokenInvalid = false;

    if (vl) {
      this.loadReadNews(this.tokenservice.getToken());
    } else {
      this.loadToken();
    }

  }

  public loadToken(): void {
    this.tokenservice.loadToken().subscribe((ggizToken: GGizTokenModel) =>
    {
      this.bnService.getEmitter().emit(false);
      this.tokenservice.setToken(ggizToken.token);
      this.loadReadNews(ggizToken);
    },
      err => {
        this.bnService.getEmitter().emit(false);
        if (err.name === 'HttpErrorResponse') {
          const msgResponseErrorServer = err.error.message;
          if ( msgResponseErrorServer == null) {
            this.lerrServerTokenOff = true;
          } else {
            this.lerrServerTokenOff = false;
          }
        }
      }
    );

  }

  public loadReadNews(ggizToken: GGizTokenModel): void {

    this.idNews = this.routed.snapshot.paramMap.get('id');
    this.tituloNews = this.routed.snapshot.paramMap.get('titulo');

    this.service.showNews (ggizToken.token, this.idNews).subscribe((obGGizNews: GGizNewsLerModel) =>
    {
      this.bnService.getEmitter().emit(false);
      this.ggiznewsOb = obGGizNews;
      this.viewNews = true;
    },
    err => {
      this.bnService.getEmitter().emit(false);

      if (err.name === 'HttpErrorResponse') {

        const msgResponseErrorServer = err.error.message;

        if (msgResponseErrorServer === 'ERR-NEWS-NOT-FOUND') {
          this.notNews = true;
          this.errServer = false;
          this.viewNews = false;
          this.lerrServerTokenInvalid = false;
        } else if (msgResponseErrorServer === 'ERR-TOKEN-UNKNOWN') {
          this.notNews = false;
          this.errServer = false;
          this.viewNews       = false;
          this.lerrServerTokenInvalid = false;
          this.lerrServerToken = true;
        } else if (msgResponseErrorServer === 'ERR-TOKEN-INVALID') {
          this.notNews = false;
          this.errServer = false;
          this.viewNews       = false;
          this.lerrServerToken = false;
          this.lerrServerTokenInvalid = true;
        } else if (msgResponseErrorServer === 'ERR-TOKEN-EXPIRED') {
            this.loadToken();
        } else {
          this.notNews = false;
          this.errServer = true;
          this.viewNews = false;
         }

      }

     });

  }

  public loadSpanNews(): void {
    console.log(`TESTANDO ONLOAD`);
  }

}
