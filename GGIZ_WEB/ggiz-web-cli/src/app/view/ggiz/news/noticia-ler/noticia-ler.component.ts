import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NewsService } from './../../../../service/ggiz/news.service';
import { GGizNewsLerModel } from './../../../../model/ggiz-news-ler-model';

@Component({
  selector: 'ggiz-noticia-ler',
  templateUrl: './noticia-ler.component.html',
  styleUrls: ['./noticia-ler.component.css']
})
export class NoticiaLerComponent implements OnInit {

  public idNews: string;
  public tituloNews: string;
  public ggiznewsOb: GGizNewsLerModel;
  public viewNews: boolean;
  public notNews: boolean;
  public errServer: boolean;

  constructor(private routed: ActivatedRoute, private service: NewsService) {}

  ngOnInit(): void {
    this.idNews = this.routed.snapshot.paramMap.get('id');
    this.tituloNews = this.routed.snapshot.paramMap.get('titulo');

    this.service.showNews (this.idNews).subscribe((obGGizNews: GGizNewsLerModel) =>
    {
        this.ggiznewsOb = obGGizNews;
        this.viewNews = true;
    },
    err => {

      if (err.name === 'HttpErrorResponse') {

        const msgResponseErrorServer = err.error.message;

        if (msgResponseErrorServer === 'ERR-LER-NEWS-NOT-FOUND') {
          this.notNews = true;
          this.viewNews = false;
          this.errServer = false;
        } else {
          this.errServer = true;
          this.viewNews = false;
          this.notNews = false;
        }

      }

     });

  }

}
