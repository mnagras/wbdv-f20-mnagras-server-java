(function () {
    var userService = new AdminUserServiceClient();
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;

    let users = [];

    $(main);

    function main() {
        userRowTemplate = $(".wbdv-template");
        tbody = $("tbody");
        userService.findAllUsers()
        .then(_users => {
        users = _users
        renderUsers(users)
        })


        $createBtn = $(".wbdv-create");
        $createBtn.click(createUser);

        $removeBtn = $(".wbdv-remove");
        $removeBtn.click(() => deleteUser2());


        editBtn = $(".wbdv-edit");
        editBtn.click(editBtn);
    }


    function createUser() {
        usernameFld = $("#usernameFld");
        passwordFld = $("#passwordFld");
        firstNameFld = $("#firstNameFld");
        lastNameFld = $("#lastNameFld");
        roleFld = $("#roleFld");

        const username = usernameFld.val();
        const password = passwordFld.val();
        const firstName = firstNameFld.val();
        const lastName = lastNameFld.val();
        const role = roleFld.val();

        const user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        }

        userService
            .createUser(user)
            .then(renderUsers)
    }

     function deleteUser(event) {
        const removeBtn = event.currentTarget
        $removeBtn = $(removeBtn)
        const parent = $removeBtn.parents("tr");
        parent.remove();
     }

     function deleteUser2(index) {
        const user = users[index]
        const userId = user.userId
        console.log(userId)
         //userService.deleteUser(userId)
           // .then(
             //    users.splice(index, 1);
               //  renderUsers(users);
                 //)
     }





     function updateUser(event) {


      }


     function findAllUsers() {

        }


     function findUserById() {
        var userIdFld = $("#userIdFld");

        const userId = userIdFld.val();
     }

    function selectUser() {  }

    function renderUser(user) {

    }

     function renderUsers(users) {
            tbody.empty()
            var i = 0;
            for(var u in users) {
                const user = users[u]
                const rowClone = userRowTemplate.clone();
                rowClone.remove("wbdv-hidden");
                rowClone.find('.wbdv-username').html(user.username);
                rowClone.find('.wbdv-first-name').html(user.firstName);
                rowClone.find('.wbdv-last-name').html(user.lastName);
                rowClone.find('.wbdv-remove').click(() => deleteUser2(i));
                rowClone.find('.wbdv-edit').click(updateUser(i));
                tbody.append(rowClone);
                i++;
            }
        }
})()

