//设置用户所属的公司
$(function() {
	// 获取userId
	var userId = getCookie("userId");
	if (userId != null) {
		$("#regist_company_btn").click(function() {
			console.log("banban");
			var name = $("#regist_company_name").val();
			var email = $("#regist_company_email").val();
			var address = $("#regist_company_address").val();
			var tel = $("#regist_company_tel").val();

			$.ajax({
				url : "company/addCompany.do",
				type : "post",
				data : {
					"userId" : userId,
					"id" : "0",
					"name" : name,
					"email" : email,
					"address" : address,
					"tel" : tel
				},
				dataType : "json",
				success : function(result) {
					if (result.code == "10000") {
						alert(result.message);
						$("#regist_company_close").click();
						window.location.reload();
					}
				},
				error : function() {
					alert("创建失败，请重试");
					$("#regist_company_close").click();
				}
			});
		});
	}

});
// 在setting界面加载用户信息
$(function() {
	// 查询公司信息并记录
	var userId = getCookie("userId");
	var nick = getCookie("nick");
	if (userId != null && nick != null) {
		
		$.ajax({
			url : "company/getCompany.do",
			type : "post",
			data : {
				"userId" : userId
			},
			dataType : "json",
			success : function(result) {
				if (result.code == "10000") {
					if (result.result!= null) {
						// 显示公司信息
						$("#setting_user_name").text(nick);
						$("#company_name").text(result.result.name);
						$("#company_email").text(result.result.email);
						$("#company_address").text(result.result.address);
						$("#company_tel").text(result.result.tel);
						// 创建公司按钮消失
						$("#create_company_button").hide();
						// 申请加入公司按钮消失
						$("#apply_company_button").hide();
					}else{
						$("#log_off_company_button").hide();
						$("#company_detail").hide();
					}

				} else {
					alert(result.message);
					// 弹窗消失
				}
			},
			error : function() {
				alert("用户信息加载失败，请重试");
			}

		})
	} else {
		alert("用户信息加载失败，请重新登录");
		$(".btn-default").click();
		$(location).attr('href', '/login.html');
	}

})
// 取消绑定用户所在公司，需向管理员提出申请
$(function() {
	// 获取userId
	var userId = getCookie("userId");
	if (userId != null) {
		$("#log_off_company_btn").click(function() {

			$.ajax({
				url : "user/logOffUserCompany.do",
				type : "post",
				data : {
					"userId" : userId,
				},
				dataType : "json",
				success : function(result) {

					if (result.code == "10000") {
						alert("10000" + result.message);
						$("#log_off_company_close").click();
					} else {
						alert(result.message);
						$("#log_off_company_close").click();
						// console.log("sss")
					}
				},
				error : function() {
					alert("用户信息加载失败，请重试");
					$("#log_off_company_close").click();
				}
			})
		})
	}

});
