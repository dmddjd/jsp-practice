<%@ page import="java.util.ArrayList, com.kh.practice.model.vo.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원 검색 결과</title>
</head>
<body>
    <h2>검색 결과</h2>
	<div>
		<c:choose>
			<c:when test="${empty list}">
				<p style="color:red;">해당 이름의 회원이 존재하지 않습니다.</p>
			</c:when >
			<c:otherwise >
				<c:forEach var="m" items="${list}">
					<div class="member">
			            <p>이름: ${m.name}</p>
			            <p>나이: ${m.age}</p>
			            <p>성별: ${m.gender}</p>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>   
</body>
</html>
