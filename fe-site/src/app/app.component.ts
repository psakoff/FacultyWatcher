import {Component, OnInit, ViewChild} from '@angular/core';
import {IsLogged} from "./services/Logged";
import {HttpService} from "./services/http.service";
import {BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  private role: number = 0;
  students: any[];
  teachers: any[];
  lessons: any[];
  @ViewChild('studentsTemplate') readonly studentsTemplate;
  constructor(private http: HttpService, private modalService: BsModalService,public isLogged:IsLogged) {
    http.getStudents()
      .subscribe(students => this.students = students);
    http.getTeachers()
      .subscribe(teachers => this.teachers = teachers);
    http.getLessons()
      .subscribe(lessons => this.lessons = lessons);
    this.isLogged.role = isLogged.role;
  }
    ngOnInit() {

  }
}
