import {Component, EventEmitter, OnInit, Output, TemplateRef} from '@angular/core';
import {BsModalRef, BsModalService} from "ngx-bootstrap";


@Component({
  selector: 'app-page-teacher',
  templateUrl: './page-teacher.component.html',
  styleUrls: ['./page-teacher.component.css']
})
export class PageTeacherComponent implements OnInit {

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
  singleModel = '1';


  ngOnInit(): void {
  }
}
