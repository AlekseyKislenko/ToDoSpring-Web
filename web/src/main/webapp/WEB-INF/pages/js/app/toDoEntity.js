function User(login, password) {
    this.login = login;
    this.password = password;

    this.getLogin = function () {
        return this.login;
    };
    this.getPassword = function () {
        return this.password;
    };
}
