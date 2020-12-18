import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DirConsService {

  private mEventObDirOk: EventEmitter<boolean>;

  constructor() {
    this.mEventObDirOk = new EventEmitter<boolean>();
  }

  public getEventDirOk(): EventEmitter<boolean> {
    return this.mEventObDirOk;
  }
}
