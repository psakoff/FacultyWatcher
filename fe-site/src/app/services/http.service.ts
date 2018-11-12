import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable()
export class HttpService {
  constructor(private http: HttpClient) {

  }

  getStudents(): Observable<any> {
    return this.http.get('api/students')
      .pipe(
        catchError(error => {
            alert('error');
          return Observable.throw(error);
        })
      );
  }
  getTeachers(): Observable<any> {
    return this.http.get('api/teachers')
      .pipe(
        catchError(error => {
          alert('error');
          return Observable.throw(error);
        })
      );
  }
  getLessons(): Observable<any> {
    return this.http.get('api/lessons')
      .pipe(
        catchError(error => {
          alert('error');
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
