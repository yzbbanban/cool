function setRfidOrderPaging(totalSize){
//	alert("s: "+totalSize);
	var totalPage=Math.ceil(totalSize/10);
	$("#page").paging({
		pageNo:1,
		totalPage: totalPage,
		totalSize: totalSize,
		callback: function(num) {
			console.log((num*10)+'==='+(num*10+10));
			getRfidData((num-1)*10, 10);
		}
	});
}

function setRfidStockOrderPaging(totalSize){
//	alert("s: "+totalSize);
	var totalPage=Math.ceil(totalSize/10);
	$("#pageStock").paging({
		pageNo:1,
		totalPage: totalPage,
		totalSize: totalSize,
		callback: function(num) {
			console.log((num*10)+'==='+(num*10+10));
			getRfidStockData((num-1)*10, 10);
		}
	});
}

function setRfidNewOrderPaging(totalSize){
//	alert("s: "+totalSize);
	var totalPage=Math.ceil(totalSize/10);
	$("#pageNew").paging({
		pageNo:1,
		totalPage: totalPage,
		totalSize: totalSize,
		callback: function(num) {
			console.log((num*10)+'==='+(num*10+10));
			getRfidStockData((num-1)*10, 10);
		}
	});
}