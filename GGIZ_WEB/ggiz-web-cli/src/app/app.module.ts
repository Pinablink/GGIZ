import { PrecadastroService } from './service/precadastro.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ModalModule } from 'ngx-bootstrap/modal';
import { PopoverModule } from 'ngx-bootstrap/popover';
import { GgizMainComponent } from './main/ggiz-main/ggiz-main.component';
import { GgizAboutComponent } from './sobre/ggiz-about/ggiz-about.component';
import { GgizNoticiasComponent } from './home/ggiz-noticias/ggiz-noticias.component';
import { GgizTecComponent } from './info/ggiz-tec/ggiz-tec.component';
import { GgizNewsLerComponent } from './noticia/ggiz-news-ler/ggiz-news-ler.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroComponent,
    GgizMainComponent,
    GgizAboutComponent,
    GgizNoticiasComponent,
    GgizTecComponent,
    GgizNewsLerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ModalModule.forRoot(),
    PopoverModule.forRoot()
  ],
  providers: [HttpClientModule, PrecadastroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
