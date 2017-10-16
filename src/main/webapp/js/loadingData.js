$(function() {
	//获取用户的标签uid
	var tagUserId = getCookie("tagUserId");
//	alert(tagUserId);
	if (tagUserId == null) {
		tagUserId = getCookie("userId");
	}
	if (tagUserId != null) {
		$.ajax({
			type : "post",
			url : "tagList/getTagList.do",
			async : true,
			data : {
				"userId" : tagUserId,
			},
			dataType : "json",
			timeout : 30000,
			success : function(data) {
				if (data.code == "10000") {
//					alert(data.message);
					getParseDeviceData(data);
				} else {
					alert(data.message);
				}
			}
		});
	} else {
		alert("请登录");
		$(location).attr('href', '/login.html');
	}
});
function getParseDeviceData(data) {
	var result = data.result;
	console.log(result);
	var u = $("#select_uid");
	var res = "<select id='select_uid' class='select'>";
	for (var i = 0; i < data.result.length; i++) {
		uid = data.result[i].uid;
		console.log(uid);
		res += "<option>" + uid + "</option>";
	}
	u.html(res + "</select>");
}
