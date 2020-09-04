import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BroadnewsService {

  private iniLoadNews: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor() {
  }

  public getEmitter(): EventEmitter<boolean>{
    return this.iniLoadNews;
  }

}
