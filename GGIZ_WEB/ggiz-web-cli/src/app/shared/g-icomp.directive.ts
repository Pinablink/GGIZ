import { Directive, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[ggizGIComp]'
})
export class GICompDirective {

  constructor(public vContainerRef: ViewContainerRef) { }

}
