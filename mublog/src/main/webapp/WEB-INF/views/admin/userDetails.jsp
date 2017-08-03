<div class="row">
	<div class="col-lg-12">
		<h2>ADMIN DASHBOARD</h2>
	</div>
</div>
<div class="container">
	<div class="row  col-md-12">
		<!-- <h2>Create Your Simple Registration Form</h2> -->

		<form class="form-horizontal">
			<fieldset>

				<!-- Form Name -->
				<legend>User Registration</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">First
						Name</label>
					<div class="col-md-4">
						<input id="textinput" name="textinput"
							placeholder="Insert your First Name"
							class="form-control input-md" required="" type="text"> <span
							class="help-block"> </span>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Last
						Name</label>
					<div class="col-md-4">
						<input id="textinput" name="textinput"
							placeholder="Insert your Last Name" class="form-control input-md"
							required="" type="text"> <span class="help-block">
						</span>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Email</label>
					<div class="col-md-4">
						<input id="textinput" name="textinput"
							placeholder="Insert your Email" class="form-control input-md"
							required="" type="text"> <span class="help-block">
						</span>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Password</label>
					<div class="col-md-4">
						<input id="textinput" name="textinput"
							placeholder="Insert your Password" class="form-control input-md"
							required="" type="text"> <span class="help-block">
						</span>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="textinput">Confirm
						Password</label>
					<div class="col-md-4">
						<input id="textinput" name="textinput"
							placeholder="Confirm your Password" class="form-control input-md"
							required="" type="text"> <span class="help-block">
						</span>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"> </label>
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton"
							class="btn btn-primary">Submit</button>
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
			<legend>User List</legend>
			<table class="table table-striped table-bordered table-hover table-responsive ">
				<thead>
					<tr>
						<th>#</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Username</th>
						<th>E-MailId</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
				  <c:forEach items="${userList}" var="user">
					<tr>
						<td>1</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.userName}</td>
						<td>${user.emailId}</td>
						<td>Edit</td>
						<td>Delete</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
</div>
</div>