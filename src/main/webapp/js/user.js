$(function() {
	// 登录
	$('#login').click(loginAction);
	$('#count').blur(checkName);
	$('#password').blur(checkPassword);

	// 注册
	$('#regist').click(registAction);
	$('#regist_username').blur(checkRegistName);
	$('#regist_password').blur(checkRegistPassword);
	$('#final_password').blur(checkConfirm);
});

function loginAction() {
	// 登录
	var name = $("#count").val();
	var password = $("#password").val();
	console.log(name + "," + password);
	$.ajax({
		url : "user/login.do",
		type : "post",
		async : true,
		data : {
			"name" : name,
			"password" : password
		},
		dataType : "json",
		success : function(result) {
			// console.log(result.result.id);
			// alert(result.message);
			if (result.code == "10000") {
				// 保存cookies
				// alert(result.result.nick);
				addCookie("userId", result.result.id, 2);
				addCookie("nick", result.result.nick, 2);
				addCookie("companyId", result.result.companyId, 2);
//				alert(result.result.userLevel);
				addCookie("level", result.result.userLevel, 2);
				// 进如主页
				$(location).attr('href', '/home.html');

			} else {
				alert(result.message);
			}
		},
		error : function() {
		}
	});
}

function registAction() {
	//点击后不可再次点击
	$("#regist").attr("disabled", true); 
	// 注册
	var name = $("#regist_username").val();
	var nick = $("#nick").val();
	var password = $("#final_password").val();
	console.log("sss");
	// alert(name + "," +nick+","+ password);
	$.ajax({
		url : "user/regist.do",
		type : "post",
		async : true,
		data : {
			"name" : name,
			"nick" : nick,
			"password" : password
		},
		dataType : "json",
		success : function(result) {
			// alert(result);
			if (result.code == "10000") {
				// 退回登录界面
				alert(result.message);
				$("#regist").attr("disabled", false); 
				$(location).attr('href', '/login.html');
			} else {
				alert(result.message);
			}
		},
		error : function() {
		}
	});
}

function checkName() {
	var name = $('#count').val();
	var rule = /^\w{4,10}$/;
	if (!rule.test(name)) {
		$('#count').next().html('4~10个字符');
		return false;
	}
	$('#count').next().empty();
	return true;
}

function checkPassword() {
	var password = $('#password').val();
	var rule = /^\w{4,10}$/;
	if (!rule.test(password)) {
		$('#password').next().html('4~10个字符');
		return false;
	}
	$('#password').next().empty();
	return true;
}

function checkConfirm() {
	var pwd2 = $('#final_password').val();
	var pwd = $('#regist_password').val();
	// pwd 如果是空值表示 false, 非空则是true
	if (pwd && pwd == pwd2) {
		$('#final_password').next().hide();
		return true;
	}
	$('#final_password').next().show().find('span').html('确认密码不一致');
	return false;
}

function checkRegistPassword() {
	var pwd = $('#regist_password').val().trim();
	var rule = /^\w{4,10}$/;
	if (rule.test(pwd)) {
		$('#regist_password').next().hide();
		return true;
	}
	$('#regist_password').next().show().find('span').html('4~10个字符');
	return false;
}

function checkRegistName() {
	var name = $('#regist_username').val().trim();
	var rule = /^\w{4,10}$/;
	if (rule.test(name)) {
		$('#regist_username').next().hide();
		return true;
	}
	$('#regist_username').next().show().find('span').html('4~10字符');
	return false;
}
