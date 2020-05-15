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
	
	this.articleCategoryDetails = function(callback){
		return $http.post("/mublog/articleCategoryDetails")
		.success(function(data){
			callback(data);
		})
	};
	
	this.menuDetails = function(callback){
		return $http.post("/mublog/menuDetails")
		.success(function(data){
			callback(data);
		})
	};
	
	this.uploadMenuImage = function(menuId,file,callback){
        var formData = new FormData();
        formData.append("file",file);   
        $http.post("/mublog/menuDetails/upload/"+menuId, formData, {
           transformRequest: angular.identity,
           headers: {'Content-Type': undefined}
        })    
        .success(function(data){
        	callback(data);
        })    
        .error(function(){
        });
     }
	
}]);