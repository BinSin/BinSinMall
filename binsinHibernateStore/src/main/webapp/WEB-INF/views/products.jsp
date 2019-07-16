<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container-wrapper">
	<div class="container">
		<h2>All Products</h2>
		<p>모든 상품 내역</p>
		<table class="table table-striped">
			<thead>
				<tr class="bg-success">
					<th>ID</th>
					<th>Name</th>
					<th>Category</th>
					<th>Price</th>
					<th>Manufacturer</th>
					<th>Unit In Stock</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${products}">
					<tr>
						<td>${product.id}</td>
						<td>${product.name}</td>
						<td>${product.category}</td>
						<td>${product.price}</td>
						<td>${product.manufacturer}</td>
						<td>${product.unitInStock}</td>
						<td>${product.description}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
