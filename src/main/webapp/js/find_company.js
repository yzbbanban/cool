/*1.获取文本内容  只要有内容 展示搜索框就会出现
				1.获取文本框内容
				2.敲击键盘的时候 可能会有内容*/
$(function() {
	var oText = document.getElementById('company_text');
	oSea = document.querySelector('.company_search');
	oUl = document.getElementById('company_search_ul');
	oText.onkeyup = function() {
		oSea.style.display = oText.value ? 'block' : 'none';

		// console.log(oText.value);
		findCompany(oText.value);

	}; // 键盘抬起之后触发事件
});

function findCompany(companyName) {
	console.log("findCompany: " + companyName);
	$.ajax({
		url : "company/findCompany.do",
		type : "post",
		data : {
			"companyName" : companyName
		},
		dataType : "json",
		success : function(result) {
			if (result.code = "10000") {
				console.log(result.message);
				console.log(result.result.length);
				var ul = $("#company_search_ul");
				ul.html("");
				var sli = "";
				for (var i = 0; i < result.result.length; i++) {
					var name = result.result[i].name;

					sli = "<li class='search_li'>" + name + "</li>";
					sli = $(sli);
					sli.data('companyName', name);
					ul.append(sli);
				}
			} else {
				alert(result.message);
			}
		},
		error : function() {
			alert("用户信息加载失败，请重试");
		}
	});
}

$(function() {
	$("#company_search_ul").on("click", ".search_li", function() {
		var li = $(this);
		$("#company_text").val(li.data('companyName'));
		$("#company_search_ul").html("");
	});

});
