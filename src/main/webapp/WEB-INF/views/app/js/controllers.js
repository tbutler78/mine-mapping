function AppListCtrl($scope, $http, $log, $templateCache) {




    $scope.listApps = function() {

        $http({method: 'GET', url: 'http://localhost:8080/minemapping/mines', cache: $templateCache}).
            success(function(data, status, headers, config) {
                $scope.mines = data.mines;                  //set view model
                $scope.view = './partials/list.html'; //set to list view
                $scope.map = {

                    center: {
                        latitude: data.middleLat,
                        longitude: data.middleLong
                    },
                    options:{
                        mapTypeId: google.maps.MapTypeId.TERRAIN
                    },
                    zoom: 8,
                    events: {
                        tilesloaded: function (map) {
                            $scope.$apply(function () {
                                $log.info('this is the map instance', map);
                            });
                        }
                    }
                };


                google.maps.visualRefresh = true;

            }).
            error(function(data, status, headers, config) {
                $scope.mines = data || "Request failed";
                $scope.status = status;
                $scope.view = './partials/list.html';
            });




    }

    //$scope.showApp = function(id) {
    $scope.showApp = function() {
        //$http({method: 'GET', url: 'http://localhost:8080/minemapping/mine' + id, cache: $templateCache}).
        $http({method: 'GET', url: 'http://localhost:8080/minemapping/mine', cache: $templateCache}).
            success(function(data, status, headers, config) {
                $scope.appDetail = data.mines;               //set view model
                $scope.view = './partials/detail.html'; //set to detail view
                $scope.myLatlng = new google.maps.LatLng(42.92828, -116.7737);

            }).
            error(function(data, status, headers, config) {
                $scope.appDetail = data || "Request failed";
                $scope.status = status;
                $scope.view = './partials/detail.html';
            });
    }

    $scope.view = './partials//list.html'; //set default view
    $scope.listApps();



}

