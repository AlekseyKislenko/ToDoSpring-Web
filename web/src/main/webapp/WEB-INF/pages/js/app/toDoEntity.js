function User(username, password, authority, enabled) {
    this.username = username;
    this.password = password;
    this.authority = authority;
    this.enabled = enabled;


    this.getUsername = function () {
        return this.username;
    };
    this.getPassword = function () {
        return this.password;
    };
    this.getAuthority = function () {
        return this.authority;
    };
    this.getEnabled = function() {
        return this.enabled;
    }
}
