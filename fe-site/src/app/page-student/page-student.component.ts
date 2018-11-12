import {Component, EventEmitter, OnInit, Output, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {IsLogged} from "../services/Logged";

@Component({
  selector: 'app-page-student',
  templateUrl: './page-student.component.html',
  styleUrls: ['./page-student.component.css']
})
export class PageStudentComponent implements OnInit {
  modalRef: BsModalRef;
message: string;
  private role: number;
constructor(private modalService: BsModalService,public isLogged: IsLogged) {
    this.role = isLogged.role;
  }
openModal(template: TemplateRef<any>) {
  this.modalRef = this.modalService.show(template);
}
decline(): void {
  this.message = 'Declined!';
this.modalRef.hide();
}
  emitLogout(a) {
    this.isLogged.role = a;
  }
ngOnInit(): void {
}
}
