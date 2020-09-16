import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GGizTokenModel } from './../../model/ggiz-token.model';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

private ggiztoken: GGizTokenModel;

  public constructor(private httpClient: HttpClient) {
    if (this.ggiztoken == null) {
      this.ggiztoken = new GGizTokenModel();
    }
  }

  public setToken(strToken: string): void {
     this.ggiztoken.token = strToken;
  }

  public existToken(): boolean{
    return (this.ggiztoken.token != null
      && this.ggiztoken.token.length > 0);
  }

  public getToken(): GGizTokenModel{
    return this.ggiztoken;
  }

  public loadToken(): Observable<GGizTokenModel>{
    return this.httpClient.get<GGizTokenModel>('/service/ggiz/token').
    pipe(catchError(this.handleError));
  }

  public handleError(error: HttpErrorResponse){
    return throwError(error);
  }

}
