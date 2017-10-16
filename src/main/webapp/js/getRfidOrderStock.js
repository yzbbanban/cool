function getRfidOrderStock() {
	addCookie("isRfidPageLoading", 0, 2);
	$("#searchRfidStockData").click(function() {
		var rfidStockSelect_uid = $("#rfidStockSelect_uid").val();
		addCookie("rfidStockSelect_uid", rfidStockSelect_uid, 2);
		getRfidStockData(0, 10);
	});
};

function getRfidStockData(startPage, endPage) {
	var rfidStockSelect_uid = getCookie("rfidStockSelect_uid");
	$.ajax({
		url : "rfidOrder/getRfidOrderList.do",
		type : "post",
		data : {
			"uid" : rfidStockSelect_uid,
			"startTime" : "1991-05-16 00:00:00",
			"endTime" : "2080-11-18 00:00:00",
			"startPage" : startPage,
			"endPage" : endPage,
			"stockType" : 0 //在仓库
		},
		dataType : "json",
		success : function(result) {
			var rfidStockTb = $("#rfid_stock_tb");
			if (result.code == 10000) {
				getParseRfidStockData(result.result, startPage, endPage,
						rfidStockTb);
				if (getCookie("isRfidPageLoading") == 0
						|| getCookie("isRfidStockUid") != rfidStockSelect_uid) {
					setRfidStockOrderPaging(result.result.count);
					addCookie("isRfidStockUid", rfidStockSelect_uid, 2);
					addCookie("isRfidPageLoading", 1, 2);
				}

			} else {
				rfidStockTb.html("");
				alert(result.message);
			}
		},
		error : function() {
			setRfidStockOrderPaging(0);
			alert("此用户无RFID数据");
		}
	});
}
function getParseRfidStockData(result, startPage, endPage, rfidStockTb) {
	rfidStockTb.html("");
	var so = "";
	// console.log(result.rfidOrders);
	for (var i = 0; i < result.rfidOrders.length; i++) {
		var rfidOrder = result.rfidOrders[i];
		var idName = rfidOrder.idName;
		var rfidOrderCreateTime = rfidOrder.rfidOrderCreateTime;
		var stockType = rfidOrder.stockType;
		var stock = "";
		var nick = result.user.nick;
		var rfidOrderNum = rfidOrder.rfidOrderNum;
		var rfidUserName = rfidOrder.rfidUser.rfidUserName;
		var ti = getStockTimer(rfidOrderCreateTime);
		// <td>序号</td>
		// <td>吨桶ID号</td>
		// <td>时间</td>
		// <td>操作员</td>
		// <td>单号</td>
		// <td>停留时间</td>
		var stayTime = setStayTime(rfidOrderCreateTime);

		so = '<tr>' + '<td>' + (i + 1) + '</td>' + '<td>' + idName + '</td>'
				+ '<td>' + ti + '</td>' + '<td>' + nick + '</td>' + '<td>'
				+ rfidOrderNum + '</td>' + '<td>' + stayTime + '</td>'
				+ '</tr>';

		var $so = $(so);
		rfidStockTb.append($so);
	}
}
/**
 * 获取停留时间（天数）
 * 
 * @param rfidOrderCreateTime
 */
function setStayTime(rfidOrderCreateTime) {
	var d = new Date();
//	console.log("stayTime: "+(d - rfidOrderCreateTime)/ 1000 / 60 / 60);
	return parseInt(Math
			.abs(d - rfidOrderCreateTime)
			/ 1000 / 60 / 60 / 24);
}
/**
 * 格式化时间
 * 
 * @param rfidOrderCreateTime
 */
function getStockTimer(rfidOrderCreateTime) {
	var d = new Date(rfidOrderCreateTime);
	return d.getFullYear() + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日"
			+ d.getHours() + ":" + d.getMinutes()+":"+d.getSeconds();
}