package study.stock.service;

import java.util.List;

import study.stock.model.Fund;
import study.stock.pagemodel.DataGrid;
import study.stock.pagemodel.PageFund;

public interface StockServiceI {

	public Fund getFundById(Integer userId);
	public List <Fund> getAllFunds();
	public DataGrid datagrid(PageFund funds);	
	public void remove(String ids);
	public Fund find(PageFund funds);
	public Fund save(PageFund funds);	
	public Fund edit(PageFund funds);	
	public String chart();
}
