function AdminUserServiceClient() {
    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.findUserById = findUserById;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/mnagras/users';
    var self = this;

    function createUser(user) {
        return fetch("http://localhost:8080/users", {
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
        return fetch('http://localhost:8080/users')
                .then(function(response){
                    return response.json()
            })
    }

    function deleteUser(userId) {
        return fetch('http://localhost:8080/users' + "/" + userId, {
            method: "DELETE"})
            .then(function(response){
                return response.json()
            })
    }

    function findUserById(userId) {  }
    function updateUser(userId, user) {  }
}
