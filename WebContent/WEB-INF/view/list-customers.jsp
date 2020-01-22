<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of customers</title>
	<!-- Adding link to css here -->
	<link type="text/css"
	       rel="stylesheet"
	       href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
   <div id="wrapper">
      <div  id="header">
        <h2> CRM - Customer Relationship Manager</h2>
      </div>
   </div>
   
   <div id="container">
      <div id="content">
        <!--  "Add Customer" button -->
        <input type="button" value="Add Customer"
                onclick="window.location.href='showAddCustomerForm';return false;"
                class="add-button"/> 
                
        <!--  Search Support STARTS--> 
          <!--  spring tag form:form action is POST by default.  -->
        <form:form action="searchCustomer" method="GET"> 
            Search Customer : <input type="text" name="theSearchInput"/>
                              <input type="submit" value="Search" class="add-button"/>
        </form:form>
		<!--  Search Support ENDS-->               
          <table>
             <tr>
               <th>First Name</th>
               <th>Last Name</th>
               <th>Email</th>
               <th>Action</th>
             </tr>
             
             <!-- Loop over all the customers and display their details -->
             <c:forEach var="customer" items="${customersList}" >
                <tr>
                   <td>${customer.firstName}</td>
                   <td>${customer.lastName}</td>
                   <td>${customer.email}</td>
                   <td><a href="showCustomerForm?customerId=${customer.id}" >Edit</a></td>
                   
                   <td><a href="showDeleteCustomerForm?customerId=${customer.id}" >Delete</a></td>
                </tr>
             </c:forEach>
          </table>
      </div>
   </div>
 
</body>
</html>