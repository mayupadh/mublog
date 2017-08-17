<div class="row" ng-controller="RoleController as ctrl">
<div class="col-lg-12">		
<div class="container">
	<div class="row  col-md-12"  >
		<!-- <h2>Create Your Simple Registration Form</h2> -->

		<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
			<fieldset>
				<!-- Form Name -->
				<legend>Role</legend>
				<input type="hidden" ng-model="ctrl.role.id" />
				<!-- Text input-->
				<div class="form-group" ng-class="{ 'has-error' : myForm.roleName.$invalid && !myForm.roleName.$pristine }">
					<label class="col-md-4 control-label" for="roleName">Role Name</label>
					<div class="col-md-4">
						<input id="roleName" name="roleName" ng-model="ctrl.role.roleName"
							placeholder="Insert Role Name"
							class="form-control input-md" required="" type="text"> 
							<div class="has-error" ng-show="myForm.roleName.$dirty">
										<span ng-show="myForm.roleName.$error.required">This
											is a required field.</span> <span
											ng-show="myForm.roleName.$invalid">Please
											enter valid value.</span>
							</div>
					</div>
				</div>
								            
				
				<!-- Button -->
				<div class="form-group" >
				<div class="col-md-4 "> </div>
					<div class="col-md-4">
							<div class="col-md-4">
								<input type="submit" value="{{!ctrl.role.id ? 'Add Role' : ' Update Role'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
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
			<legend><span >Role List </span>
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
						<th style="text-align:center">Role Name</th>
						<th style="text-align:center">Edit</th>
						<th style="text-align:center">Delete</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="u in ctrl.roles | filter: ctrl.filterSearch">
						<td align="center"><span ng-bind="u.id"></span></td>
						<td><span ng-bind="u.roleName"></span></td>
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