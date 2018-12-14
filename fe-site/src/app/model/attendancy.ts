import {Student} from "./Student";

export class attendancy{
student:Student;
subject_id:string;
hours:number;
public constructor(student:Student,subject_id:string,hours:number){
  this.hours=hours;
  this.student=student;
  this.subject_id=subject_id;
}
}
