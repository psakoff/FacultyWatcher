import {Component, EventEmitter, OnInit, Output, TemplateRef, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService, TabsetComponent, TabsModule} from "ngx-bootstrap";
import {Import} from "@angular/compiler-cli/src/ngtsc/host";
import {HttpService} from "../services/http.service";
import {IsLogged} from "../services/Logged";
import {Student} from "../model/Student";
import {Observable, of} from "rxjs";
import {teacher} from "../model/teacher";
import {lesson} from "../model/lesson";
import {admin} from "../model/admin";
import {and} from "@angular/router/src/utils/collection";
import {attendancy} from "../model/attendancy";
import {catchError} from "rxjs/operators";


@Component({
  selector: 'app-page-admin',
  templateUrl: './page-admin.component.html',
  styleUrls: ['./page-admin.component.css']
})
export class PageAdminComponent implements OnInit {
  @Output() login = new EventEmitter();
  message: string;
  public editableStudent: Student = new Student();
  public editableTeacher: teacher = new teacher();
  public editableLesson: lesson = new lesson();
  public editableAttendancy: attendancy;
  public observableId: any;
  public observableSpeciality :string;
  public students: any[];
  public teachers: any[];
  public lessons: any[];
  public hours: number = 2;
  public lessonsByName: any[];
  public TeachersTable: any[];
  public studentsByGroup:any[];
  public observableAttendances:attendancy[];
  public lessonsByGroup:any;
  attendances: attendancy[];
  public observableStudent:Student;
  public observableTeacher:teacher;
  public attendancyById: attendancy[];
  modalRef: BsModalRef;
  private role: number;
  private currentStudent: Student;
    private currentTeacher: teacher;
    private currentName:string;
    private currentSurname: string;
  public oldPass: string;
  public newPass:string;
  public newPass2: string;

  constructor(private http: HttpService, private modalService: BsModalService,public isLogged:IsLogged) {
    http.getStudents()
      .subscribe(students => this.students = students);
    http.getTeachers()
      .subscribe(teachers => this.teachers = teachers);
    http.getLessons()
      .subscribe(lessons => this.lessons = lessons);
    this.isLogged.role = isLogged.role;
    this.isLogged.currId = isLogged.currId;
    this.currentName=isLogged.currentName;
    this.currentSurname=isLogged.currentSurname;
  //   if(this.isLogged.currId<100){
  //     http.getTeacherById(this.isLogged.currId)
  //       .subscribe(currentTeacher =>{
  //         this.currentTeacher = currentTeacher;
  //         this.currentName=this.currentTeacher.name;
  //         this.currentSurname = this.currentTeacher.surname
  //         }
  //       )
  //   }
  //   else { http.getStudentById(this.isLogged.currId)
  //     .subscribe(currentStudent =>{
  //         this.currentStudent = currentStudent;
  //         this.currentName=this.currentStudent.name;
  //         this.currentSurname = this.currentStudent.surname
  //       }
  //     )}
   }
  @ViewChild('staticTabs') staticTabs: TabsetComponent;

