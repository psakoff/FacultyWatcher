import {Component, EventEmitter, OnInit, Output, TemplateRef, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {IsLogged} from "../services/Logged";
import {HttpService} from "../services/http.service";


@Component({
  selector: 'app-page-teacher',
  templateUrl: './page-teacher.component.html',
  styleUrls: ['./page-teacher.component.css']
})
export class PageTeacherComponent implements OnInit {

  modalRef: BsModalRef;
  message: string;
  private role: number;
  students: any[];
  teachers: any[];
  lessons: any[];
  constructor(private http: HttpService, private modalService: BsModalService,public isLogged:IsLogged) {
    http.getStudents()
      .subscribe(students => this.students = students);
    http.getTeachers()
      .subscribe(teachers => this.teachers = teachers);
    http.getLessons()
      .subscribe(lessons => this.lessons = lessons);
    this.isLogged.role = isLogged.role;
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  decline(): void {
    this.message = 'Declined!';
    this.modalRef.hide();
  }
  singleModel = '+';

  emitLogout(a) {
    this.isLogged.role = a;
  }
  ngOnInit(): void {
  }
}
