'use strict';

admin.controller('ArticleCategoryController', ['$scope', 'ArticleCategory', 'commonService', function($scope,ArticleCategory,commonService) {
          var self = this;
          
          self.articleCategory = new ArticleCategory();
          
          self.articleCategories=[];
              
          self.fetchAllArticleCategories = function(){
        	  self.articleCategories = ArticleCategory.query();
          };
           
          self.createArticleCategory = function(){
        	  self.articleCategory.$save(function(){
        		  console.log('Inside articleCategory saving');
        		  self.fetchAllArticleCategories();
        	  });
          };
          
          
          

          self.updateArticleCategory = function(){
        	  self.articleCategory.$update(function(){
    			  self.fetchAllArticleCategories();
    		  });
          };

         self.deleteArticleCategory = function(identity){
        	 var articleCategory = ArticleCategory.get({id:identity}, function() {
        		 articleCategory.$delete(function(){
        			  console.log('Deleting ArticleCategory with id ', identity);
        			  self.fetchAllArticleCategories();
        		  });
        	 });
          };

          self.fetchAllArticleCategories();

          self.submit = function() {
              if(self.articleCategory.id==null){
                  console.log('Saving New ArticleCategory', self.articleCategory);
                  //alert(self.role);
                  self.createArticleCategory();
              }else{
    			  console.log('Updating articleCategory with id ', self.articleCategory.id);
                  self.updateArticleCategory();
                  console.log('ArticleCategory updated with id ', self.articleCategory.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.articleCategories.length; i++){
                  if(self.articleCategories[i].id === id) {
                     self.articleCategory = angular.copy(self.articleCategories[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.articleCategory.id == id) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deleteArticleCategory(id);
          };

          
          self.reset = function(){
              self.articleCategory= new ArticleCategory();
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
