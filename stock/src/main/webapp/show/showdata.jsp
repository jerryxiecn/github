<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	$(function() {
		$('#admin_data_datagrid').datagrid({
			url : '/stock/datagrid',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'text',
			sortOrder : 'asc',
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : false,
			frozenColumns : [ [ {
				title : '编号',
				field : 'id',
				width : 150,
				sortable : false,
				checkbox : true
			}, {
				title : '日期',
				field : 'updatadate',
				width : 150,
				formatter: function (value, rec, index) {
			        if (value == undefined) {
			            return "";
			        }
			        /*json格式时间转js时间格式*/
                    var unixTimestamp = new Date(value);  
                    return unixTimestamp.toLocaleString();  

			    },
			} ] ],
			columns : [ [ {
				title : '指数',
				field : 'shindex',
				width : 80,

			}, {
				title : '资金',
				field : 'money',
				width : 80,

			}, {
				title : '备注',
				field : 'remind',
				width : 300,

			}, 
			{
				field : 'action',
				title : '动作',
				width : 100,
				formatter : function(value, row, index) {

					if (row.id == '0') {
						return '系统角色';
					} else {
						return formatString('<img onclick="admin_sjgl_editFun(\'{0}\');" src="{1}"/>&nbsp;<img onclick="admin_sjgl_deleteFun(\'{2}\');" src="{3}"/>', row.id, 'style/images/extjs_icons/pencil.png', row.id, 'style/images/extjs_icons/cancel.png');
					}
				}
			} ] ],
			toolbar : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					admin_sjgl_appendFun();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					admin_sjgl_removeFun();
				}
			}, '-' ]
		});
	});
	
	function admin_sjgl_removeFun() {
		var rows = $('#admin_data_datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('确认', '您是否要删除当前选中的项目？', function(r) {
				if (r) {
					var currentUserId = '${sessionInfo.userId}';/*当前登录用户的ID*/
					var flag = false;
					for ( var i = 0; i < rows.length; i++) {
						if (currentUserId != rows[i].id) {
							ids.push(rows[i].id);
						} else {
							flag = true;
						}
					}
					$.ajax({
						url : '/stock/remove',
						data : {
							ids : ids.join(',')
						},
						dataType : 'json',
						success : function(result) {
							if (result.success) {
								$('#admin_data_datagrid').datagrid('load');
								$('#admin_data_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
							}
							if (flag) {
								$.messager.show({
									title : '提示',
									msg : '不可以删除自己！'
								});
							} else {
								$.messager.show({
									title : '提示',
									msg : result.msg
								});
							}
						}
					});
				}
			});
		} else {
			$.messager.show({
				title : '提示',
				msg : '请勾选要删除的记录！'
			});
		}
	}
	function admin_sjgl_appendFun() {
		$('#admin_data_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : 'show/adddata.jsp',
			width : 520,
			height : 200,
			modal : true,
			title : '添加数据',
			buttons : [ {
				text : '增加',
				iconCls : 'icon-add',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#admin_sjglAdd_addForm').form('submit', {
						url : '/stock/add',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									
								$('#admin_data_datagrid').datagrid('load');
			
									
									d.dialog('destroy');
								}
								$.messager.show({
									title : '提示',
									msg : r.msg
								});
							} catch (e) {
								$.messager.alert('提示', result);
							}
						}
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			}
		});
	}	
	function admin_sjgl_editFun(id) {
		
		$('#admin_data_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('<div/>').dialog({
			href : '/stock/show/editdata.jsp',
			width : 520,
			height : 200,
			modal : true,
			title : '修改数据',
			buttons : [ {
				text : '编辑',
				iconCls : 'icon-edit',
				handler : function() {
					var d = $(this).closest('.window-body');
					$('#admin_sjglEdit_editForm').form('submit', {
						url : '/stock/edit.action',
						success : function(result) {
							try {
								var r = $.parseJSON(result);
								if (r.success) {
									$('#admin_data_datagrid').datagrid('updateRow', {
										index : $('#admin_data_datagrid').datagrid('getRowIndex', id),
										row : r.obj
									});
									d.dialog('destroy');
								}
								$.messager.show({
									title : '提示',
									msg : r.msg
								});
							} catch (e) {
								$.messager.alert('提示', result);
							}
						}
					});
				}
			} ],
			onClose : function() {
				$(this).dialog('destroy');
			},
			onLoad : function() {

				var index = $('#admin_data_datagrid').datagrid('getRowIndex', id);
				var rows = $('#admin_data_datagrid').datagrid('getRows');

				var o = rows[index];
	
				$('#admin_sjglEdit_editForm').form('load', o);
			}
		});		
	}
	function admin_sjgl_deleteFun(id) {
		$('#admin_data_datagrid').datagrid('uncheckAll').datagrid('unselectAll').datagrid('clearSelections');
		$('#admin_data_datagrid').datagrid('checkRow', $('#admin_data_datagrid').datagrid('getRowIndex', id));
		admin_sjgl_removeFun();
	}
</script>
<table id="admin_data_datagrid"></table>