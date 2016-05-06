var app = angular.module('myApp', []);
app.controller('mainCtrl', function($scope, $http) {
    /*
    $http({
        method : "POST",
        url : "api/load"
    }).then(function(response) {
        alert(response.data);
    });
    */

    $scope.firstName= "John";
    $scope.lastName= "Doe";
    $scope.pageTitle = "B_00_rs" ;

    $scope.activeIndex = 0;

   // var activeIndex = 5;
    $scope.getStatus = function(){
        $http.post("customer/status")
            .then(function(response) {
                alert(response.data);
            });
    };

    $scope.isOn = function(i){
        //alert("hi" + i + '::' + $scope.activeIndex );
        //return ($scope.activeIndex === i);
        return (5 === i);
    };

    $scope.loadSampleData = function(){
        $http({
            method : "POST",
            url : "api/load"
        }).then(function(response) {
            alert(response.data);
        });
    };

    $scope.selectedSymbol = null;
    $scope.symbolInfo = null;

    $scope.setSymbol = function(s){
        $scope.selectedSymbol = s;

        //angular.element("#symbolModal").modal();
        $http({
            method : "POST",
            url : "api/symbols/info",
            params: {
                symbol : s
            }

        }).then(function(response) {
            //alert(response.data);
            $scope.symbolInfo = response.data;
        });
    };

    $scope.changeData = function(){
      $scope.symbolInfo.push({userId:"goolakh"});
    };


    $scope.userInfo = null;
    $scope.customerId = 2;
    $http({
        method : "POST",
        url : "api/customer/credit",
        params: {
            id : $scope.customerId
        }

    }).then(function(response) {
        //alert(response.data);
        $scope.userInfo = response.data;
    });


    $scope.activeOrders = null;
    $scope.approvedOrders = null;
    $scope.declinedOrders = null;
    $http({
        method : "POST",
        url : "api/customer/activeOrders",
        params: {
            id : $scope.customerId
        }

    }).then(function(response) {
        //alert(response.data);
        $scope.activeOrders = response.data;
    });

    $http({
        method : "POST",
        url : "api/customer/approvedOrders",
        params: {
            id : $scope.customerId
        }

    }).then(function(response) {
        //alert(response.data);
        $scope.approvedOrders = response.data;
    });

    $http({
        method : "POST",
        url : "api/customer/declinedOrders",
        params: {
            id : $scope.customerId
        }

    }).then(function(response) {
        //alert(response.data);
        $scope.declinedOrders = response.data;
    });

    $scope.shareBasket = null;
    $http({
        method : "POST",
        url : "api/customer/shares",
        params: {
            id : $scope.customerId
        }

    }).then(function(response) {
        //alert(response.data);
        $scope.shareBasket = response.data;
    });

    $scope.marketActiveOrders = null;
    $http({
        method : "POST",
        url : "api/market/info"
    }).then(function(response) {
        //alert(response.data);
        $scope.marketActiveOrders = response.data;
    });

});

app.controller('menuCtrl', function($scope){


    $scope.menu = [
        {id:"DepositMenu",      title:"افزایش موجودی", image:"images/cash.png",   name:"افزایش موجودی"},
        {id:"OrderMenu",        title:"خرید و فروش",   image:"images/order.png",  name:"ثبت سفارش"},
        {id:"AddCustomerMenu",  title:"ثبت نام",       image:"images/user.png",   name:"کاربر جدید"},
        {id:"ReportMenu",       title:"درخواست ها",    image:"images/report.png", name:"مدیریت درخواست ها"},
        {id:"BackupMenu",       title:"پشتیبان",       image:"images/backup.png", name:"نسخه پشتیبان"},
        {id:"StatusMenu",       title:"بازار",         image:"images/status.png", name:"نبض بازار"},
        {id:"ConfigMenu",       title:"تنظیمات",       image:"images/config.png", name:"تنظیمات"}
    ];

    $scope.isActive = function(i){
        return (i === $scope.activeIndex) ;
    };

    $scope.goToPage = function(i){
        //alert($scope.activeIndex + '\t' + i);
        $scope.activeIndex = i ;
    };

    //$scope.navigate = $scope.$parent.;
});

app.controller('addCtrl', function($scope, $http){
    $scope.addCustomer = function(_name, _family, _id){
        $http({
            method : "POST",
            url : "customer/add",
            params: {
                id : 1/*_id*/,
                name : "_name",
                family : "_family"
            }
        }).then(function(response) {
            alert(response.data);
        });
    }
});

app.controller('symbolCtrl', function($scope, $http){

    //$scope.symbolList = ["RENA1", "SAIPA"];
    $http({
        method : "POST",
        url : "api/symbols"
    }).then(function(response) {
        //alert(response.data);
        $scope.symbolList = response.data;
    });
	
	$scope.getinfo = function(x){
        $http({
        method : "POST",
        url : "/api/symbols/info",
		params: {
                symbol : "x"
        }
	
	}).then(function(response) {
            $scope.symbolList = response.data;
        });
    }


});
