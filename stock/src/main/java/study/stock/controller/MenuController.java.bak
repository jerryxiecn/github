package study.stock.controller;




import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.stock.model.Menu;
import study.stock.pagemodel.PageMenu;


@Controller

public class MenuController {


	@RequestMapping("/menu")
	@ResponseBody
	public List<PageMenu> MenuTreeNode() {
		List<PageMenu> nl = new ArrayList<PageMenu>();
		List<Menu> l = new ArrayList<Menu>();
		//(String id, Menu pid, String text, String url, String iconcls, BigDecimal seq, Set<Menu> tmenus)
		Menu m0 = new Menu("0",null,"首页","","icon-tip",new BigDecimal("1"));
		Menu m1 = new Menu("xtgl",m0,"系统菜单","","icon-sum",new BigDecimal("2"));
		Menu m2 = new Menu("sjgl",m1,"原始数据","show/showdata.jsp","iconCls",new BigDecimal("3"));
		Menu m3 = new Menu("pxgl",m1,"图形处理","show/showpic.jsp","iconCls",new BigDecimal("4"));
		l.add(m0);	
		l.add(m1);
		l.add(m2);
		l.add(m3);
		
		if (l != null && l.size() > 0) {
			for (Menu t : l) {
				PageMenu m = new PageMenu();
				BeanUtils.copyProperties(t, m);
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", t.getUrl());
				m.setAttributes(attributes);
				Menu tm = t.getPid();// 获得当前节点的父节点对象
				if (tm != null) {
					m.setPid(tm.getId());
				}
				m.setIconCls(t.getIconcls());
				nl.add(m);
			}
		}		
		return nl;

	}



}
