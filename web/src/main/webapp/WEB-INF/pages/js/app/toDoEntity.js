function User(id, username, password, authority, enabled) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.authority = authority;
    this.enabled = enabled;

    this.getId = function () {
        return this.id;
    };

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
