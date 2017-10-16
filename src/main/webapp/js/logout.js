$(function(){
	$("#log_out").click(function() {
//		alert("logout");
		$(location).attr('href', '/login.html');
		delCookie("userId");
		delCookie("nick");
	});
});

