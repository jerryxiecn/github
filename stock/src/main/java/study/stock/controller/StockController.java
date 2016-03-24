package study.stock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import study.stock.model.Fund;
import study.stock.pagemodel.DataGrid;
import study.stock.pagemodel.Json;
import study.stock.pagemodel.PageFund;
import study.stock.service.StockServiceI;

@Controller

public class StockController {
	
	private StockServiceI stockService;	
	


	public StockServiceI getMessageervice() {
		return stockService;
	}

	@Autowired
	public void setMessageService(StockServiceI stockService) {
		this.stockService = stockService;
	}
	
	@RequestMapping("/show")
	public ModelAndView MessageList() {
		// 查询消息列表并传给页面

		List funds = stockService.getAllFunds();
	
	    Map<String,Object> data = new HashMap<String,Object>();  
	    data.put("fundList",funds); 
		return new ModelAndView("stock",data);
	}
	
	@RequestMapping("/datagrid")
	@ResponseBody
	public DataGrid datagrid(PageFund funds) {
		DataGrid FundDataGrid = new DataGrid();
		FundDataGrid= stockService.datagrid(funds);
		return FundDataGrid;
	}
	@RequestMapping("/remove")
	@ResponseBody
	public Json remove(PageFund funds) {
		Json j = new Json();
		try {		
			stockService.remove(funds.getIds());
			j.setSuccess(true);
			j.setObj(funds.getId());
			j.setMsg("删除成功!");
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}		
		return j;
	}	
	@RequestMapping("/add")
	@ResponseBody
	public Json add(PageFund funds) {
		Json j = new Json();
		try {
		
			Fund fund = stockService.save(funds);
			j.setSuccess(true);
			j.setMsg("添加成功！");
			j.setObj(fund);

			
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;

	}	
	@RequestMapping("/edit")
	@ResponseBody
	public Json edit(PageFund funds) {
		Json j = new Json();
		try {
		
			Fund fund = stockService.edit(funds);
			j.setSuccess(true);
			j.setMsg("修改成功！");
			j.setObj(fund);

			
		} catch (Exception e) {
			j.setMsg(e.getMessage());
		}
		return j;

	}	
	@RequestMapping("/chart")
	@ResponseBody
	public String  chart() {
        String result = null;
        try {
            result = stockService.chart();
        } catch (Exception e) {

            result = null;
        }
        
        return result;

	}	
}
