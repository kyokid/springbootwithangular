export class User {

    username: string;
    email: string;
    password: string;
    fullname: string;
    address: string;


    constructor(username: string, password: string) {
        this.username = username;
        this.password = password;
    }
}
