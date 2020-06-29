import { ErroComponent } from './erro/erro.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AvisoComponent} from './aviso/aviso.component';
import {CadastroComponent} from './cadastro/cadastro.component';

const routes: Routes = [
  {path: '', component: CadastroComponent},
  {path: 'aviso', component: AvisoComponent},
  {path: 'erro', component: ErroComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
