import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GgizSobreModule } from './publico/ggiz-sobre/ggiz-sobre.module';
import { CadastroComponent } from './cadastro/cadastro.component';
import { GgizMainComponent } from './main/ggiz-main/ggiz-main.component';
import { GgizInfoModule } from './publico/ggiz-info/ggiz-info.module';
import { GgizNoticiasModule } from './publico/ggiz-noticias/ggiz-noticias.module';


const routes: Routes = [
  {path: '', component: GgizMainComponent},
  {path: 'home', component: GgizMainComponent},
  {path: 'noticias',
    loadChildren: () => import('./publico/ggiz-noticias/ggiz-noticias.module').then(noticias => GgizNoticiasModule)
  },
  {path: 'sobre',
  loadChildren: () => import('./publico/ggiz-sobre/ggiz-sobre-routing.module').then(sobre => GgizSobreModule)
  },
  {
    path: 'info',
    loadChildren: () => import('./publico/ggiz-info/ggiz-info-routing.module').then(info => GgizInfoModule)
  }
  //{path: 'noticia/:id/:titulo', loadChildren: './ggiz-publico/ggiz-publico.module#GGizPublicoRoutingModule'},
  /*{path: '', component: GgizNoticiasComponent},
  {path: 'home', component: GgizNoticiasComponent},
  {path: 'preCad', component: CadastroComponent},
  {path: 'noticia/:id/:titulo', component: GgizNewsLerComponent},
  {path: 'sobre', component: GgizAboutComponent},
  {path: 'info', component: GgizTecComponent }*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
