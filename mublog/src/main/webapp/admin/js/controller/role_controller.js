'use strict';

admin.controller('RoleController', ['$scope', 'Role', 'commonService', function($scope,Role,commonService) {
          var self = this;
          self.role= new Role();
          
          self.roles=[];
              
          self.fetchAllRoles = function(){
        	  self.roles = Role.query();
          };
           
          self.createRole = function(){
        	  self.role.$save(function(){
        		  //alert('Saved');
        		  self.fetchAllRoles();
        	  });
          };

          self.updateRole = function(){
        	  self.role.$update(function(){
    			  self.fetchAllRoles();
    		  });
          };

         self.deleteRole = function(identity){
        	 var role = Role.get({id:identity}, function() {
        		  role.$delete(function(){
        			  console.log('Deleting role with id ', identity);
        			  self.fetchAllRoles();
        		  });
        	 });
          };

          self.fetchAllRoles();

          self.submit = function() {
              if(self.role.id==null){
                  console.log('Saving New Role', self.role);
                  //alert(self.role);
                  self.createRole();
              }else{
    			  console.log('Upddating role with id ', self.role.id);
                  self.updateRole();
                  console.log('Role updated with id ', self.role.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.roles.length; i++){
                  if(self.roles[i].id === id) {
                     self.role = angular.copy(self.roles[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.role.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deleteRole(id);
          };

          
          self.reset = function(){
              self.role= new Role();
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
