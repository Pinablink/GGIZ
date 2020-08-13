import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GgizTecComponent } from './ggiz-tec.component';

import { GgizInfoRoutingModule } from './ggiz-info-routing.module';

@NgModule({
  declarations: [GgizTecComponent],
  imports: [
    CommonModule,
    GgizInfoRoutingModule
  ]
})
export class GgizInfoModule { }
