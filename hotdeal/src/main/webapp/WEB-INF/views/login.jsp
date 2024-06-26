<html lang="en" xmlns:th="http://www.thymeleaf.org">

<th:block th:fragment="setLogin(login)">
	<body>
		<div class="member_login">
			<form th:action="@{/auth/loginProc}" th:method="POST">
				<div class="member_login_input">
					<input type="text" name="username" placeholder="아이디">
				</div>

				<div class="member_login_input">
					<input type="password" name="password" placeholder="비밀번호">
				</div>

				<div class="member_login_btn">

					<input type="submit" class="btn btn-secondary" id="btn-login" value="로그인"> <input type="button" class="btn btn-secondary" value="회원가입" onclick="location.href='/member/join'">

				</div>

				<div class="find_password">
					<a href="/forgot-password">아이디 또는 비밀번호를 잊으셨나요?</a>
				</div>

				<div class="login_api">
					<a href="https://kauth.kakao.com/oauth/authorize?client_id=d860d38c992ca8bf5f07dcc3fd5122b9&redirect_uri=http://localhost:9090/member/auth/kakao/callback&response_type=code"><img src="/image/kakao_login_button.png"></a>
				</div>

				<div class="login_api">
					<a href="/oauth2/authorization/google"><img src="/image/google_login_button.png"></a>
				</div>

			</form>
		</div>
	</body>
</th:block>