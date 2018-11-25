import {Component, EventEmitter, OnInit, Output, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Import} from "@angular/compiler-cli/src/ngtsc/host";
import {HttpService} from "../services/http.service";
import {IsLogged} from "../services/Logged";
import {student} from "../model/student";


@Component({
  selector: 'app-page-admin',
  templateUrl: './page-admin.component.html',
  styleUrls: ['./page-admin.component.css']
})
export class PageAdminComponent implements OnInit {
  @Output() login = new EventEmitter();
  message: string;
  public editableStudent: student = new student();
  public students: any[];
  public student1: student;
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
  private role: number;
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
  addStudent(): void {
      //
      // this.editableStudent.id= this.addStudentId;
      //   this.editableStudent.name= this.addStudentName;
      // this.editableStudent.surname=this.addStudentSurname;
      // this.editableStudent.group= this.addStudentGroup;
      // this.editableStudent.password= ''+this.addStudentId;

  //  this.editableStudent.id = newStudent.id;
   // this.editableStudent.group = newStudent.group;
   // this.editableStudent.name = newStudent.name;
   // this.editableStudent.surname = newStudent.surname;
  //  this.editableStudent.password = newStudent.id.toString();
  // this.students.push(this.editableStudent);
 this.http.saveStudent(this.editableStudent).subscribe(()=>this.modalRef.hide());
    this.modalRef.hide()
  }

  addTeacher(): void {
    const newTeacher = {
      id:  this.addTeacherId,
      name: this.addTeacherName,
      surname: this.addTeacherSurname,
      speciality: this.addTeacherSpeciality,
      password: this.addTeacherId
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
  emitLogout(a) {
    this.isLogged.role = a;
  }
  ngOnInit() {

  }

}