  selectTab(tabId: number) {
    this.staticTabs.tabs[tabId].active = true;
  }
  GetLessonTime(time: number): string{
    switch (time) { case 1:{return "8:00-9:35";break}
      case 6:{return " 8:00 - 9:35 ";break}
      case 11:{return " 8:00 - 9:35 ";break}
      case 16:{return " 8:00 - 9:35 ";break}
      case 21:{return " 8:00 - 9:35 ";break}
      case 26:{return " 8:00 - 9:35 ";break}
      case 2:{return "9:45 - 11:20";break}
      case 7:{return "9:45 - 11:20";break}
      case 12:{return "9:45 - 11:20";break}
      case 17:{return "9:45 - 11:20";break}
      case 22:{return "9:45 - 11:20";break}
      case 27:{return "9:45 - 11:20";break}
      case 3:{return "11:40 - 13:15";break}
      case 8:{return "11:40 - 13:15";break}
      case 13:{return "11:40 - 13:15";break}
      case 18:{return "11:40 - 13:15";break}
      case 23:{return "11:40 - 13:15";break}
      case 28:{return "11:40 - 13:15";break}
      case 4:{return "13:25 - 15:00";break}
      case 9:{return "13:25 - 15:00";break}
      case 14:{return "13:25 - 15:00";break}
      case 19:{return "13:25 - 15:00";break}
      case 24:{return "13:25 - 15:00";break}
      case 29:{return "13:25 - 15:00";break}
      case 5:{return "15:50 - 16:55";break}
      case 10:{return "15:50 - 16:55";break}
      case 15:{return "15:50 - 16:55";break}
      case 20:{return "15:50 - 16:55";break}
      case 25:{return "15:50 - 16:55";break}
      case 30:{return "15:50 - 16:55";break}
      default: {break;}
    }
  }
  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }
  addStudent(): void {
 this.http.saveStudent(this.editableStudent).subscribe(()=>{this.modalRef.hide();this.refreshStudent();this.http.getStudents()
   .subscribe(students => this.students = students);});
    this.modalRef.hide()
  }
  private refreshStudent(): void {
    this.editableStudent = new Student();
  }
  private refreshTeacher(): void {
    this.editableTeacher = new teacher();
  }
  private refreshLesson(): void {
    this.editableLesson = new lesson();
  }
  private refreshData(): void {
   this.lessonsByName= [];
    this.TeachersTable= [];
    this.studentsByGroup= [];
    this.lessonsByGroup= [];
    this.observableStudent = new Student();
    this.observableTeacher = new teacher();
    this.attendancyById = [];
    this.observableId = null;
  }
  private refreshAttendancy(): void {
    this.editableAttendancy = null;
  }
  addTeacher(): void {
    this.http.saveTeacher(this.editableTeacher).subscribe(()=>{this.modalRef.hide();this.refreshTeacher();this.http.getTeachers()
      .subscribe(teachers => this.teachers = teachers);});
    this.modalRef.hide();
  }
  saveAttendancyData(id:Student, name:string){
    this.editableAttendancy = new attendancy(id,name,this.hours);
    this.observableStudent = id;
  }
  setAttendancy(currentAttendancy: attendancy): void {
    this.http.setAttendancy(currentAttendancy).subscribe(()=>{this.refreshAttendancy();this.getAttendancyById(currentAttendancy.student.id)});
  }

  getLessonsBySpeciality(name: string):void{
  this.http.getLessonsByName(name)
    .subscribe(lessonsByName => this.lessonsByName = lessonsByName);
}
  getLessonsByGroupId(groupId: number):void{
    this.http.getLessonsByGroup(groupId)
      .subscribe(lessonsByGroup => this.lessonsByGroup = lessonsByGroup);
    this.observableId = null;
  }
  getAttendancyById(id : number):void{
    this.http.getAttendancyById(id)
      .subscribe(observableAttendances => this.observableAttendances = observableAttendances);
  }
  getStudentsByGroupId(groupId: number):void{
    this.http.getStudentByGroupId(groupId)
      .subscribe(studentsByGroup => this.studentsByGroup = studentsByGroup);
  }
  public byMonday(element: lesson,index,array){
  return(element.time <= 5*1 && element.time>5*(1-1))
  }
  public byTuesday(element: lesson,index,array){
    return(element.time <= 5*2 && element.time>5*(2-1))
  }
  public byWednesday(element: lesson,index,array){
    return(element.time <= 5*3 && element.time>5*(3-1))
  }
  public byThursday(element: lesson,index,array){
    return(element.time <= 5*4 && element.time>5*(4-1))
  }
  public byFriday(element: lesson,index,array){
    return(element.time <= 5*5 && element.time>5*(5-1))
  }
  public bySaturday(element: lesson,index,array){
    return(element.time <= 5*6 && element.time>5*(6-1))
  }
  getTeachersTable():void{
    this.http.getTeacherById(this.observableId)
      .subscribe(teacher =>
        {this.observableTeacher = teacher;
          this.http.getLessonsByName(this.observableTeacher.speciality)
        .subscribe(lessonsByName => this.lessonsByName = lessonsByName);});
  }
  addLesson(): void {
    this.http.saveLesson(this.editableLesson).subscribe(()=>{this.modalRef.hide();this.refreshLesson(); this.http.getLessons()
      .subscribe(lessons => this.lessons = lessons);});
    this.modalRef.hide();
  }
  LookForStudent():void{
    this.http.getStudentById(this.observableId)
      .subscribe(student => {this.observableStudent = student;
        this.getAttendancyById(this.observableId)
      });
  }
  checkAccount():void{
    if (this.isLogged.currId <100){
      this.http.getTeacherById(this.isLogged.currId).subscribe(
        teacher =>{this.observableTeacher = teacher;
          if(this.oldPass.match(this.observableTeacher.password)){
            if(this.newPass.match(this.newPass2)){
              this.observableTeacher.password = this.newPass;
              this.http.saveTeacher(this.observableTeacher).subscribe(() =>{this.modalRef.hide();
                this.refreshTeacher();
              })


            }
          }
        }
      )
    }else if (this.isLogged.currId >=100){
      this.http.getStudentById(this.isLogged.currId).subscribe(
        teacher =>{this.observableStudent = teacher;
          if(this.oldPass.match(this.observableStudent.password)){
            if(this.newPass.match(this.newPass2)){
              this.observableStudent.password = this.newPass;
              this.http.saveStudent(this.observableStudent).subscribe(() =>{this.modalRef.hide();
                this.refreshTeacher();
              })
            }
          }
        }
      )
    }
    else alert('Неверный пароль')
  }
  changePassword():void{
    this.checkAccount()
  }

  decline(): void {
    this.message = 'Declined!';
    this.modalRef.hide();
  }
  emitLogout(a) {
    this.isLogged.role = a;
    this.isLogged.currId=undefined;
    this.isLogged.currName=undefined;
    this.isLogged.currentName = undefined;
    this.isLogged.currentSurname = undefined;
    this.refreshData();
  }
  ngOnInit() {

  }

}


