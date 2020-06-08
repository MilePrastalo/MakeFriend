import { Component, OnInit } from '@angular/core';
import { LoginDTO } from '../model/LoginDTO';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    const username = (document.getElementById('username') as HTMLInputElement).value;
    const password = (document.getElementById('password') as HTMLInputElement).value;
    console.log(username, password);
    const log = new LoginDTO(username, password);
    this.loginService.login(log).subscribe(
      response => {
        localStorage.setItem('username', username);
        localStorage.setItem('password', password);
        this.router.navigateByUrl('');
      },
      error => {
        console.log('error');
      }
    );
  }

}
