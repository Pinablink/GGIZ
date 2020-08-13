import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PNewsModel } from './../model/pnews.model';
import { GGizNewsLerModel } from './../model/ggiz-news-ler-model';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GgizPnewsService {


  constructor(private http: HttpClient) { }

  public getNews(): Observable<PNewsModel[]> {

    const configHeader = {headers:  {
      token: ''}
  };

    return this.http.get<PNewsModel[]>('http://localhost:8080/ggiz/api/v1/noticias').
    //return this.http.get<PNewsModel[]>('http://localhost:80/service/ggiz/noticias', configHeader).
      pipe(catchError(this.handleError));
  }

  public showNews(id: string): Observable<GGizNewsLerModel> {
    //return this.http.get<GGizNewsLerModel>('http://localhost:8080/ggiz/api/v1/noticia/ler/' + id)
    return this.http.get<GGizNewsLerModel>('http://localhost:80/service/ggiz/noticia/' + id)
    .pipe(catchError(this.handleError));
  }

  handleError(error: HttpErrorResponse){
    return throwError(error);
  }
}
