import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CadastroComponent} from './cadastro/cadastro.component';

const routes: Routes = [
  {path: '', component: CadastroComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
