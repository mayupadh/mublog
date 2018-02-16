'use strict';

admin.controller('ArticleController', ['$scope', 'Article', 'commonService', function($scope,Article,commonService) {
          var self = this;
          alert("Inside ArticleController");
          self.article = new Article();
          
          self.article=[];
              
          self.fetchAllArticle = function(){
        	  self.article = Article.query();
          };
           
          self.createArticle = function(){
        	  self.article.$save(function(){
        		  self.fetchAllArticle();
        	  });
          };

          self.updateArticle = function(){
        	  self.article.$update(function(){
    			  self.fetchAllArticle();
    		  });
          };

         self.deleteArticle = function(identity){
        	 var article = Article.get({id:identity}, function() {
        		 article.$delete(function(){
        			  console.log('Deleting Article with id ', identity);
        			  self.fetchAllArticle();
        		  });
        	 });
          };

          self.fetchAllArticle();

          self.submit = function() {
              if(self.role.id==null){
                  console.log('Saving New Article', self.article);
                  //alert(self.role);
                  self.createRole();
              }else{
    			  console.log('Upddating article with id ', self.article.id);
                  self.updateArticle();
                  console.log('Article updated with id ', self.article.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.article.length; i++){
                  if(self.article[i].id === id) {
                     self.article = angular.copy(self.article[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.article.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deleteRole(id);
          };

          
          self.reset = function(){
              self.article= new Article();
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
