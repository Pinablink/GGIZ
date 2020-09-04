import { Directive, ElementRef, Renderer2 } from '@angular/core';
import { BroadnewsService } from './../service/broadcast/broadnews.service';

@Directive({
  selector: '[ggizNgShowComand]'
})
export class NgShowComandDirective {

  constructor(private elementref: ElementRef, private renderer: Renderer2, private broadcast: BroadnewsService) {

      this.broadcast.getEmitter().subscribe( (flag: boolean) =>
      {
          if (flag) {
            this.renderer.addClass(this.elementref.nativeElement, 'disabled');
          } else {
            this.renderer.removeClass(this.elementref.nativeElement, 'disabled');
          }
      });

   }

}
