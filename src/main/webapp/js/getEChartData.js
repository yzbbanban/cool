function getEChartData() {
	var select_uid = $("#select_uid").val();
	var select_startTime = $("#startTime").val() + ":00";
	var select_endTime = $("#endTime").val() + ":00";
	console.log(select_startTime);
	console.log(select_endTime);
//	alert("sss");
	$.ajax({
		type : "post",
		url : "temp/queryTempChart.do",
		async : true,
		data : {
			uid : select_uid,
			startTime : select_startTime,
			endTime : select_endTime
		},
		dataType : "json",
		timeout : 20000,
		success : function(data) {
			getEchartsData(data);
		},
		error:function(){
			
		}
	});
}

function getEchartsData(data) {
	var result = data.result;
	console.log(result);
	// var u=$("#select_uid");
	// var res="<select id='select_uid' class='select'>";
	var temp = new Array();
	var humi = new Array();
	var dt = new Array();
	for (var i = 0; i < data.result.length; i++) {
		var hum = data.result[i].hum;
		var temperature = data.result[i].temperature;
		var DateTime = data.result[i].DateTime;
		console.log(hum);
		var select_startTime = $("#startTime").val() + ":00";
		var select_endTime = $("#endTime").val() + ":00";
		temp.push(temperature);
		humi.push(hum);
		dt.push(DateTime);
	}
//	alert(select_startTime+","+select_endTime);
	getEChart(temp, humi, dt, select_startTime, select_endTime);
//	$("#chart").hide();
//	$("#my_chart").show();

}