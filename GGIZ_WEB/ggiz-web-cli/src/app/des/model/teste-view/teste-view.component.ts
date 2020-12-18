import { Component, OnInit, ViewChild, TemplateRef, ViewContainerRef, ComponentFactoryResolver } from '@angular/core';
import { RbarIComponent } from './../../../component/ggiz/rbar-i/rbar-i.component';
//APENAS PARA TESTES. PODE SER SUBSTITUIDO SEM QUE OCORRA MAU FUNCIONAMENTO DO SISTEMA
import { GICompDirective } from './../../../shared/g-icomp.directive';
import { NgShowReadNewsDirective } from './../../../shared/ng-show-read-news.directive';
import { BroadcastReadNewsService  } from './../../../service/broadcast/broadcast-read-news.service';


@Component({
  selector: 'ggiz-teste-view',
  templateUrl: './teste-view.component.html',
  styleUrls: ['./teste-view.component.css']
})
export class TesteViewComponent implements OnInit {

    @ViewChild(GICompDirective, {static: true}) ggizGIComp: GICompDirective;

   //APENAS PARA TESTES. PODE SER SUBSTITUIDO SEM QUE OCORRA MAU FUNCIONAMENTO DO SISTEMA
   constructor(private broadNewService: BroadcastReadNewsService,
    private factory: ComponentFactoryResolver) { }

   ngOnInit(): void {

     // const fac = this.factory.resolveComponentFactory(RbarIComponent);
     // const containerView = this.ggizGIComp.vContainerRef;
     // containerView.clear();

     // containerView.createComponent<RbarIComponent>(fac);
    // const refContainer = this.rbar.
   }

}
