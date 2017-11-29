import {Component, OnInit} from '@angular/core';
import {LoginService} from "./login.service";
import {User} from "../model/user";
import {Location} from "@angular/common";
import {Router} from "@angular/router";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    constructor(
        private loginService: LoginService,
        private location: Location,
        private router: Router) {
    }

    private error = '';
    private loading = false;


    ngOnInit() {
    }

    login(username: string, password: string): void {
        this.loading = true;
        username = username.trim()
        password = password.trim()

        if (!username || !password) {
            this.error = '';
            this.loading = false;
            return
        }

        const user: User = new User(username, password)
        this.loginService.login(user).subscribe(
            (value) =>  {
                value == "Successful"  ? this.router.navigateByUrl("/") : this.error = value

            }
        )



    }


}
