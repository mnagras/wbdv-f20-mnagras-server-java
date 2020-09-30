function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/mnagras/users';
    var self = this;
    var localURL = "http://localhost:8080/users";

    function createUser(user) {
        return fetch(this.url, {
            method: "POST",
            body: JSON.stringify(user),
            headers: {
                "content-type": "application/json"
            }
        }).then(function(response){
            return response.json()
        })
    }

    function findAllUsers() {
        return fetch(this.url)
                .then(function(response){
                    return response.json()
            })
    }

    function deleteUser(userId) {
        return fetch(this.url + "/" + userId, {
            method: "DELETE"})
            .then(function(response){
                return response.json()
            })
    }

    function findUserById(userId) {  }
    function updateUser(userId, user) {  }
}
