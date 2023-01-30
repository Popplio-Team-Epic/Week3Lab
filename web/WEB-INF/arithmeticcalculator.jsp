<%-- 
    Document   : arithmeticcalculator
    Created on : 30-Jan-2023, 2:36:32 AM
    Author     : Andrea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form action="ArithmeticCalc" method="post">
            First: <input type="text" name="first" value="${first}"><br>
            Last: <input type="text" name="last" value="${last}"><br>
            <input type="submit" name="operation" value="+">
            <input type="submit" name="operation" value="-">
            <input type="submit" name="operation" value="*">
            <input type="submit" name="operation" value="%">
        </form>
        <p>Result: ${ArithmeticAnswer}</p>
        <a href="AgeCalc">Age Calculator</a>
    </body>
</html>
