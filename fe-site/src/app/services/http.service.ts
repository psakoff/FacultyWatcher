import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Student} from "../model/Student";
import {teacher} from "../model/teacher";
import {lesson} from "../model/lesson";
import {attendancy} from "../model/attendancy";

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  constructor(private http: HttpClient) {

  }
  getAdmin(): Observable<any> {
    return this.http.get('api/admin/')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }
  getStudents(): Observable<any> {
    return this.http.get('api/students/')
      .pipe(
        catchError(error => {
            alert('Не удалось загрузить список студентов');
          return Observable.throw(error);
        })
      );
  }
  getTeachers(): Observable<any> {
    return this.http.get('api/teachers/')
      .pipe(
        catchError(error => {
          alert('Не удалось загрузить список преподавателей');
          return Observable.throw(error);
        })
      );
  }
  getLessons(): Observable<any> {
    return this.http.get('api/lessons/')
      .pipe(
        catchError(error => {
          alert('Не удалось загрузить список занятий');
          return Observable.throw(error);
        })
      );
  }
  saveStudent(student: Student): Observable<Student> {
    return this.http.post<Student>('/api/students/save/student', student)
      .pipe(
        catchError(error => {
          alert('Введены некорректные данные');
          return Observable.throw(error);
        })
      );
  }
  saveTeacher(Teacher: teacher): Observable<teacher> {
    return this.http.post<teacher>('/api/teachers/save', Teacher)
      .pipe(
        catchError(error => {
          alert('Введены некорректные данные');
          return Observable.throw(error);
        })
      );
  }
  saveLesson(Lesson: lesson): Observable<lesson> {
    return this.http.post<lesson>('/api/lessons/save', Lesson)
      .pipe(
        catchError(error => {
          alert('Введены неправильные данные, либо такое занятие уже сущетвует или конфликтует с другими. Проверьте еще раз введенные данные');
          return Observable.throw(error);
        })
      )
  }
  setAttendancy(Attendancy: attendancy): Observable<attendancy> {
    return this.http.post<attendancy>('api/teachers/attendances', Attendancy);
  }
  getStudentById(id: number): Observable<any>{
    return this.http.get<Student>('/api/students/find/student/'+id)
      .pipe(
        catchError(error =>{
          alert('Не удалось загрузить данные о студенте');
            return Observable.throw(error);
        })
      );
  }
  getStudentByGroupId(groupId: number): Observable<any>{
    return this.http.get('/api/students/find/group/'+groupId)
      .pipe(
        catchError(error =>{
          alert('не удалось загрузить эту группу');
          return Observable.throw(error);
        })
      );
  }
  getTeacherById(id: number): Observable<any>{
    return this.http.get<teacher>('/api/teachers/find/'+id)
      .pipe(
        catchError(error =>{
          alert('не удалось загрузить такого преподавателя');
          return Observable.throw(error);
        })
      );
  }
  getLessonsByName(name: string): Observable<any>{
    return this.http.get("api/lessons/find/name/"+name)
      .pipe(
        catchError(error =>{
          alert('can not get lessons by groupId');
          return Observable.throw(error);
        })
      );
  }
  getLessonsByGroup(groupId: number){
    return this.http.get("api/lessons/find/group/"+groupId)
      .pipe(
        catchError(error =>{
          alert('can not get lessons by groupId');
          return Observable.throw(error);
        })
      );
  }
  getAttendancyById(id: number): Observable<any>{
    return this.http.get("api/teachers/find/attendances/"+id)
      .pipe(
        catchError(error =>{
          alert('can not get attendancy by id');
          return Observable.throw(error);
        })
      );
  }
  deleteStudent(id: string): Observable<any> {
    return this.http.get('assets/students.json', {params: {id}})
      // .pipe(
      //   catchError(error => {
      //     alert('error');
      //     return Observable.throw(error);
      //   })
      // );
  }
}
