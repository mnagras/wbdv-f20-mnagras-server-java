(function () {
    var userService = new AdminUserServiceClient();
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn, $updateBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;

    let users = [];
    let selectedUserIndex = -1;

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

        $updateBtn = $(".wbdv-update");
        $updateBtn.click(updateUser);

       // $removeBtn = $(".wbdv-remove");
        //$removeBtn.click(() => deleteUser2());


        //editBtn = $(".wbdv-edit");
        //editBtn.click(editBtn);
    }

    function createUser() {
        usernameFld = $("#usernameFld");
        passwordFld = $("#passwordFld");
        firstNameFld = $("#firstNameFld");
        lastNameFld = $("#lastNameFld");
        roleFld = $("#roleFld");
        //alert ($('#roleFld :selected').text());

        const username = usernameFld.val();
        const password = passwordFld.val();
        const firstName = firstNameFld.val();
        const lastName = lastNameFld.val();
        const role = $('#roleFld :selected').text();
        //console.log(role);

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
         userService.deleteUser(userId)
            .then(status => {
                users.splice(index, 1);
                renderUsers(users);}
               )
     }


     function updateUser() {
        if (selectedUserIndex == -1) {
            alert("No user selected");
            return;
        }
        const oldUser = users[selectedUserIndex]
        const userId = oldUser.userId;

        usernameFld = $("#usernameFld");
        passwordFld = $("#passwordFld");
        firstNameFld = $("#firstNameFld");
        lastNameFld = $("#lastNameFld");
        roleFld = $("#roleFld");

        const username = usernameFld.val();
        const password = passwordFld.val();
        const firstName = firstNameFld.val();
        const lastName = lastNameFld.val();
        const role = $('#roleFld :selected').text();

        const user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role
        }

        userService.updateUser(userId, user)
        .then(status => {
            users[selectedUserIndex] = user;
            renderUsers(users);
            selectedUserIndex = -1;
            }
        )
      }


     function findAllUsers() {

        }


     function findUserById() {
        var userIdFld = $("#userIdFld");

        const userId = userIdFld.val();
     }

    function selectUser(index) {
        selectedUserIndex = index;
        const user = users[index]

        const userId = user.userId
        usernameFld = $("#usernameFld");
        usernameFld.val(user.username);
        $("#passwordFld").val(user.password).change();
        $("#firstNameFld").val(user.firstName);
        $("#lastNameFld").val(user.lastName);
        //$("#roleFld").val(user.role);
        $("#roleFld select").val(user.role);
    }

    function renderUser(user) {

    }

     function renderUsers(users) {
            tbody.empty()

            for(let i = 0; i < users.length; i++) {
                const user = users[i]
                const rowClone = userRowTemplate.clone();
                rowClone.remove("wbdv-hidden");
                rowClone.find('.wbdv-username').html(user.username);
                rowClone.find('.wbdv-first-name').html(user.firstName);
                rowClone.find('.wbdv-last-name').html(user.lastName);
                rowClone.find('.wbdv-role').html(user.role);
                const $removeBtn = rowClone.find('.wbdv-remove');
                $removeBtn.click(() => deleteUser2(i));
                const $editBtn = rowClone.find('.wbdv-edit');
                $editBtn.click(() => selectUser(i));
                tbody.append(rowClone);

            }
        }
})()

