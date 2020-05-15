<div class="row" ng-controller="MenuController as ctrl">
	<div class="col-lg-12">
		<div class="container">
			<div class="row  col-md-12">
				<!-- <h2>Create Your Simple Registration Form</h2> -->

				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal"  >
					<fieldset>
						<!-- Form Name -->
						<legend>Menu</legend>
						<input type="hidden" ng-model="ctrl.menu.id" />
						<!-- Text input-->
						<div class="form-group"
							ng-class="{ 'has-error' : myForm.menuName.$invalid && !myForm.menuName.$pristine }">
							<label class="col-md-4 control-label" for="menuName">Menu
								Name</label>
							<div class="col-md-4">
								<input id="menuName" name="menuName"
									ng-model="ctrl.menu.menuName" placeholder="Insert Menu Name"
									class="form-control input-md" required="" type="text">
								<div class="has-error" ng-show="myForm.menuName.$dirty">
									<span ng-show="myForm.menuName.$error.required">This is
										a required field.</span> <span ng-show="myForm.menuName.$invalid">Please
										enter valid value.</span>
								</div>
							</div>
						</div>
						<div class="form-group"
							ng-class="{ 'has-error' : myForm.menuDesc.$invalid && !myForm.menuDesc.$pristine }">
							<label class="col-md-4 control-label" for="menuDesc">Menu
								Desc</label>
							<div class="col-md-4">
								<input id="menuDesc" name="menuDesc"
									ng-model="ctrl.menu.menuDesc" placeholder="Insert Menu Desc"
									class="form-control input-md" required="" type="text">
								<div class="has-error" ng-show="myForm.menuDesc.$dirty">
									<span ng-show="myForm.menuDesc.$error.required">This is
										a required field.</span> <span ng-show="myForm.menuDesc.$invalid">Please
										enter valid value.</span>
								</div>
							</div>
						</div>
						<div class="form-group" ng-class="{ 'has-error' : myForm.menuType.$invalid && !myForm.menuType.$pristine }">
							<label class="col-md-4 control-label" for="menuType" >Menu
								Type</label>
							<div class="col-md-4">
								<select class="form-control"         
									          ng-model="ctrl.menu.menuType" name="menuType" id="menuType"								          
									          required>
									<option value="">Select Menu Type</option>
									<option value="main-menu">Main Menu</option>
									<option value="sub-menu">Sub Menu</option>
								</select>
								<div class="has-error" ng-show="myForm.menuType.$dirty">
	                                      <span ng-show="myForm.menuType.$error.required">This is a required field.</span>	                                      
	                                      <span ng-show="myForm.menuType.$invalid">Please enter valid value.</span>
	                                  </div>
							</div>
						</div>
						<div class="form-group" ng-if="ctrl.menu.menuType == 'sub-menu'">
							<label class="col-md-4 control-label" for="menuList">Parent
								Menu</label>
							<div class="col-md-4">
								<!-- <select class="form-control" id="menuList">
									<option ng-model="0">Main Menu</option>
									<option ng-model="ctrl.menu.id">Menu Name</option>
								</select> -->
								
								 <select class="form-control" id="parentMenu" 
				                              	  		   ng-model="ctrl.menu.parentId"
				                              	  		   ng-options="menu.id as menu.menuName for menu in ctrl.menus"
				                              	  		   required>
												      	   <option value="">Please Select Parent Menu</option>	
												  </select>
							</div>
						</div>
						
						<div class="form-group" ng-class="{ 'has-error' : myForm.status.$invalid && !myForm.status.$pristine }">
							<label class="col-md-4 control-label" for="status">Status</label>
							<div class="col-md-4">
								<select class="form-control"         
									          ng-model="ctrl.menu.state" name="state" 						          
									          required id="state">
								    <option value="">Select Status</option>
									<option value="1">Active</option>
									<option value="0">In-active</option>
								</select>
								<div class="has-error" ng-show="myForm.state.$dirty">
	                                      <span ng-show="myForm.state.$error.required">This is a required field.</span>	                                      
	                                      <span ng-show="myForm.state.$invalid">Please enter valid value.</span>
	                                  </div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-4 control-label" for="menuIcon">Menu
								Icon</label>
							<div class="image-preview col-md-4">
								<div class=" pull-left col-md-12 btn btn-default image-preview-input">
									<div class="col-md-4  pull-left">
										<input type="file" accept="image/png, image/jpeg, image/gif" class="btn btn-primary btn-sm"
											name="input-file-preview" file-model = "myFile" class="imageClass" />
										<!-- rename it -->
									</div>
									 <div class="form-group col-md-4">
			                              <img ng-src="{{imageSrc}}" height="155" width="200"
											  			style="border-radius: 6px 6px 6px 6px !important;"
											  			ng-hide="(imageSrc == null) ? true : false">
			                          </div>
								</div>
							</div>
						</div>
						<!-- Button -->
						<div class="form-group">
							<div class="col-md-4 "></div>
							<div class="col-md-4">
								<div class="col-md-4">
									<input type="submit"
										value="{{!ctrl.menu.id ? 'Add Menu' : ' Update Menu'}}"
										class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
								</div>
								<div class="col-md-4">
									<button type="button" ng-click="ctrl.reset()"
										class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine"
										value="">Reset</button>
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
				<fieldset>
					<legend>
						<span>Menu List </span> <span class="col-md-4 pull-right">
							<input type="text" ng-model="ctrl.filterSearch" id="filterSearch"
							name="filterSearch" class="form-control input-sm"
							placeholder="Enter Search String" required />
						</span> <br> <br>
					</legend>


					<table
						class="table table-striped table-bordered table-hover table-responsive ">
						<thead>
							<tr>
								<th style="text-align: center">#</th>
								<th style="text-align: center">Menu Name</th>
								<th style="text-align: center">Edit</th>
								<th style="text-align: center">Delete</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="u in ctrl.menus | filter: ctrl.filterSearch">
								<td align="center"><span ng-bind="u.id"></span></td>
								<td><span ng-bind="u.menuName"></span></td>
								<td align="center">
									<button type="button" ng-click="ctrl.edit(u.id)"
										class="btn btn-primary btn-xs">
										<i class="fa fa-edit"> Edit</i>
									</button>
								</td>
								<td align="center">
									<button type="button" ng-click="ctrl.remove(u.id)"
										class="btn btn-xs btn-danger">
										<i class="fa fa-trash-o"> Remove</i>
									</button>
								</td>
							</tr>
						</tbody>
					</table>
				</fieldset>
			</div>
		</div>
	</div>
</div>