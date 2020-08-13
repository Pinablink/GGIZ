import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { ModalModule } from 'ngx-bootstrap/modal';
import { PopoverModule } from 'ngx-bootstrap/popover';
//import { GgizPublicoModule } from './ggiz-publico/ggiz-publico.module';
import { GgizSobreModule } from './publico/ggiz-sobre/ggiz-sobre.module';
import { CadastroComponent } from './cadastro/cadastro.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PrecadastroService } from './../app/service/precadastro.service';
import { GgizPnewsService } from './service/ggiz-pnews.service';
import { GgizInfoModule } from './publico/ggiz-info/ggiz-info.module';
import { GgizNoticiasModule } from './publico/ggiz-noticias/ggiz-noticias.module';


@NgModule({
  declarations: [
    AppComponent,
    CadastroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    GgizSobreModule,
    HttpClientModule,
    FormsModule,
    ModalModule.forRoot(),
    PopoverModule.forRoot(),
    GgizInfoModule,
    GgizNoticiasModule
  ],
  providers: [HttpClientModule, PrecadastroService, GgizPnewsService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
