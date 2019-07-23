var cartApp = angular.module('cartApp', []);

cartApp.controller("cartCtrl", function($scope, $http) {
	
	$scope.initCartId = function(cartId) {
		$scope.cartId = cartId;
		$scope.refreshart();
		
	};
	
	// short form
	$scope.refreshCart = function() {
		$http.get('/binsinStore/api/cart/' + $scope.cartId).then(
				function successCallback(response) {
					$scope.cart = response.data;
				});
	}
	
	$scope.clearCart = function() {
		$http({
			method: 'DELETE',
			url : '/binsinStore/api/cart/' + $scope.cartId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};
	
	$scope.addToCart = function(productId) {
		$http.put('/binsinStore/api/cart/add/' + productId).then(
				function successCallback() {
					alert("Product successfully added to the acrt");
				}, function errorCallback() {
					alert("Adding to the cart failed")
				});
	};
	
	$scope.removeFromCart = function(productId) {
		$http({
			method : 'DELETE',
			url : '/binsinStore/api/cart/cartitem/' + productId
		}).then(function sucessCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};
	
	$scope.calGrndTotal = function() {
		var grandTotal = 0;
		
		for(var i=0; i<$scope.cart.cartItems.length; i++) {
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}
		
		return grandTotal;
	}
	
});