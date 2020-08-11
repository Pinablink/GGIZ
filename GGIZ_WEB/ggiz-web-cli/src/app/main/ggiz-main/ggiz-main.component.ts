import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ggiz-ggiz-main',
  templateUrl: './ggiz-main.component.html',
  styleUrls: ['./ggiz-main.component.css']
})
export class GgizMainComponent implements OnInit {

  constructor(private mRoute: Router) { }

  ngOnInit(): void {
    const windowWidth = window.innerWidth;

    if (windowWidth < 992) {
      // Implementar aqui...
    }

  }

 // showPreCad(): void {
   // this.mRoute.navigate(['preCad']);
 // }
}
