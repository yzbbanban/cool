$(function() {

	// 获取userId
	var userId = getCookie("userId");
	if (userId != null ) {
		$.ajax({
			url : "user/updateUserCompany.do",
			type : "post",
			data : {
				"userId" : userId,
			},
			dataType : "json",
			success : function(result) {
				// 获取返回结果，判断是否为manager
				var isManager = 1;
				if (isManager == 1) {
					// 管理者，显示相应界面

				} else {
					// 用户,显示相应界面

				}

			},
			error : function() {
				//alert("登录错误");
			}
		});
	} else {
		alert("用户信息加载失败，请重新登录");
		$(location).attr('href', '/cool/login.html');
	}

});
