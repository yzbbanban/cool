// 申请加入公司
$(function() {
	// 获取userId
	var userId = getCookie("userId");
	$("#apply_company_btn").click(function() {
		if (userId != null) {
			var companyName = $("#company_text").val();
			var messageDetial = $("#regist_company_reason").val();
			// alert("sss");
			$.ajax({
				url : "message/sendMessage.do",
				type : "post",
				data : {
					"userId" : userId,
					"companyName" : companyName,
					"messageDetial" : messageDetial
				},
				dataType : "json",
				success : function(result) {
//					alert("sss");
					// 响应成功
					if (result.code == "10000") {
						alert(result.message);
						$("#apply_company_close").click();
					} else {
						alert(result.message);
						// 弹窗消失
						$("#apply_company_close").click();
					}
				},
				error : function() {
					alert("用户信息加载失败，请重试");
					// 弹窗消失
					$("#apply_company_close").click();
				}
			});
		}
	});

});

