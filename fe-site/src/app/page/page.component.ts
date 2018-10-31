import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {
  @Output() login = new EventEmitter();

  page = {
    title: 'Home',
    subtitle: 'Welcome Home!',
    content: 'Some home content.',
    image: 'living_seas_disc.png'
  };

  constructor() { }

  ngOnInit() { }

  emitLogin() {
    this.login.emit()
  }
}
