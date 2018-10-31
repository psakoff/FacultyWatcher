import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageComponent } from './page/page.component';
import { PageAdminComponent} from './page-admin/page-admin.component';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import {BsDropdownModule} from "ngx-bootstrap";
import { ModalModule } from 'ngx-bootstrap/modal';
import {HttpService} from "./services/http.service";
import { PageStudentComponent } from './page-student/page-student.component';
import { PageTeacherComponent } from './page-teacher/page-teacher.component';

@NgModule({
  declarations: [
    AppComponent,
    PageComponent,
    PageAdminComponent,
    PageStudentComponent,
    PageTeacherComponent

  ],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    AppRoutingModule,
    ButtonsModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot()
  ],
  providers: [HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
