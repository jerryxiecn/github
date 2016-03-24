<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div align="center">
	<form id="admin_sjglEdit_editForm" method="post">
		<table class="tableForm">
			<tr>
				<th style="width: 100px;">序列号</th>
				<td><input name="id" class="easyui-numberbox"  />
				</td>
	
			</tr>		
			<tr>
				<th style="width: 100px;">资金</th>
				<td><input name="money" class="easyui-numberbox" data-options="required:true,min:1,max:999999999" />
				</td>
				<th style="width: 100px;">指数</th>
				<td><input name="shindex" class="easyui-numberbox" data-options="required:true,min:1,max:999999999" />
				</td>
			</tr>	
				
		</table>
		<table class="tableForm2" >
			<tr>
				<th>备注</th>


			</tr>	
			<tr>
				<td ><input style="width: 480px;" name="remind" class="easyui-box"  />
				</td>


			</tr>	
				
		</table>			
	</form>
</div>
