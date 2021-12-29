<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 상세페이지</title>
<link type="text/css" rel="stylesheet"
	href="resources/css/adMem_style.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>

<script type="text/javascript">
	$(function() {
		//메시지 출력 부분
		var msg = "${msg}";
		if (msg != "") {
			alert(msg);
		}
	});
</script>

</head>
<body>
	<div class="wrap">
		<section>
			<div class="content-admin">
				<div class="content-adSidebar">
					<jsp:include page="../layout/adSidebar.jsp" />
				</div>

				<div class="content">
					<div class="content-admem">
						<h1>회원 상세</h1>
						<table class="adDetail-main">
							<thead>
								<tr>
									<th>이름</th>
									<td>${memdto.m_name}</td>
								</tr>
								<tr>
									<th>가입일자</th>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
											value="${memdto.m_joindate}" /></td>
								</tr>
							</thead>
						</table>

						<table class="adDetail-sub">
							<thead>
								<tr>
									<th>아이디</th>
									<td>${memdto.m_id}</td>
								</tr>
								<tr>
									<th>생년월일</th>
									<td>${memdto.m_birth}</td>
								</tr>
								<tr>
									<th>연락처</th>
									<td>${memdto.m_phone}</td>
								</tr>
								<tr>
									<th>E-mail</th>
									<td>${memdto.m_email}</td>
								</tr>
								<tr>
									<th>보유 회원권</th>
									<td>---</td>
								</tr>
								<tr>
									<th>보유 포인트</th>
									<td>${memdto.m_point}</td>
								</tr>
							</thead>
						</table>
						<!-- 회원 수정 버튼 -->
						<div class="adDetail-btn">
							<button class="adbtn-upbtn"
								onclick="location.href='./adMemUpdateMove?m_id=${memdto.m_id}'">
								수정</button>
							<button class="adbtn-delbtn"
								onclick="location.href='./adMemDelAct?m_id=${memdto.m_id}'">
								삭제</button>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>