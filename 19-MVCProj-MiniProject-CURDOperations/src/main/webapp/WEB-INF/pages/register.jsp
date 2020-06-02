<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
    <h1 style="color:red;text-align:center">Employee Registration</h1>
    <form:form modelAttribute="patCmd" >
    <table bgcolor="cyan" align="center">
    <tr>
   <td> <b style="color:red">Employee No::</b></td>
   <td> <form:input  path="empNo" /><br></td>
    </tr>
    <tr>
   <td> <b style="color:red">Employee Name::</b></td>
   <td> <form:input  path="ename" /><br></td>
    </tr>
    <tr>
   <td> <b style="color:red">Employee Job::</b></td>
   <td> <form:input  path="job" /><br></td>
    </tr>
    <tr>
   <td> <b style="color:red">Employee Sal::</b></td>
   <td> <form:input  path="sal" /><br></td>
    </tr>
     <tr>
   <td> <b style="color:red">Employee DeptNo::</b></td>
   <td> <form:input  path="deptNo" /><br></td>
    </tr>
    <tr>
 <td> <a href="welcome.htm">   <input  type="submit"  value="Register" /></a></td>
       </tr>
    </table>
    </form:form>