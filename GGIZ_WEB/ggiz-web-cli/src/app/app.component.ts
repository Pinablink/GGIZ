import { Router } from '@angular/router';
import { Component, EventEmitter, OnInit } from '@angular/core';
import { BroadnewsService } from './service/broadcast/broadnews.service';

@Component({
  selector: 'ggiz-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit {


  public processamento: boolean;
  public screenOk: boolean;

  constructor(private router: Router, private broadcast: BroadnewsService){}

  ngOnInit(): void {
    this.verScreen();
  }

  public verScreen(): void {

    const sw = (screen.width < 1366);
    const sh = (screen.height < 768);

    this.screenOk = true;

    if (sw || sh) {
      this.screenOk = false;
    } else {
        this.router.navigate(['/home']);
        this.processamento = true;
        this.broadcast.getEmitter().subscribe((flag: boolean) => {
        this.processamento = flag;
      });
    }

  }
}