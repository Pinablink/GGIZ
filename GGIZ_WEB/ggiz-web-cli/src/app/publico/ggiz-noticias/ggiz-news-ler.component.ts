import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GgizPnewsService } from './../../service/ggiz-pnews.service';
import { GGizNewsLerModel } from './../../model/ggiz-news-ler-model';

@Component({
  selector: 'ggiz-ggiz-news-ler',
  templateUrl: './ggiz-news-ler.component.html',
  styleUrls: ['./ggiz-news-ler.component.css']
})
export class GgizNewsLerComponent implements OnInit {

  idNews: string;
  tituloNews: string;
  ggiznewsOb: GGizNewsLerModel;
  viewNews: boolean;
  notNews: boolean;
  errServer: boolean;

  constructor(private routed: ActivatedRoute, private service: GgizPnewsService) {}

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
