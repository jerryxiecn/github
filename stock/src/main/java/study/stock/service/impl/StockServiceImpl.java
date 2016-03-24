package study.stock.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import study.stock.dao.FundMapper;
import study.stock.model.Fund;
import study.stock.pagemodel.DataGrid;
import study.stock.pagemodel.PageFund;
import study.stock.service.StockServiceI;

@Service("stockService")
public class StockServiceImpl implements StockServiceI{

    @Autowired
    private FundMapper fundMapper;//注入dao
    
	public Fund getFundById(Integer userId) {
		// TODO Auto-generated method stub
		return fundMapper.selectByPrimaryKey(userId);

	}

	public List<Fund> getAllFunds() {
		// TODO Auto-generated method stub
		return fundMapper.getAllFunds();
	}

	public DataGrid datagrid(PageFund funds) {
		DataGrid dg = new DataGrid();
		List<Fund> l = fundMapper.getPageFunds((funds.getPage()-1)*funds.getRows(),funds.getRows());
		List<PageFund> nl = new ArrayList<PageFund>();		
		changeModel(l, nl);
		dg.setTotal(fundMapper.getCountsFunds());	
		dg.setRows(nl);
		return dg;
	}	
	
	private void changeModel(List<Fund> l, List<PageFund> nl) {
		if (l != null && l.size() > 0) {
			for (Fund t : l) {
				PageFund u = new PageFund();
				BeanUtils.copyProperties(t, u);

				nl.add(u);
			}
		}

	}

	public void remove(String ids) {
		// TODO Auto-generated method stub
		//fundMapper.deleteByPrimaryKey(1);
        String[] strArray = null;  
        strArray = ids.split(",");  
        for(int i=0;i<strArray.length;i++)
        {
        	fundMapper.deleteByPrimaryKey(Integer.valueOf(strArray[i]));
        }
	}
	
	public Fund find(PageFund funds) {
		return null;

	}
	public Fund save(PageFund funds) {
		
		Date now = new Date(); 
	
		Fund fund =new Fund();
		fund.setMoney(funds.getMoney());
		fund.setShindex(funds.getShindex());
		fund.setRemind(funds.getRemind());
		fund.setUpdatadate(now);		
		fundMapper.insert(fund);

		return fund;
	}
	public Fund edit(PageFund funds) {
		
		Date now = new Date(); 
	
		Fund fund =new Fund();
		fund.setId(funds.getId());
		fund.setMoney(funds.getMoney());
		fund.setShindex(funds.getShindex());
		fund.setRemind(funds.getRemind());
		fund.setUpdatadate(now);		
		fundMapper.updateByPrimaryKey(fund);

		return fund;
	}	
	public String chart()
	{
		
		long total = fundMapper.getCountsFunds();
		long start = 0;
		if(total >60)
		{
			start = total-60;
		}
		//List<Fund>  list = fundMapper.getAllFunds();
		List<Fund> list = fundMapper.getPageFunds((int)start,(int)total);


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String s = gson.toJson(map);
        return s;		

	}
	
}
