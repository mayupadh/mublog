'use strict';

admin.controller('MenuController', ['$scope', 'Menu', 'commonService', function($scope, Menu, commonService) {
          var self = this;
          self.menu= new Menu();
          
          self.menus=[];
          
          /*self.roles=[];
          
          self.fetchAllRoles = function(){
        	  self.roles = Role.query();
          };*/
              
          self.fetchAllMenus = function(){
        	  self.menus = Menu.query();
          };
          
          $scope.fileChanged = function(){
              var reader = new FileReader();  
              if($scope.myExcelFile != null){
              reader.onload = function(){
                var arrayBuffer = reader.result;
                $scope.$apply(function(){
                  });
              };
              reader.readAsDataURL($scope.myExcelFile);
              }
              if($scope.myFile != null){
                  reader.onload = function(){
                    var arrayBuffer = reader.result;
                    $scope.$apply(function(){
                  	  $scope.imageSrc = arrayBuffer;
                      });
                  };
                  reader.readAsDataURL($scope.myFile);
              }
          }
      	
           
          self.createMenu = function(){
        	  self.menu.$save(function(data){
        		  console.log(data.menuName);      		 
        		  if($scope.myFile != null && $scope.myFile != undefined) {
        			  console.log(JSON.stringify(data));
        			  commonService.uploadMenuImage(data.menuName,$scope.myFile,function(){
      	        		$scope.myFile = undefined;
      	        		document.getElementsByClassName("imageClass").value = '';	        		
      	        		$scope.imageSrc = undefined;
      	        	});
              	}
        		  self.fetchAllMenus();
        	  });
          };

          self.updateMenu = function(){
        	  self.menu.__proto__ = new Menu().__proto__;
          	var editedMenuId = self.menu.id;
        	  self.menu.$update(function(){
        		  if($scope.myFile !=null && $scope.myFile != undefined) {
      	        	commonService.uploadMenuImage(editedMenuId,$scope.myFile,function(){
      	        		$scope.myFile = undefined;
      	        		document.getElementsByClassName("imageClass").value = '';	        		
      	        		$scope.imageSrc = undefined;
      	        	})
              	  }
    			  self.fetchAllMenus();
    		  }, function(errorResult) {
    	            // do something on error
    	            if(errorResult.status === 409) {            	
    	            	alert("Duplicate Menu!");
    	            }
    	        }
    	        );
    	    };

         self.deleteMenu = function(identity){
        	 var menu = Menu.get({id:identity}, function() {
        		  menu.$delete(function(){
        			  console.log('Deleting menu with id ', identity);
        			  self.fetchAllMenus();
        		  });
        	 });
          };

          //self.fetchAllRoles();
          self.fetchAllMenus();

          self.submit = function() {
              if(self.menu.id==null){
                  console.log('Saving New Menu', self.menu);
                  //alert(self.menu);
                  self.createMenu();
              }else{
    			  console.log('Upddating menu with id ', self.menu.id);
                  self.updateMenu();
                  console.log('Menu updated with id ', self.menu.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.menus.length; i++){
                  if(self.menus[i].id === id) {
                     self.menu = angular.copy(self.menus[i]);
                     $scope.imageSrc = '';
                     if(self.menu.menuIcon != null && self.menu.menuIcon != undefined) {
                  	   $scope.imageSrc = 'data:image/JPEG;base64,'+self.menu.menuIcon;               	   
                     }
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.menu.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deleteMenu(id);
          };

          
          self.reset = function(){
              self.menu= new Menu();
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
