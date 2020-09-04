import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { BroadnewsService } from './../../../service/broadcast/broadnews.service';
import { NgShowComandDirective } from './../../../shared/ng-show-comand.directive';

@Component({
  selector: 'ggiz-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public viewCommand: boolean;
  public viewProc: boolean;

  constructor(private route: Router, private broadcastService: BroadnewsService) { }

  ngOnInit(): void {

    this.viewCommand = false;
    this.viewProc = true;

    this.broadcastService.getEmitter().subscribe((flag: boolean) =>
     {
        this.viewCommand = (!flag);
        this.viewProc = flag;
     }
    );

  }

  public showInfo(): void {
    this.route.navigate(['info']);
  }

}
