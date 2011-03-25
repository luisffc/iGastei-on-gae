<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>compras-cartao</title>
</head>
<body>
	<p>IGastei</p>
	
	<table width="700" border="1" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<td>id</td>
				<td>cartao</td>
				<td>data</td>
				<td>descOperadora</td>
				<td>valorOperadora</td>
				<td>descricao</td>
				<td>emprestado</td>
				<td>observacao</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${lista}">
			<tr>
				<td><c:out value="${item.id}"/></td>
				<td><c:out value="${item.cartao}"/></td>
				<td><c:out value="${item.data}"/></td>
				<td><c:out value="${item.descOperadora}"/></td>
				<td><c:out value="${item.valorOperadora}"/></td>
				<td><c:out value="${item.descricao}"/></td>
				<td><c:out value="${item.emprestado}"/></td>
				<td><c:out value="${item.observacao}"/></td>
				<td><a href="compras-cartao?action=delete&id=<c:out value="${item.id}"/>">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<p></p>
	
	<form action="compras-cartao" method="post">
		<input type="hidden" name="action" value="create" />
		<p>cartao</p>
		<input type="text" name="cartao" /><br />
		<p>descOperadora</p>
		<input type="text" name="descOperadora" /><br />
		<p>valorOperadora</p>
		<input type="text" name="valorOperadora" /> (Numero)<br />
		<input type="submit" value="Create" /><br />
	</form>
	
</body>
</html>