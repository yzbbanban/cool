function getTempWithPage(page) {
	//分页
	function createDemo(name) {
		var container = $('#pagination-' + name);
		var sources = function() {
			var result = [];

			for (var i = 1; i < page; i++) {
				result.push(i);
			}

			return result;
		}();

		var options = {
			dataSource : sources,
			className : 'paginationjs-theme-blue',
			callback : function(response, pagination) {
				$.each(response, function(index, item) {
					page = item;
					if (index == 0) {
//						alert(index + "," + item);
						getTemData(item-1, 10);
					}
				});
			}

		};

		// $.pagination(container, options);

		container.addHook('beforeInit', function() {
			// window.console && console.log('beforeInit...');
		});
		container.pagination(options);

		container.addHook('beforePageOnClick', function() {
			// window.console && console.log('beforePageOnClick...');
			// return false
		});

		return container;
	}

	createDemo('demo1');

}
