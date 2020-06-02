<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <h1 style="color:red;text-align:center">Corona Patient Registration</h1>
    <form:form modelAttribute="patCmd" >
    <table bgcolor="cyan" align="center">
    <tr>
   <td> <b style="color:red">Patient Name::</b></td>
   <td> <form:input  path="patName" /><br></td>
    </tr>
    <tr>
   <td> <b style="color:red">Patient Age::</b></td>
   <td> <form:input  path="age" /><br></td>
    </tr>
    <tr>
   <td> <b style="color:red">Patient Location::</b></td>
   <td> <form:input  path="location" /><br></td>
    </tr>
    <tr>
   <td> <b style="color:red">Patient Hospital::</b></td>
   <td> <form:input  path="hospital" /><br></td>
    </tr>
    <tr>
 <td>   <input  type="submit"  value="Register" /></td>
   <td>    <input  type="reset"  value="Cancel" /></td>
       </tr>
    </table>
    </form:form>