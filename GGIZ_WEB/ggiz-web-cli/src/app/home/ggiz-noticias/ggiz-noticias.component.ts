import { GgizPnewsService } from './../../service/ggiz-pnews.service';
import { Component, OnInit } from '@angular/core';
import { PNewsModel } from './pnews.model';

@Component({
  selector: 'ggiz-ggiz-noticias',
  templateUrl: './ggiz-noticias.component.html',
  styleUrls: ['./ggiz-noticias.component.css']
})
export class GgizNoticiasComponent implements OnInit {

  pNews: PNewsModel[];
  notContent: boolean;
  viewNews: boolean;
  errServer: boolean;

  constructor(private service: GgizPnewsService) { }

  ngOnInit(): void {
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
        } else {
          this.notContent = false;
          this.errServer = true;
          this.viewNews = false;
         }

      }

     }
    );

  }
}
