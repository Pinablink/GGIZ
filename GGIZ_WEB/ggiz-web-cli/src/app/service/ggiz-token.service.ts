import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GGizTokenModel } from './../model/ggiz-token.model';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class GgizTokenService {

  public constructor(public httpClient: HttpClient) { }

  public getToken(): Observable<GGizTokenModel>{
    return this.httpClient.get<GGizTokenModel>('http://localhost:80/service/ggiz/token').
    pipe(catchError(this.handleError));
  }

  public handleError(error: HttpErrorResponse){
    return throwError(error);
  }
}
