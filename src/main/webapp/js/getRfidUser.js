$(function() {
	var userId = getCookie("userId");
	if (userId != null) {
		$.ajax({
			url : "rfidUser/getRfidUserList.do",
			type : "post",
			data : {
				"id":userId
			},
			dataType : "json",
			success : function(result) {
				if (result.code == 10000) {
					// alert(result.result[0]);
					var rfidSelectUid = $("#rfidSelect_uid");
					var rfidStockSelect_uid=$("#rfidStockSelect_uid");
					rfidSelectUid.html("");
					rfidStockSelect_uid.html("");
					var ss = "";
					for (var i = 0; i < result.result.length; i++) {
						var rfidObj = result.result[i];
//						console.log("num: "+rfidObj.);
						ss = "<option value='" + rfidObj.rfidUserId + "'>"
								+ rfidObj.rfidUserName + "</option>";
						var $ss = $(ss);
						rfidSelectUid.append($ss);
//						rfidStockSelect_uid.append($ss);
					}
					for (var i = 0; i < result.result.length; i++) {
						var rfidObj = result.result[i];
//						console.log("num: "+rfidObj.);
						ss = "<option value='" + rfidObj.rfidUserId + "'>"
								+ rfidObj.rfidUserName + "</option>";
						var $ss = $(ss);
						rfidStockSelect_uid.append($ss);
					}
				} else {
					alert(result.message);
				}
			},
			error : function() {
				alert("此用户无RFID数据");
			}
		});
	} else {
		alert("用户信息加载失败，请重新登录");
		$(location).attr('href', '/login.html');
	}
});
