var app = angular.module('blog', []);

app.controller('HomeController', ['$scope', '$http', function ($scope, $http) {


  $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
  var url = 'http://localhost:8080/persoana';

    $scope.modalFct = function(id) {
        $scope.modalID = id;
        $http.get(url + '/' + $scope.modalID). then(function succesCallBack(response) {
            $scope.modalPersoane = response.data;
        });

    };

  $scope.persoane = [];
  $scope.fields = [];
  $scope.persoana = {};


  $scope.person = {};
  $scope.editPerson = {};

  $http.get(url).then(function successCallback(response) {

    $scope.persoane = response.data;
    $scope.fields = Object.keys(response.data[0]);

    console.log($scope.persoane);
    //console.log($scope.fields);

  });


  $scope.addPersoana = function(persoana) {
    persoana.id = parseInt(persoana.id);
    console.log(persoana.id);
    $http({
      method: 'POST',
      url: url,
      data: persoana
    }).then(function successCallback(response) {
      console.log(response);
      $scope.persoane.push(persoana);
      // done.
    }, function errorCallback(response) {
      console.log(response);
    });
  };


  $scope.deletePersoana = function(id) {
    $http({
      method: 'DELETE',
      url: url+'/' + id,
      data: {}
    }).then(function successCallback(response) {
      // aici nu intra niciodata ca e functia de succes
    }, function errorCallback(response) {
      // aici intra pentru ca da eroare
      $scope.persoane = $scope.persoane.filter(function(obj) {
        return obj.id !== id;
      });
    });
  };



  $scope.setUpdatePerson = function(person) {
    $scope.initialID = person.id;
    $scope.editPerson = person;
  };


  $scope.updatePerson = function(editPerson) {
    if (typeof $scope.initialID === 'undefined') {
      $scope.initialID = editPerson.id;
    }
    $http({
          method: 'PUT',
          url: url + '/' + $scope.initialID + '/' + editPerson.id + '/' + editPerson.name,
          data: $scope.editPerson
    }).then(function successCallback(response) {
      $scope.editPerson = {};
      console.log(response);
      // $scope.persoane.push($scope.editPerson);
      // done.
    }, function errorCallback(response) {
      $scope.editPerson = {};
      console.log(response);
    });
  };


}]);

app.controller('ActorController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/actor';

    $scope.modalFct = function(id) {
        $scope.modalID = id;
        $http.get(url + '/' + $scope.modalID). then(function succesCallBack(response) {
            $scope.modalActor = response.data;
        });

    };


    $scope.actori = [];
    $scope.fields = [];
    $scope.actor = {};


    //$scope.person = {};
    $scope.editActor = {};

    $http.get(url).then(function successCallback(response) {

        $scope.actori = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.actori);
        //console.log($scope.fields);

    });


    $scope.addActor = function(actor) {
        actor.id = parseInt(actor.id);
        console.log(actor.id);
        $http({
            method: 'POST',
            url: url,
            data: actor
        }).then(function successCallback(response) {
            console.log(response);
            $scope.actori.push(actor);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteActor = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.actori = $scope.actori.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateActor = function(actor) {
        $scope.initialID = actor.id;
        $scope.editActor = actor;
    };


    $scope.updateActor = function(editActor) {
        if (typeof $scope.initialID === 'undefined') {
            $scope.initialID = editActor.id;
        }
        $http({
            method: 'PUT',
            url: url + '/' + $scope.initialID + '/' + editActor.id + '/' + editActor.name,
            data: $scope.editActor
        }).then(function successCallback(response) {
            $scope.editActor = {};
            console.log(response);
            // $scope.actori.push($scope.editActor);
            // done.
        }, function errorCallback(response) {
            $scope.editActor = {};
            console.log(response);
        });
    };

}]);

app.controller('FilmController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/film';

    $scope.modalFct = function(id) {
        $scope.modalID = id;
        $http.get(url + '/' + $scope.modalID). then(function succesCallBack(response) {
            $scope.modalFilm = response.data;
        });

    };

    $scope.filme = [];
    $scope.fields = [];
    $scope.film = {};


    //$scope.person = {};
    $scope.editFilm = {};

    $http.get(url).then(function successCallback(response) {

        $scope.filme = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.filme);
        //console.log($scope.fields);

    });


    $scope.addFilm = function(film) {
        film.id = parseInt(film.id);
        console.log(film.id);
        $http({
            method: 'POST',
            url: url,
            data: film
        }).then(function successCallback(response) {
            console.log(response);
            $scope.filme.push(film);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteFilm = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.filme = $scope.filme.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateFilm = function(film) {
        $scope.initialID = film.id;
        $scope.editFilm = film;
    };


    $scope.updateFilm = function(editFilm) {
        if (typeof $scope.initialID === 'undefined') {
            $scope.initialID = editFilm.id;
        }
        $http({
            method: 'PUT',
            url: url + '/' + $scope.initialID + '/' + editFilm.id + '/' + editFilm.name + '/' + editFilm.year,
            data: $scope.editFilm
        }).then(function successCallback(response) {
            $scope.editFilm = {};
            console.log(response);
            // $scope.filme.push($scope.editFilm);
            // done.
        }, function errorCallback(response) {
            $scope.editFilm = {};
            console.log(response);
        });
    };

}]);

app.controller('ProdusController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/produs';

    $scope.modalFct = function(id) {
        $scope.modalID = id;
        $http.get(url + '/' + $scope.modalID). then(function succesCallBack(response) {
            $scope.modalProdus = response.data;
        });

    };

    $scope.produse = [];
    $scope.fields = [];
    $scope.produs = {};


    //$scope.person = {};
    $scope.editProdus = {};

    $http.get(url).then(function successCallback(response) {

        $scope.produse = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.produse);
        //console.log($scope.fields);

    });


    $scope.addProdus = function(produs) {
        produs.id = parseInt(produs.id);
        console.log(produs.id);
        $http({
            method: 'POST',
            url: url,
            data: produs
        }).then(function successCallback(response) {
            console.log(response);
            $scope.produse.push(produs);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteProdus = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.produse = $scope.produse.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateProdus = function(produs) {
        $scope.initialID = produs.id;
        $scope.editProdus = produs;
    };


    $scope.updateProdus = function(editProdus) {
        if (typeof $scope.initialID === 'undefined') {
            $scope.initialID = editProdus.id;
        }
        $http({
            method: 'PUT',
            url: url + '/' + $scope.initialID + '/' + editProdus.id + '/' + editProdus.name + '/' + editProdus.price,
            data: $scope.editProdus
        }).then(function successCallback(response) {
            $scope.editProdus = {};
            console.log(response);
            // $scope.produse.push($scope.editProdus);
            // done.
        }, function errorCallback(response) {
            $scope.editProdus = {};
            console.log(response);
        });
    };

}]);