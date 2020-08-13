import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GgizTecComponent } from './ggiz-tec.component';

const routes: Routes = [
  {path: '', component: GgizTecComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GgizInfoRoutingModule { }
