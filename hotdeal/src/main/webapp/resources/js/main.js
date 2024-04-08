function login() {
    var user_id = $("#user_id").val();
    var password = $("#password").val();

    $.ajax({
        type: "get",
        url: "./users/login",
        contentType: "application/json; charset=UTF-8",
		dataType : 'text',
        data: { "user_id": user_id, "password": password },
        success: function(response) {
            // 로그인 성공 시 처리
            console.log("로그인 성공");
            alert("로그인에 성공했습니다.");
            window.location.href = "/hotdeal/main";
        },
        error: function(xhr, status, error) {
            // 로그인 실패 시 처리
            console.error("로그인 실패: " + error);
            alert("아이디 또는 비밀번호가 잘못되었습니다."); // 에러 메시지 알림창 띄우기
            
            // 입력된 인풋 값 초기화
            $("#user_id").val("");
            $("#password").val("");
        }
    });
}

$(document).ready(function() {
    // 페이지가 로드될 때 아이템 목록을 가져오는 함수 호출
    loadItems();
});

function loadItems() {
    $.ajax({
        type: "GET",
        url: "./items",
        dataType: "json",
        success: function(response) {
            // 서버로부터 받은 응답을 처리하는 함수 호출
            displayItems(response);
        },
        error: function(xhr, status, error) {
            console.error("Failed to load items: " + error);
        }
    });
}

function displayItems(items) {
    // 받은 아이템 목록을 순회하면서 각 아이템을 표시
    items.forEach(function(item) {
        // 아이템을 표시할 HTML 코드 생성
        var itemHtml = 
        `
            <div class="col-6 d-flex px-5">
                <div class="col-3">
                    <div>${item.id}</div>
                </div>
                <div class="col-9">
                    <div>${item.title}</div>
                    <div>${item.url}</div>
                    <div>${item.price}원</div>
                    <div class="d-flex justify-content-end">
                        <div class="col-auto">
                            <button class="btn btn-primary">찜</button>
                        </div>
                        <div class="col-auto">
                            <button class="btn btn-primary">댓</button>
                        </div>
                        <div class="col-auto">
                            <button class="btn btn-primary">신고</button>
                        </div>
                    </div>
                </div>
            </div>
        `;

        // 아이템을 표시할 HTML 요소에 추가
        $("#itemContainer").append(itemHtml);
    });
}