<%@page import="com.mysql.cj.protocol.SocksProxySocketFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products Page</title>
<style>
    /* Page Style */
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        color: #333;
        margin-top: 20px;
    }

    /* Table Style */
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }

    th {
        background-color: #4CAF50;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }

    td {
        color: #555;
    }

</style>
</head>
<body>
    <h1>All Products</h1>
    <a href="index.jsp"> <button>Create Product</button> </a>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Brand</th>
            <th>Description</th>
            <th colspan="2">Action</th>
        </tr>
        <%
            ResultSet rs = (ResultSet) request.getAttribute("abc");
            while(rs.next()){
        %>
        <tr>
            <td><%= rs.getString(1) %></td>
            <td><%= rs.getString(2) %></td>
            <td><%= rs.getString(3) %></td>
            <td><%= rs.getString(4) %></td>
            <td><%= rs.getString(5) %></td>
            <td> <a href="delete?id=<%= rs.getString(1) %>"> <button>Delete</button> </a> </td>
            <td> <a href="updatepage?id=<%= rs.getString(1) %>"> <button>Update</button> </a> </td>
        </tr>
        <%} %>
    </table>
</body>
</html>
