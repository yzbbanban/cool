$(function() {

	// 获取userId
	var userId = getCookie("userId");

	var company = {
			"id": "0",
			"name":"锐俤（南京）",
			"email":"brander@rititech.com.cn",
			"address":"创延路",
			"tel":"123456789"
	     };
	alert(userId + ", company: " + JSON.stringify(company));
	$.ajax({
		url : "user/updateUserCompany.do",
		type : "post",
		data : {
			"userId":userId,
			"id": "0",
			"name":"锐俤（南京）",
			"email":"brander@rititech.com.cn",
			"address":"创延路",
			"tel":"123456789"
		},
		dateType : "json",
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
			alert("登录错误");
		}
	})

});
