import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GgizAboutComponent } from './ggiz-about.component';


const routes: Routes = [
  {path: '', component: GgizAboutComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class GGizSobreRoutingModule { }
