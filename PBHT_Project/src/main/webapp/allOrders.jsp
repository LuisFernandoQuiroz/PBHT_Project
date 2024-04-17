<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mi Cafetería Artesanal</title>
</head>

<style>
	body {
		margin: 0;
		background-color: #EFC688;
	}
	
	.header {
		width: 100%;
		height: 60px;
		position: fixed;
		top: 0;
		background-color: #4D2D18;
		padding-bottom: 15px;
		color: white;
	}
	
	.top-text {
		margin-top: 150px;
	}
	
	h1 {
		text-align: center;
	}
	
	footer {
		background-color: #8A6240;
		padding-top: 25px;
		padding-bottom: 25px;
	}
	
	.foot-text {
		text-align: center;
		color: white;
		font-size: 15px;
	}
	
	br {
		user-select: none;
	}
	
	table, td, th {
		border: 1px solid #4D2D18;
		border-collapse: collapse;
	}
	
	table {
		text-align:center;
		width:75vw;
		align:center;
	}
	/*
	td {
		width:6;
	}
	*/
	.table {
		margin-left:auto;
		margin-right:auto;
	}
	
	h1 {
		text-align: center;
	}
	
	th {
		background-color: #4D2D18;
	}
	
	.highlight {
		background-color: #4D2D18;
	}
	
	.highlight, th {
		Color: White;
		font-weight: bold;
	}
	
	div {
		text-align:center;
		align:center;
	}
</style>

<body>
	<div class="header">
		<div>
			<h1>Mi Cafetería Artesanal</h1>
		</div>
	</div>
	
	<%
		String url = "jdbc:mysql://localhost:3306/mca";
		String username = "root";
		String password = "mysqlpassword";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection(url,username,password);
		
		PreparedStatement prep = connect.prepareStatement("SELECT * FROM orders ORDER BY order_id DESC;");
		ResultSet res = prep.executeQuery();
	%>
	<h1 class="top-text">Historial de ordenes</h1>
	
	<table class="table">
		<tr>
			<th>ID de orden</th>
			<th>Comida 1</th>
			<th>Comida 2</th>
			<th>Comida 3</th>
			<th>Comida 4</th>
			<th>Comida 5</th>
			<th>Comida 6</th>
			<th>Comida 7</th>
			<th>Comida 8</th>
			<th>Comida 9</th>
			<th>Bebida 1</th>
			<th>Bebida 2</th>
			<th>Bebida 3</th>
			<th>Nombre</th>
			<th>Direccion</th>
			<th># telefonico</th>
			<th>Correo</th>
		</tr>
		<% while (res.next()){ %>
		<tr>
			<td class="highlight"><%=res.getInt("order_id")%></td>
			<td><%=res.getInt("cid_1")%></td>
			<td><%=res.getInt("cid_2")%></td>
			<td><%=res.getInt("cid_3")%></td>
			<td><%=res.getInt("cid_4")%></td>
			<td><%=res.getInt("cid_5")%></td>
			<td><%=res.getInt("cid_6")%></td>
			<td><%=res.getInt("cid_7")%></td>
			<td><%=res.getInt("cid_8")%></td>
			<td><%=res.getInt("cid_9")%></td>
			<td><%=res.getInt("bid_1")%></td>
			<td><%=res.getInt("bid_2")%></td>
			<td><%=res.getInt("bid_3")%></td>
			<td><%=res.getString("u_nom")%></td>
			<td><%=res.getString("u_dir")%></td>
			<td><%=res.getString("u_num")%></td>
			<td><%=res.getString("u_cor")%></td>
		</tr>
		
		<% } %>
	</table>
	
	<div>
		<a href="order_placed_emp.html">Regresar</a>
	</div>
</body>
</html>