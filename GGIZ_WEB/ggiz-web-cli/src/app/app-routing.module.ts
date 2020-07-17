import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CadastroComponent } from './cadastro/cadastro.component';
import { GgizNoticiasComponent } from './home/ggiz-noticias/ggiz-noticias.component';
import { GgizAboutComponent } from './sobre/ggiz-about/ggiz-about.component';
import { GgizTecComponent } from './info/ggiz-tec/ggiz-tec.component';
import { GgizNewsLerComponent } from './noticia/ggiz-news-ler/ggiz-news-ler.component';

const routes: Routes = [
  {path: '', component: GgizNoticiasComponent},
  {path: 'home', component: GgizNoticiasComponent},
  {path: 'preCad', component: CadastroComponent},
  {path: 'noticia/:id/:titulo', component: GgizNewsLerComponent},
  {path: 'sobre', component: GgizAboutComponent},
  {path: 'info', component: GgizTecComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
