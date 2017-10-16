$(function() {
	$("#rfidOrderNum").hide();
	$("#rfidIdName").hide();
	// 查询条件
	$("#check_order").click(function() {
		var check_order = $("#check_order").is(":checked");
		if (check_order) {
			$("#rfidOrderNum").show();
			$("#order_Select").hide();
		} else {
			$("#rfidOrderNum").hide();
			$("#order_Select").show();
		}
	});
	$("#check_rfid_name").click(function() {
		var check_rfid_name = $("#check_rfid_name").is(":checked");
		if (check_rfid_name) {
			$("#rfidIdName").show();
		} else {
			$("#rfidIdName").hide();
		}
	});
	// 是否为第一次发送请求，
	addCookie("isRfidPageLoading", 0, 2);
	$("#searchRfidData").click(
			function() {

				// console.log("客户： "+rfidSelectText);

				var s_rfid_startTime = getCookie("rfid_select_startTime");
				var s_rfid_endTime = getCookie("rfid_select_endTime");

				var rfid_select_startTime = $("#startTime").val() + ":00";
				var rfid_select_endTime = $("#endTime").val() + ":00";
				// if(rfid_select_startTime=="开始时间" ||
				// rfid_select_endTime=="结束时间"){
				// alert('请选择时间');
				// }

				// 单号查询
				var check_order = $("#check_order").is(":checked");

				// 吨桶id查询
				var check_rfid_name = $("#check_rfid_name").is(":checked");

				// alert("ssssss: "+check_order);
				if (s_rfid_startTime != rfid_select_startTime
						|| s_rfid_endTime != rfid_select_endTime) {
					addCookie("rfidTimeChange", 1, 2);
				}

				addCookie("rfid_select_startTime", rfid_select_startTime, 2);
				addCookie("rfid_select_endTime", rfid_select_endTime, 2);

				var rfidSelectUid = $("#rfidSelect_uid").val();
				var rfidOrderNum = $("#rfidOrderNum").val();
				var rfidIdName = $("#rfidIdName").val();
				// var rfidSelect_Stock = $("#rfidSelect_Stock").val();
				// addCookie("rfidSelect_Stock", rfidSelect_Stock, 2);//
				// 保存入库出库类型
				var uidType = 0;// 0依据仓库、 1订单查询、 2吨桶id
				var uid = "";// 设备 uid
				var startPage = "0";// 开始第几条
				var endPage = "10";// 结束第几条

				if (rfidOrderNum != "" && check_order) {// 1订单查询
					uidType = 1;
					uid = rfidOrderNum;
				} else if (rfidIdName != "" && check_rfid_name) {// 2吨桶id
					uidType = 2;
					uid = rfidIdName;
				} else {
					uid = rfidSelectUid;
				}
				addCookie("rfid_uidType", uidType, 2);
				addCookie("rfid_select_uid", uid, 2);
				// alert(uid);

				// console.log(rfidIdName);
				addCookie("rfidIdName", rfidIdName, 2);
				getRfidData(0, 10);

			});
});

function getRfidData(startPage, endPage) {
	var rfid_select_uid = getCookie("rfid_select_uid");
	var rfid_select_startTime = getCookie("rfid_select_startTime");
	var rfid_select_endTime = getCookie("rfid_select_endTime");
	var uidType = getCookie("rfid_uidType");
	// var stockType = getCookie("rfidSelect_Stock");// 出入库
	console.log("rfid_select_uid: " + rfid_select_uid);
	$.ajax({
		url : "rfidOrder/getRfidOrderList.do",
		type : "post",
		data : {
			"uid" : rfid_select_uid,
			"startTime" : rfid_select_startTime,
			"endTime" : rfid_select_endTime,
			"startPage" : startPage,
			"endPage" : endPage,
			"type" : uidType,
			"stockType" : 3
		},
		dataType : "json",
		success : function(result) {
			var rfidTb = $("#rfid_tb");
			if (result.code == 10000) {
				getParseRfidData(result.result, startPage, endPage, rfidTb);
				if (getCookie("isRfidPageLoading") == 0
						|| getCookie("isRfidUid") != rfid_select_uid
						|| getCookie("rfidTimeChange") == 1) {
					// alert(result.result.count);
					setRfidOrderPaging(result.result.count);
					// getRfidWithPage(result.result.count);

					addCookie("isRfidUid", rfid_select_uid, 2);
					addCookie("isRfidPageLoading", 1, 2);
					addCookie("rfidTimeChange", 0, 2);
					addCookie("rfid_uidType", 0, 2);
					// addCookie("rfidSelect_Stock", 0, 2);// 保存入库出库类型
				}

			} else {
				rfidTb.html("");
				alert(result.message);
			}
		},
		error : function() {
			setRfidOrderPaging(0);
			alert("此用户无RFID数据");
		}
	});
}

function getParseRfidData(result, startPage, endPage, rfidTb) {
	rfidTb.html("");
	var so = "";
	var ro;
	// console.log(result.rfidOrders);
	for (var i = 0; i < result.rfidOrders.length; i++) {
		var rfidOrder = result.rfidOrders[i];
		var idName = rfidOrder.idName;
		var rfidOrderCreateTime = rfidOrder.rfidOrderCreateTime;
		var stockType = rfidOrder.stockType;
		var stock = "";
		if (stockType == 0) {
			stock = "入库";
		} else {
			stock = "出库";
		}
		var nick = result.user.nick;
		var rfidOrderNum = rfidOrder.rfidOrderNum;
		var rfidUserName = rfidOrder.rfidUser.rfidUserName;
		var ti = getTimer(rfidOrderCreateTime);
		// <th>序号</th>
		// <th>吨桶ID号</th>
		// <th>状态</th>
		// <th>时间</th>
		// <th>客户</th>
		// <th>操作员</th>
		// <th>单号</th>
		so = '<tr>' + '<td>' + (i + 1) + '</td>' + '<td>' + idName + '</td>'
				+ '<td>' + stock + '</td>' + '<td>' + ti + '</td>' + '<td>'
				+ rfidUserName + '</td>' + '<td>' + nick + '</td>' + '<td>'
				+ rfidOrderNum + '</td>' + '</tr>';

		var $so = $(so);
		rfidTb.append($so);
	}
}

/**
 * 格式化时间
 * 
 * @param rfidOrderCreateTime
 */
function getTimer(rfidOrderCreateTime) {
	console.log("111");
	var d = new Date(rfidOrderCreateTime);
	return d.getFullYear() + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日"
			+ d.getHours() + ":" + d.getMinutes()+":"+d.getSeconds();
}