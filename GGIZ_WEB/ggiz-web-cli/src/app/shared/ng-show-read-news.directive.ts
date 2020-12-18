import { Directive, Renderer2, ElementRef, OnInit } from '@angular/core';

@Directive({
  selector: '[ggizNgShowReadNews]'
})
export class NgShowReadNewsDirective {

  constructor(private mRender: Renderer2,
              private mElementRef: ElementRef) {
  }

  showNews(strContent: string): void {
     this.mRender.setProperty(this.mElementRef.nativeElement, 'innerHTML', strContent );
  }


}
