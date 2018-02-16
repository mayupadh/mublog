<div class="row" ng-controller="ArticleCategoryController as ctrl">
<div class="col-lg-12">		
<div class="container">
	<div class="row  col-md-12"  >
	
		<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
			<fieldset>
				<!-- Form Name -->
				<legend>Article Category</legend>
				<input type="hidden" ng-model="ctrl.articleCategory.id" />
				<!-- Text input-->
				<div class="form-group" ng-class="{ 'has-error' : myForm.categoryName.$invalid && !myForm.categoryName.$pristine }">
					<label class="col-md-4 control-label" for="categoryName">Article Category Name</label>
					<div class="col-md-4">
						<input id="categoryName" name="categoryName" ng-model="ctrl.articleCategory.categoryName"
							placeholder="Insert Article Category Name"
							class="form-control input-md" required="" type="text"> 
							<div class="has-error" ng-show="myForm.categoryName.$dirty">
										<span ng-show="myForm.categoryName.$error.required">This
											is a required field.</span> <span
											ng-show="myForm.categoryName.$invalid">Please
											enter valid value.</span>
							</div>
					</div>
				</div>
								            
				
				<!-- Button -->
				<div class="form-group" >
				<div class="col-md-4 "> </div>
					<div class="col-md-4">
							<div class="col-md-4">
								<input type="submit" value="{{!ctrl.articleCategory.id ? 'Add Category' : ' Update Category'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							</div>
							<div class="col-md-4">							
								<button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine" value="">Reset</button>
							</div>
						</div>
				</div>

			</fieldset>
		</form>

	</div>
</div>
<hr>
<div class="container">
<div class="row">
		<fieldset >
			<legend><span >Article Category List </span>
			<span
						class="col-md-4 pull-right"> <input type="text"
						ng-model="ctrl.filterSearch" id="filterSearch" name="filterSearch"
						class="form-control input-sm" placeholder="Enter Search String"
						required />
			</span>
			<br><br>
			</legend>
			
			
			<table class="table table-striped table-bordered table-hover table-responsive ">
				<thead>
					<tr >
						<th style="text-align:center">#</th>
						<th style="text-align:center">Category Name</th>
						<th style="text-align:center">Edit</th>
						<th style="text-align:center">Delete</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="u in ctrl.articleCategories | filter: ctrl.filterSearch">
						<td align="center"><span ng-bind="u.id"></span></td>
						<td><span ng-bind="u.categoryName"></span></td>
						<td align="center">
									<button type="button" ng-click="ctrl.edit(u.id)"
										class="btn btn-primary btn-xs"><i class="fa fa-edit">   Edit</i></button>
						</td>
						<td align="center">
									<button type="button" ng-click="ctrl.remove(u.id)"
										class="btn btn-xs btn-danger"><i class="fa fa-trash-o"> Remove</i></button>
					   </td>
					</tr>
				</tbody>
			</table>
		</fieldset>
</div>
</div>
</div>
</div>