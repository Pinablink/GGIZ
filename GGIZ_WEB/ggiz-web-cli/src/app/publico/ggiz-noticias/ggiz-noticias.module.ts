
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GgizNoticiasComponent } from './ggiz-noticias.component';
import { GgizNoticiasRoutingModule } from './ggiz-noticias-routing.module';

@NgModule({
  declarations: [GgizNoticiasComponent],
  imports: [
    CommonModule,
    GgizNoticiasRoutingModule
  ]
})
export class GgizNoticiasModule { }
