var app = angular.module('blog', []);

app.controller('HomeController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
  

    $scope.persons = [];
    $scope.fields = []; 
	$scope.products = [];
	$scope.animals = [];
	
    $scope.persoana = {};
  

    $scope.person = {};
	$scope.product = [];
	$scope.animal = {};
	
    $scope.editPerson = {};
    $scope.editProduct = {};
    $scope.editPerson = {};

 

 //get persoana
    $http.get('http://localhost:8080/person').then(
    function successCallback(response) {

    $scope.persons = response;
    $scope.keys = Object.keys(response.data[0]);
  });
  
  
 //delete persoana
   $scope.deletePerson = function(id) {
    $http.delete('http://localhost:8080/person' + id)
    .then(
      function successCallback(response) {
        /* code goes here */
		console.log("Am sters");
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };
  
  
    $scope.addPerson = function(person) {
    $scope.persons.data.push(person);
	var url ="http://localhost:8080/person";
	$http.post(url+"?"+"&id="+person.id+"&name="+person.name);
    $scope.person = {};
  };
  
  
  
  
  
  //get product
	$http.get('http://localhost:8080/product').then(
		function successCallback(response) {
		$scope.products = response;
		$scope.keys = Object.keys(response.data[0]);
    });
	
	//delete product
   $scope.deleteProduct = function(id) {
    $http.delete('http://localhost:8080/product' + id)
    .then(
      function successCallback(response) {
		console.log("Am sters produsul");
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
  };
  
	//add produs
    $scope.addProduct = function(product) {
    $scope.products.data.push(product);
	var url ="http://localhost:8080/product";
	$http.post(url+"?"+"id="+product.id+"&quantity="+product.quantity+"&name"+product.name);
 
    $scope.product = {};
  };
	
	 //get animal
	$http.get('http://localhost:8080/animal').then(
		function successCallback(response) {
		$scope.animals = response;
		$scope.keys = Object.keys(response.data[0]);
	});
	
	  //delete animal
    $scope.deleteAnimal = function(id) {
    $http.delete('http://localhost:8080/animal' + id)
    .then(
      function successCallback(response) {
		console.log("Am sters animalul");
      },
      function errorCallback(response) {
        angular.element('[data-id=' + id + ']').remove();
    });
	};
  
	
	 $scope.addAnimal = function(animal) {
    $scope.animals.data.push(animal);
	var url ="http://localhost:8080/animal";
	$http.post(url+"?"+"id="+animal.id+"&age="+animal.age+"&name"+animal.name);
 
    $scope.animal = {};
  };
	
	
	
//update persoana
  $scope.setUpdatePerson = function(person) {
    $scope.editPerson = person;
  };

  $scope.updatePerson = function() {
	event.preventDefault();
    $http.put('http://localhost:8080/person', $scope.editPerson);
    $scope.editPerson = {};
  };
	
	//update produs
	$scope.setUpdateProduct = function(product) {
        $scope.editProduct = product;
    };

    var url3 ="http://localhost:8080/product";
    $scope.updateProduct= function() {
		event.preventDefault();
        $http({
            method: 'PUT',
            url: url3,
            data: $scope.editProduct
        }).then(function successCallback(response) {
            $scope.editProduct = {};
            console.log(response);
     
        }, function errorCallback(response) {
            $scope.editProduct = {};
            console.log(response);
        });
    };
	
	//update animal
	$scope.setUpdateAnimal = function(animal) {
    $scope.editAnimal = animal;
	};

  $scope.updateAnimal = function() {
	event.preventDefault();
    $http.put('http://localhost:8080/animal', $scope.editAnimal);
    $scope.editAnimal = {};
  };
  
  //show person
   $scope.showPerson = function(person) {
    $scope.isOpen = true;
    $http.get('http://localhost:8080/person'.concat(person.id)).then(
    function successCallback(response) {
      $scope.personShow = response.data;
    });
    
  };
  //show product
    $scope.showProduct = function(product) {
    $scope.isOpen = true;
    $http.get('http://localhost:8080/product'.concat(product.id)).then(
    function successCallback(response) {
      $scope.productShow = response.data;
    });
    
  };
  
  //show animal
  
    $scope.showAnimal = function(animal) {
    $scope.isOpen = true;
    $http.get('http://localhost:8080/animal'.concat(animal.id)).then(
    function successCallback(response) {
      $scope.animalShow = response.data;
    });
    
  };
  
  
}]);
  
