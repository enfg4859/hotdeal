<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/c5a6a42a0b.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>">
<script src="<c:url value="/resources/js/main.js"/>"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4">
				<div class="logo">HOTDEAL</div>
			</div>
			<div class="col-4">
				<div>
					<form:form modelAttribute="BoardSearch" action="./board?${_csrf.parameterName}=${_csrf.token}" class="form-inline d-flex mx-auto align-items-center">
						<input class="form-control" type="text" name="search" placeholder="" required>
						<button class="btn btn-primary ms-1" type="submit">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>
					</form:form>
				</div>
			</div>
			<div class="col-4">
				<ul class="nav justify-content-end">
					<c:choose>
						<c:when test="${empty sessionScope.user}">
							<li class="nav-item"><a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#loginModal">로그인</a></li>
							<li class="nav-item"><a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#signupModal">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="/hotdeal/users/logout">로그아웃</a></li>
							<li class="nav-item"><a class="nav-link" href="#">마이페이지</a></li>
						</c:otherwise>
					</c:choose>
					<li class="nav-item"><a class="nav-link" href="#"><i class="fa-regular fa-bell position-relative"></i></a></li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div>
				<nav class="nav nav-pills flex-column flex-sm-row col-8 m-auto">
					<a class="flex-sm-fill text-sm-center nav-link" href="#">A</a> <a class="flex-sm-fill text-sm-center nav-link" href="#">B</a> <a class="flex-sm-fill text-sm-center nav-link" href="#">C</a> <a class="flex-sm-fill text-sm-center nav-link" href="#">D</a>
				</nav>
			</div>
		</div>
		<div class="row">
			<div class="d-flex justify-content-end">
				<a href="#" data-bs-toggle="modal" data-bs-target="#itemModal">글쓰기</a>
			</div>
			<div class="col-12">
				<div id="itemContainer" class="d-flex col-12 flex-wrap"></div>
			</div>
		</div>
	</div>


	<!-- Login Modal -->
	<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="loginModalLabel">로그인</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<form id="loginForm">
					<div class="modal-body">
						<div class="mb-3">
							<label for="user_id" class="form-label">아이디</label> <input type="text" class="form-control" id="user_id" name="user_id">
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">비밀번호</label> <input type="password" class="form-control" id="password" name="password">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" onclick="login()">로그인</button>
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Signup Modal -->
	<div class="modal fade" id="signupModal" tabindex="-1" aria-labelledby="signupModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="signupModalLabel">회원가입</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<form:form modelAttribute="user" action="./users?${_csrf.parameterName}=${_csrf.token}">
					<div class="modal-body">
						<div class="mb-3">
							<label for="user_id" class="form-label">아이디</label> <input type="text" class="form-control" name="user_id">
						</div>
						<div class="mb-3">
							<label for="password" class="form-label">비밀번호</label> <input type="password" class="form-control" name="password">
						</div>
						<div class="mb-3">
							<label for="confirmPassword" class="form-label">비밀번호 확인</label> <input type="password" class="form-control" name="confirmPassword">
						</div>
						<div class="mb-3">
							<label for="nickname" class="form-label">닉네임</label> <input type="text" class="form-control" name="nickname">
						</div>
						<div class="mb-3">
							<label for="email" class="form-label">이메일</label> <input type="text" class="form-control" name="email">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">회원가입</button>
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<!-- Item Modal -->
	<div class="modal fade" id="itemModal" tabindex="-1" aria-labelledby="itemModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="itemModalLabel">상품 등록</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<form:form modelAttribute="item" action="./items?${_csrf.parameterName}=${_csrf.token}">
					<div class="modal-body">
						<div class="mb-3">
							<label for="url" class="form-label">URL</label> <input type="text" class="form-control" id="url" name="url">
						</div>
						<div class="mb-3">
							<label for="title" class="form-label">제목</label> <input type="text" class="form-control" id="title" name="title">
						</div>
						<div class="mb-3">
							<label for="content" class="form-label">내용</label>
							<textarea class="form-control" id="content" name="content" rows="3"></textarea>
						</div>
						<div class="mb-3">
							<label for="price" class="form-label">가격</label> <input type="number" class="form-control" id="price" name="price">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">등록</button>
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>