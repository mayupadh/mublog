<div class="row" ng-controller="UserController as ctrl">
	<div class="col-lg-12">
		<div class="container">
			<div class="row  col-md-12">
				<!-- <h2>Create Your Simple Registration Form</h2> -->

				<form ng-submit="ctrl.submit()" name="myForm" 	class="form-horizontal">
					<fieldset>
						<!-- Form Name -->
						<legend>User Registration</legend>
						<input type="hidden" ng-model="ctrl.user.id" />
						<!-- Text input-->
						<div class="form-group"
							ng-class="{ 'has-error' : myForm.firstName.$invalid && !myForm.firstName.$pristine }">
							<label class="col-md-4 control-label" for="firstName">First
								Name</label>
							<div class="col-md-4">
								<input id="firstName" name="firstName"
									ng-model="ctrl.user.firstName"
									placeholder="Insert your First Name"
									class="form-control input-md" required="" type="text">
								<div class="has-error" ng-show="myForm.firstName.$dirty">
									<span ng-show="myForm.firstName.$error.required">This is
										a required field.</span> <span ng-show="myForm.firstName.$invalid">Please
										enter valid value.</span>
								</div>
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group"
							ng-class="{ 'has-error' : myForm.lastName.$invalid && !myForm.lastName.$pristine }">
							<label class="col-md-4 control-label" for="lastName">Last
								Name</label>
							<div class="col-md-4">
								<input id="lastName" name="lastName"
									ng-model="ctrl.user.lastName"
									placeholder="Insert your Last Name"
									class="form-control input-md" required="" type="text">
								<div class="has-error" ng-show="myForm.lastName.$dirty">
									<span ng-show="myForm.lastName.$error.required">This is
										a required field.</span> <span ng-show="myForm.lastName.$invalid">Please
										enter valid value.</span>
								</div>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group"
							ng-class="{ 'has-error' : myForm.emailId.$invalid && !myForm.emailId.$pristine }">
							<label class="col-md-4 control-label" for="emailId">Email</label>
							<div class="col-md-4">
								<input id="emailId" name="emailId" ng-model="ctrl.user.emailId"
									placeholder="Insert your Email" class="form-control input-md"
									required="" type="text">
								<div class="has-error" ng-show="myForm.emailId.$dirty">
									<span ng-show="myForm.emailId.$error.required">This is a
										required field.</span> <span ng-show="myForm.emailId.$invalid">Please
										enter valid value.</span>
								</div>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group"
							ng-class="{ 'has-error' : myForm.userName.$invalid && !myForm.userName.$pristine }">
							<label class="col-md-4 control-label" for="userName">UserName
							</label>
							<div class="col-md-4">
								<input id="userName" name="userName"
									ng-model="ctrl.user.userName"
									placeholder="Insert your UserName"
									class="form-control input-md" required="" type="text">
								<div class="has-error" ng-show="myForm.userName.$dirty">
									<span ng-show="myForm.userName.$error.required">This is
										a required field.</span> <span ng-show="myForm.userName.$invalid">Please
										enter valid value.</span>
								</div>
							</div>
						</div>


						<!-- Text input-->
						<div class="form-group"
							ng-class="{ 'has-error' : myForm.password.$invalid && !myForm.password.$pristine }">
							<label class="col-md-4 control-label" for="textinput">Password</label>
							<div class="col-md-4">
								<input id="password" name="password"
									ng-model="ctrl.user.password"
									placeholder="Insert your Password"
									class="form-control input-md" required="" type="password">
								<div class="has-error" ng-show="myForm.password.$dirty">
									<span ng-show="myForm.password.$error.required">This is
										a required field.</span> <span ng-show="myForm.password.$invalid">Please
										enter valid value.</span>
								</div>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group"
							ng-class="{ 'has-error' : myForm.confPassword.$invalid && !myForm.confPassword.$pristine }">
							<label class="col-md-4 control-label" for="confPassword">Confirm
								Password</label>
							<div class="col-md-4">
								<input id="confPassword" name="confPassword"
									ng-model="ctrl.user.confPassword"
									placeholder="Confirm your Password"
									class="form-control input-md" required="" type="password">
								<div class="has-error" ng-show="myForm.confPassword.$dirty">
									<span ng-show="myForm.confPassword.$error.required">This
										is a required field.</span> <span
										ng-show="myForm.confPassword.$invalid">Please enter
										valid value.</span>
								</div>
							</div>
						</div>
						
						<div class="form-group">	
							<label class="col-md-4 control-label" for="roleName">Role</label>
							<div class="col-md-4">
								<select class="form-control input-sm"
										ng-model="ctrl.user.role.id"
										ng-options="role.id as role.roleName for role in ctrl.roles">
										<option value="">Please Select Role</option>
									</select>		
							</div>
						</div>




						<!-- Button -->
						<div class="form-group">
							<div class="col-md-4 "></div>
							<div class="col-md-2 ">
								<div class="col-md-4">
									<input type="submit"
										value="{{!ctrl.user.id ? '  Add  ' : ' Update'}}"
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
						<span>User List </span> <span class="col-md-4 pull-right">
							<input type="text" ng-model="ctrl.filterSearch" id="filterSearch"
							name="filterSearch" class="form-control input-sm"
							placeholder="Enter Search String" required />
						</span> <br>
						<br>
					</legend>


					<table
						class="table table-striped table-bordered table-hover table-responsive ">
						<thead>
							<tr>
								<th style="text-align: center">#</th>
								<th style="text-align: center">First Name</th>
								<th style="text-align: center">Last Name</th>
								<th style="text-align: center">Username</th>
								<th style="text-align: center">E-MailId</th>
								<th style="text-align: center">Edit</th>
								<th style="text-align: center">Delete</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat="u in ctrl.users | filter: ctrl.filterSearch">
								<td><span ng-bind="u.id"></span></td>
								<td><span ng-bind="u.firstName"></span></td>
								<td><span ng-bind="u.lastName"></span></td>
								<td><span ng-bind="u.userName"></span></td>
								<td><span ng-bind="u.emailId"></span></td>
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