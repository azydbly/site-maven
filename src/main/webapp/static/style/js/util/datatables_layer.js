/**
 * 从URL连接中获取key为name的value
 * @param {Object} name
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = location.search.substr(1).match(reg);
	if(r != null)
		return unescape(r[2]);
	return null;
}


/**
 * 添加
 */
function add(title, url,w,h) {
	var index = layer.open({
		type: 2,
		title: title,
		anim : 1, //0-6的动画形式，-1不开启
		shadeClose: false,
		shade: false, // 允许进行下面的幢楼进行操作
		maxmin: true, //开启最大化最小化按钮
		area: [w, h],
		content: [url,'no']
	});
}

/**
 * 编辑-查看 
 */
function edit_show(title, url, id,w,h) {
	var index = layer.open({
		type: 2,
		title: title,
		anim : 1, //0-6的动画形式，-1不开启
		shadeClose: false,
		maxmin: true, //开启最大化最小化按钮
		shade: false, // 允许进行下面的幢楼进行操作
		area: [w, h],
		content: [url + '?id=' + id,'no']
	});
}

/**
 * 添加-全屏 
 */
function add_full(title, url) {
	var index = layer.open({
		type: 2,
		title: title,
		anim : 1, //0-6的动画形式，-1不开启
		content: url
	});
	layer.full(index);
}

/**
 * 编辑-查看-全屏 
 */
function edit_show_full(title, url, id) {
	var index = layer.open({
		type: 2,
		title: title,
		anim : 1, //0-6的动画形式，-1不开启
		content: [url + '?id=' + id]
	});
	layer.full(index);
}

/**
 * 改变数据状态
 */
function changeStatus(title,name, url, id,state,sureFn, cancelFn) {
	showConfirmMessage('确认要' + title + '"' + name + '"吗?', function() {
		$.ajax({
			type: "post",
			url: url,
			data: {
				id: id,
				state: state
			},
			success: function(data) {
				if(data.retcode == 0) {
					showFailMessage(data.retmsg);
				}else{
                    showSuccessMessage(data.retmsg);
                    var index =layer.getFrameIndex(window.name); //先得到当前iframe层的索引,隐藏layer层和shade
                    $('#layui-layer' + index).css({'display':'none'});
                    $('#layui-layer-shade' + index).css({'display':'none'});
                    reloadTable(); //再刷新DT
				}
			},
            error: function(data){
                showFailMessage("系统异常");
            }
		});
	});
}


/**
 * 删除单条数据
 * @param {Object} idList 要删除的id数组
 * @param {Object} url 请求URL
 * @param {Object} successFn 成功回调函数
 */
function del(idList, url,name, successFn) {
	if(!idList.length) {
        showFailMessage('请先选择要删除的数据');
		return false;
	}
	showConfirmMessage('确认要删除"' + name + '"吗?', function() {
		$.ajax({
			type: "post",
			url: url,
			data: {
				idlist: idList
			},
            success: function(data) {
                if(data.retcode == 0) {
                    showFailMessage(data.retmsg);
                }else{
                    showSuccessMessage(data.retmsg);
                    var index =layer.getFrameIndex(window.name); //先得到当前iframe层的索引,隐藏layer层和shade
                    $('#layui-layer' + index).css({'display':'none'});
                    $('#layui-layer-shade' + index).css({'display':'none'});
                    reloadTable(); //再刷新DT
                }
            },
            error: function(data){
                showFailMessage("系统异常");
            }
		});
	});
}


/**
 * 删除全部数据
 * @param idList
 * @param url
 * @param name
 * @param successFn
 * @returns {Boolean}
 */
function delAll(idList, url, successFn) {
	if(!idList.length) {
		showFailMessage('请先选择要删除的数据');
		return false;
	}
	showConfirmMessage('确认要删除选择的数据吗?', function() {
		$.ajax({
			type: "post",
			url: url,
			data: {
				idlist: idList
			},
            success: function(data) {
                if(data.retcode == 0) {
                    showFailMessage(data.retmsg);
                }else{
                    showSuccessMessage(data.retmsg);
                    var index =layer.getFrameIndex(window.name); //先得到当前iframe层的索引,隐藏layer层和shade
                    $('#layui-layer' + index).css({'display':'none'});
                    $('#layui-layer-shade' + index).css({'display':'none'});
                    reloadTable(); //再刷新DT
                }
            },
            error: function(data){
                showFailMessage("系统异常");
            }
		});
	});
}



/**
 * 判断指定函数是否存在
 * @param {Object} funcName函数名
 */
function isExitsFunction(funcName) {
	try {
		if(typeof(funcName) == "function") {
			return true;
		}
	} catch(e) {}
	return false;
}

/**
 * 是否存在指定变量
 * @param {Object} variableName 变量名
 */
function isExitsVariable(variableName) {
	try {
		if(typeof(variableName) == "undefined") {
			return false;
		} else {
			return true;
		}
	} catch(e) {}
	return false;
}


/**
 * 显示右上角成功提示消息
 * @param {Object} message 消息
 * @param {Object} successFn 打开时回调
 * @param {Object} endFn 销毁时回调
 */
function showSuccessMessage(message, successFn, endFn) {
	successFn = isExitsFunction(successFn) ? successFn : function() {};
	endFn = isExitsFunction(endFn) ? endFn : function() {};
	layer.alert(message, {
		icon: 6,
		title: '成功',
		time: 2000,
		shade: 0,
		btn: 0,
		succss:successFn,
		end: endFn,
		offset: ['40px', ($(window).width() - 300) + 'px']
	});
}

/**
 * 显示右上角失败提示消息
 * @param {Object} message 消息
 * @param {Object} successFn 打开时回调
 * @param {Object} endFn 销毁时回调
 */
function showFailMessage(message, successFn, endFn) {
	successFn = isExitsFunction(successFn) ? successFn : function() {};
	endFn = isExitsFunction(endFn) ? endFn : function() {};
	layer.alert(message, {
		icon: 5,
		title: '失败',
		time: 2000,
		shade: 0,
		btn: 0,
		succss:successFn,
		end: endFn,
		offset: ['40px', ($(window).width() - 300) + 'px']
	});
}

/**
 * 显示右上角询问提示消息
 * @param {Object} message 询问消息
 * @param {Object} sureFn 确定按钮回调
 * @param {Object} cancelFn 取消按钮回调
 */
function showConfirmMessage(message, sureFn, cancelFn) {
	sureFn = isExitsFunction(sureFn) ? sureFn : function() {};
	cancelFn = isExitsFunction(cancelFn) ? cancelFn : function() {};
	layer.confirm(message, {
		btn: ['确定', '取消'],
		icon: 3,
		title: '信息',
		//shade: 0, //允许下面的窗口进行操作
		shift: 6,
		offset: ['40px', ($(window).width() - 300) + 'px']
	}, sureFn, cancelFn);
}