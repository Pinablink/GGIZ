import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PNewsModel } from './../home/ggiz-noticias/pnews.model';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GgizPnewsService {

  constructor(private http: HttpClient) { }

  public getNews(): Observable<PNewsModel[]> {
      return this.http.get<PNewsModel[]>('http://localhost:8080/ggiz/api/v1/noticias').
      pipe(catchError(this.handleError));
  }

  handleError(error: HttpErrorResponse){
    return throwError(error);
  }
}
