<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/admin_resources/css" />
<spring:url var="js" value="/admin_resources/js" />
<spring:url var="images" value="/admin_resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>${title}</title>
<!-- BOOTSTRAP STYLES-->
<link href="${css}/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="${css}/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="${css}/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<script>
	window.menu = '${title}';
</script>
</head>
<body ng-app="admin">
	<div id="wrapper">
		<!-- Header -->
		<%@include file="./admin/navTop.jsp"%>
		<!-- Left Side Menu -->
		<%@include file="./admin/navLeftSide.jsp"%>
		<div id="page-wrapper">
			<div id="page-inner">
			<c:if  test= "${showUserDetails == true}" >
		 	<%@include file="./admin/userDetails.jsp" %>
		    </c:if>
		    
		    <c:if  test= "${showRoleDetails == true}" >
		 	<%@include file="./admin/roleDetails.jsp" %>
		    </c:if>
		    
		     <c:if  test= "${menuDetails == true}" >
		 	<%@include file="./admin/menuDetails.jsp" %>
		    </c:if>
		     
		     <c:if  test= "${showDashboardMenu == true}" >
		 	<%@include file="./admin/dashboardContentMenu.jsp" %>
		     </c:if> 
		     	     
		     <c:if  test= "${showArticleCategoriesDetails == true}" >
		 		<%@include file="./admin/articleCategoryDetails.jsp" %>
		     </c:if>
		       <c:if  test= "${showArticleDetails == true}" >
		 		<%@include file="./admin/articleDetails.jsp" %>
		     </c:if> 
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<!-- Footer  -->
	<!-- Left Side Menu -->
	<%@include file="./admin/footer.jsp"%>

    <%@include file="./admin/includedScripts.jsp"%>

    
	
    	<!-- /. WRAPPER  -->
	
	
</body>
</html>
