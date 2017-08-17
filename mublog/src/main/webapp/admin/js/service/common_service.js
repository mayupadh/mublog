/**
 * 
 */
admin.service('commonService', ['$http',function($http) {
	
	this.userDetails = function(callback){
		return $http.post("/mublog/userDetails")
		.success(function(data){
			callback(data);
		})
	};
	
	this.roleDetails = function(callback){
		return $http.post("/mublog/roleDetails")
		.success(function(data){
			callback(data);
		})
	};
}]);