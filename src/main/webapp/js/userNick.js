$(function() {
	var nick = getCookie("nick");
//	alert(nick);
	if(nick==null){
		alert("用户信息加载失败，请重新登录");
		$(location).attr('href', '/cool/login.html');
	}else{
		$("#user_nick_name").text(nick);
	}
	
});
