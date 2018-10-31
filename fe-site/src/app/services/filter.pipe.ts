import {Pipe, PipeTransform} from '@angular/core';

@Pipe({name: 'filter'})
export class FilterPipe implements PipeTransform {
  transform(students: any[], filterQuery: string): any[] {
    return students
      .filter(student => student.name !== filterQuery);
  }
}
