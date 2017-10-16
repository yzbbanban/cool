$(function() {

		$("#orderSearchUser").hide();
		$("#userSearchOrder").hide();
		$("#search_history").click(function() {
			//按钮
			$("#search_history").attr("class", "btn btn-danger");
			$("#search_user").attr("class", "btn btn-info");
			$("#search_order").attr("class", "btn btn-info");
			//界面
			$("#historyOrderSearch").show();
			$("#orderSearchUser").hide();
			$("#userSearchOrder").hide();
		});
		$("#search_user").click(function() {
			$("#search_history").attr("class", "btn btn-info");
			$("#search_user").attr("class", "btn btn-danger");
			$("#search_order").attr("class", "btn btn-info");

			$("#historyOrderSearch").hide();
			$("#orderSearchUser").show();
			$("#userSearchOrder").hide();
			getRfidOrderNewData();
		});
		$("#search_order").click(function() {
			$("#search_history").attr("class", "btn btn-info");
			$("#search_user").attr("class", "btn btn-info");
			$("#search_order").attr("class", "btn btn-danger");
			$("#historyOrderSearch").hide();
			$("#orderSearchUser").hide();
			$("#userSearchOrder").show();
			getRfidOrderStock();
		});
	});