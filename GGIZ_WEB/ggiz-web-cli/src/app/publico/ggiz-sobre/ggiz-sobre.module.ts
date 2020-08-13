import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GgizAboutComponent } from './ggiz-about.component';
import { GGizSobreRoutingModule } from './ggiz-sobre-routing.module';


@NgModule({
  declarations: [GgizAboutComponent],
  imports: [
    CommonModule,
    GGizSobreRoutingModule
  ]
})
export class GgizSobreModule { }
