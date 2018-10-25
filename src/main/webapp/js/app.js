'use strict';
var app = angular.module("UserManagement", []);

//Controller Part
app.controller("UserController", function ($scope, $http) {


    $scope.users = [];
    $scope.userForm = {
        id: -1,
        firstName: "",
        lastName: "",
        email: "",
        birthDate: ""
    };

    //Loading the data from server and database
    _refreshUserData();

    //HTTP POST/PUT methods for add/edit user
    // the id let us to figure out if it is put/post operation

    $scope.submitUser = function () {

        var method = "";
        var url = "";
        if ($scope.userForm.id == -1) {
            //if there is not Id data form, it is create new user operation
            method = "POST";
            url = '/addUser';
        } else {
            //if there is not Id data form, it is edit user operation
            method = "PUT";
            url = '/addUser';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.userForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    //HTTP REST DELETE- delete user by Id
    $scope.deleteUser = function (user) {
        $http({
            method: 'DELETE',
            url: '/deleteUser/' + user.id
        }).then(_success, _error);
    };

    // To edit, populate the fields of the form fields and assign form.id with user id
    $scope.editUser = function (user) {

        $scope.userForm.firstName = user.firstName;
        $scope.userForm.lastName = user.lastName;
        $scope.userForm.email = user.email;
        $scope.userForm.birthDate = user.birthDate;
        $scope.userForm.id = user.id;
    };

    // Dummy data for local testing
    $scope.dataUsuarios = {
        usuario: [{
            firstName: 'John',
            lastName: 'Doe',
            email: 'elmio@aasi.com',
            birthDate: 20181024
        }, {
            firstName: 'Juan',
            lastName: 'Nadie',
            email: 'juannadie@ooo.com',
            birthDate: 20000501
        }, {
            firstName: 'Pedro',
            lastName: 'Capusoto',
            email: 'pedro@aasi.com',
            birthDate: 19891110
        }, {
            firstName: 'Luis',
            lastName: 'Sanz',
            email: 'luiso@aasi.com',
            birthDate: 20211024
        }, {
            firstName: 'Eva',
            lastName: 'Sefue',
            email: 'evasefue.com',
            birthDate: 19690720
        }, {
            firstName: 'Ana',
            lastName: 'Nada',
            email: 'ananada@aasi.com',
            birthDate: 19001131
        }, {
            firstName: 'Noe',
            lastName: 'Elm',
            email: 'noeelm@aasi.com',
            birthDate: 18990527
        }

        ]
    };

    // Function to order the data table of users
    $scope.orderByField = 'firstName';
    $scope.reverseSort = false;

    $scope.userOrder = function (fieldOrder) {
        $scope.orderByField = fieldOrder;
        $scope.reverseSort = !($scope.reverseSort);
        console.log($scope.reverseSort);

    }

    /* Private Methods */

    //HTTP GET- get all users collection

    function _refreshUserData() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/getAllUsers'
        }).then(function successCallback(response) {
            $scope.users = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    function _success(response) {
        _refreshUserData();
        _clearFormData()
    }

    function _error(response) {
        console.log(response.statusText);
    }

    //Clear the form
    function _clearFormData() {
        $scope.userForm.id = -1;
        $scope.userForm.firstName = "";
        $scope.userForm.lastName = "";
        $scope.userForm.email = "";
        $scope.userForm.birthDate = "";

    };
});