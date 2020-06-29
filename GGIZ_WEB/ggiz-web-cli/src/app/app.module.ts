import { PrecadastroService } from './service/precadastro.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { AvisoComponent } from './aviso/aviso.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ErroComponent } from './erro/erro.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroComponent,
    AvisoComponent,
    ErroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpClientModule, PrecadastroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
