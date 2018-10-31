import {Component, EventEmitter, OnInit, Output, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'app-page-student',
  templateUrl: './page-student.component.html',
  styleUrls: ['./page-student.component.css']
})
export class PageStudentComponent implements OnInit {
  modalRef: BsModalRef;
message: string;
constructor(private modalService: BsModalService) {}

openModal(template: TemplateRef<any>) {
  this.modalRef = this.modalService.show(template);
}
decline(): void {
  this.message = 'Declined!';
this.modalRef.hide();
}

ngOnInit(): void {
}
}
