import { AfterViewInit, Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { NgShowReadNewsDirective } from './../../../../../shared/ng-show-read-news.directive';

@Component({
  selector: 'ggiz-news-input',
  templateUrl: './news-input.component.html',
  styleUrls: ['./news-input.component.css']
})
export class NewsInputComponent implements OnInit, AfterViewInit {


  @ViewChild(NgShowReadNewsDirective) ggizNews: NgShowReadNewsDirective;
  @Input() iNews: string;

  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void {
    this.ggizNews.showNews(this.iNews);
  }

}
