import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BroadcastReadNewsService {

  private mEventInputNewsEmitter: EventEmitter<string>;


  constructor() {
    this.mEventInputNewsEmitter = new EventEmitter<string>();

  }

  public getEventInputNews(): EventEmitter<string> {
    return this.mEventInputNewsEmitter;
  }

}
