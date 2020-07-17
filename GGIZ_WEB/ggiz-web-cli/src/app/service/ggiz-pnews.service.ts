import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PNewsModel } from './../home/ggiz-noticias/pnews.model';
import { GGizNewsLerModel } from './../noticia/ggiz-news-ler/ggiz-news-ler-model';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GgizPnewsService {

  constructor(private http: HttpClient) { }

  public getNews(): Observable<PNewsModel[]> {
      return this.http.get<PNewsModel[]>('http://191.252.103.83:8080/ggiz/api/v1/noticias').
      pipe(catchError(this.handleError));
  }

  public showNews(id: string): Observable<GGizNewsLerModel> {
    return this.http.get<GGizNewsLerModel>('http://191.252.103.83:8080/ggiz/api/v1/noticia/ler/' + id)
    .pipe(catchError(this.handleError));
  }

  handleError(error: HttpErrorResponse){
    return throwError(error);
  }
}
