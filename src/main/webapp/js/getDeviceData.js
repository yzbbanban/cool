$(document).ready(function() {
		addCookie("isPageLoading", 0, 2);
		
		$("#searchTemData").click(function() {	
			$("#chart").hide();
			$("#my_chart").show();
			$("#my_page").show();
										var s_startTime = getCookie("select_startTime");
										var s_endTime = getCookie("select_endTime");
										
										var select_uid = $("#select_uid").val();
										var select_startTime = $("#startTime")
												.val()
												+ ":00";
										var select_endTime = $("#endTime")
												.val()
												+ ":00";
										// console.log(select_startTime);
										// console.log(select_endTime);
										if(s_startTime!=select_startTime || s_endTime!=select_endTime){
											addCookie("timeChange", 1, 2);
										}
										addCookie("select_uid", select_uid, 2);
										addCookie("select_startTime",
												select_startTime, 2);
										addCookie("select_endTime",
												select_endTime, 2);
										// 获取设备基本信息

										$.ajax({
													type : "post",
													url : "device/queryDevice.do",
													data : {
														"uid" : select_uid,
													},
													dataType : "json",
													success : function(result) {
														if (result.code == "10000") {
															var $tr = $("#device_params");
															$tr.html('<th>'+ result.result.Uid+ '</th>'
																	+ '<th>'+ result.result.Company+ '</th>'
																	+ '<th>'+ result.result.GoodsName+ '</th>'
																	+ '<th>'+ result.result.Interval+ '</th>'
																	+ '<th>'+ result.result.MinTemperature+ '°C~'+ result.result.MaxTemperature+ '°C</th>'
																	+ '<th>'+ result.result.MinHum+ 'RH%~'+ result.result.MaxHum+ 'RH%</th>'
																	+ '<th>'+ (result.result.Model = 1 ? "循环": "一次")+ '</th>'
																	+ '<th>'+ (result.result.ReadStop = 0 ? "读停启用": "未启用")+ '</th>'
																	+ '<th>'+ (result.result.TagType = 1 ? "NFC":"蓝牙")+ '</th>');
															// 获取设备成功后，获取温度数据
															// 第一次发送数据，设为首页为1~10
															getTemData(1, 10);
														
														} else {
															alert(result.message);
														}

													},
													error : function() {
														alert(result.message);
													}
												});

									});
				});
function getTemData(startPage, endPage) {
//	alert(startPage+","+endPage);
	var select_uid = getCookie("select_uid");
	var select_startTime = getCookie("select_startTime");
	var select_endTime = getCookie("select_endTime");
//	 alert(select_uid);
	$.ajax({
		type : "post",
		url : "temp/queryTempByPage.do",
		data : {
			"uid" : select_uid,
			"startTime" : select_startTime,
			"endTime" : select_endTime,
			"startPage" : startPage,
			"endPage" : endPage
		},
		dataType : "json",
		success : function(data) {
			//显示表格
			getParseTempData(data,startPage,endPage);
//			addCookie("page", data.result.count, 2);
			if(getCookie("isPageLoading")==0 || getCookie("isUid")!=select_uid ||getCookie("timeChange")==1){
//				alert("ban");
				getTempWithPage(data.result.count);
				addCookie("isUid", select_uid, 2);
				addCookie("isPageLoading", 1, 2);
				addCookie("timeChange", 0, 2);
			}

		},
		error : function() {
			alert("没有数据");
		}
	});
}
function getParseTempData(data,startPage,endPage) {
	// 获取名为code
	var result = data.result.temperatures;
	console.log(result.length);

	var tempTable = $("#temp_tb");
	tempTable.empty();
	var tb="";
	// 必须清空表格数据
	for (var i = 0; i < result.length; i++) {
		var dateTime = result[i].DateTime;
		var temperature = result[i].Temperature;
		var stauts = result[i].Status;
		var hum = result[i].Hum;
		var humStatus = result[i].HumStatus;
		// <tr>
		// <th>序号</th>>
		// <th>读取温度</th>
		// <th>温度异常</th>
		// <th>读取湿度</th>
		// <th>湿度异常</th>
		// <th>记录时间</th>
		// </tr>
		var resultTempStatus = "";
		var resultHumStatus = "";
		if (stauts == 0) {
			resultTempStatus = "正常";
		} else {
			resultTempStatus = "异常";
		}
		if (stauts == 0) {
			resultHumStatus = "正常";
		} else {
			resultHumStatus = "异常";
		}
		tb+='<tr>'+
		'<th>'+(startPage+i)+'</th>>'+
		'<th>'+temperature+'</th>'+
		'<th>'+resultTempStatus+'</th>'+
		'<th>'+hum+'</th>'+
		'<th>'+resultHumStatus+'</th>'+
		'<th>'+dateTime+'</th>'+
		' </tr>';
		
	}
	tempTable.html(tb);
	
}