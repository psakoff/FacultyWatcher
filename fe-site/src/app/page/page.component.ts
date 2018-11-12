import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {IsLogged} from "../services/Logged";


@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css'],

})
export class PageComponent implements OnInit {
  private role: number;
  @Output() login = new EventEmitter();
  page = {
    title: 'Home',
    subtitle: 'Welcome Home!',
    content: 'Some home content.',
    image: 'living_seas_disc.png'
  };

  constructor(public isLogged: IsLogged) {
    this.isLogged.role = 0;
    this.role = isLogged.role;
  }

  ngOnInit() { }

  emitLogin(a) {
    this.isLogged.role = a;
  }
}
