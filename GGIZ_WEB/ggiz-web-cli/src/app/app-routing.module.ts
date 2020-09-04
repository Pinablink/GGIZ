import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CadastroComponent } from './view/ggiz/cadastro/cadastro.component';
import { NoticiaComponent } from './view/ggiz/news/noticia/noticia.component';
import { NoticiaLerComponent } from './view/ggiz/news/noticia-ler/noticia-ler.component';
import { InfoTecComponent } from './view/ggiz/info/info-tec/info-tec.component';
import { AboutComponent } from './view/ggiz/info/about/about.component';

const routes: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: NoticiaComponent},
  {path: 'precad', component: CadastroComponent},
  {path: 'noticia/:id/:titulo', component: NoticiaLerComponent},
  {path: 'info', component: InfoTecComponent},
  {path: 'about', component: AboutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
