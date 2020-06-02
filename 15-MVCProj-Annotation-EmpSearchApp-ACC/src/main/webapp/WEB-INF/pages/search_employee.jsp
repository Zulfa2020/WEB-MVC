<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<h1 style="color:red;text-align:center">Search Employee details </h1>
    
    <form action="search_emps.htm"  method="POST">
       <b>  Employee No::  </b><input type="text" name="empno" /> <br>
       <b> Employee Name::  </b><input type="text" name="ename"/><br>
      <b>  Employee Desig :: </b> <input type="text" name="job"/><br>
    <b>     Employee Salary :: </b> <input type="text" name="sal" /><br>
         <input type="submit"  value="search Employess">
        </form>