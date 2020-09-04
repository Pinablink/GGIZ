import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ModalModule } from 'ngx-bootstrap/modal';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TooltipModule } from 'ngx-bootstrap/tooltip';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/ggiz/header/header.component';
import { InfoTecComponent } from './view/ggiz/info/info-tec/info-tec.component';
import { AboutComponent } from './view/ggiz/info/about/about.component';
import { NoticiaComponent } from './view/ggiz/news/noticia/noticia.component';
import { NoticiaLerComponent } from './view/ggiz/news/noticia-ler/noticia-ler.component';
import { CadastroComponent } from './view/ggiz/cadastro/cadastro.component';


import { TokenService } from './service/ggiz/token.service';
import { ComandoComponent } from './component/ggiz/header/comando/comando.component';
import { NgShowComandDirective } from './shared/ng-show-comand.directive';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    InfoTecComponent,
    AboutComponent,
    NoticiaComponent,
    NoticiaLerComponent,
    CadastroComponent,
    ComandoComponent,
    NgShowComandDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ModalModule.forRoot(),
    TooltipModule.forRoot(),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
