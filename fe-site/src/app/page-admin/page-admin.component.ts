import {Component, EventEmitter, OnInit, Output, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-page-admin',
  templateUrl: './page-admin.component.html',
  styleUrls: ['./page-admin.component.css']
})
export class PageAdminComponent implements OnInit {

  message: string;
  public students: any[];
  public teachers: any[];
  public lessons: any[];
  public addStudentName: string;
  public addStudentSurname: string;
  public addStudentId: number;
  public addStudentGroup: number;

  public addTeacherName: string;
  public addTeacherSurname: string;
  public addTeacherId: number;
  public addTeacherSpeciality: number;

  public addLessonName: string;
  public addLessonGroup: number;
  public addLessonPlace: number;
  public addLessonTime: number;
  modalRef: BsModalRef;
  constructor(private modalService: BsModalService) {}

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  addStudent(): void {
    const newStudent = {
      id:  this.addStudentId,
      name: this.addStudentName,
      surname: this.addStudentSurname,
      group: this.addStudentGroup,

    }

    this.students.push(newStudent);
    this.modalRef.hide();
  }

  addTeacher(): void {
    const newTeacher = {
      id:  this.addTeacherId,
      name: this.addTeacherName,
      surname: this.addTeacherSurname,
      speciality: this.addTeacherSpeciality,

    }

    this.teachers.push(newTeacher);
    this.modalRef.hide();
  }

  addLesson(): void {
    const newLesson = {
      name:  this.addLessonName,
      groupId: this.addLessonGroup,
      place: this.addLessonPlace,
      time: this.addLessonTime,

    }

    this.lessons.push(newLesson);
    this.modalRef.hide();
  }

  decline(): void {
    this.message = 'Declined!';
    this.modalRef.hide();
  }
  ngOnInit() {
  }

}


