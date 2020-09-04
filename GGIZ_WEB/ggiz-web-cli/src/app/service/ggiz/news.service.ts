import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PNewsModel } from './../../model/pnews.model';
import { GGizNewsLerModel } from './../../model/ggiz-news-ler-model';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  constructor(private http: HttpClient) { }

  public getNews(strToken: string): Observable<PNewsModel[]> {

    const configHeader = {headers:  {
      token: strToken}
    };

    return this.http.get<PNewsModel[]>('http://localhost:80/service/ggiz/noticias', configHeader).
      pipe(catchError(this.handleError));
  }

  public showNews(strToken: string, id: string): Observable<GGizNewsLerModel> {
    const configHeader = {headers:  {
      token: strToken}
    };
    return this.http.get<GGizNewsLerModel>('http://localhost:80/service/ggiz/noticia/' + id, configHeader)
    .pipe(catchError(this.handleError));
  }

  handleError(error: HttpErrorResponse){
    return throwError(error);
  }

}
