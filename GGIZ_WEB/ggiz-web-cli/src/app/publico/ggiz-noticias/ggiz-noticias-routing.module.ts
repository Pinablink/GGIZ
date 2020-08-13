import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GgizNoticiasComponent } from './ggiz-noticias.component';

const routes: Routes = [
  {path: '', component: GgizNoticiasComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GgizNoticiasRoutingModule { }
