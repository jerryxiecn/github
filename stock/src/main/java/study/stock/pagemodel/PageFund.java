package study.stock.pagemodel;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import study.stock.util.JsonDateSerializer;




public class PageFund {
	private int page;
	private int rows;
	private String sort;
	private String order;
	private String ids;
	private String q;


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}


    private Integer id;

    private Integer money;

    private Float shindex;

    private Date updatadate;

    private String remind;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Float getShindex() {
        return shindex;
    }

    public void setShindex(Float shindex) {
        this.shindex = shindex;
    }

    public Date getUpdatadate() {
        return updatadate;
    }

    public void setUpdatadate(Date updatadate) {
        this.updatadate = updatadate;
    }

    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind == null ? null : remind.trim();
    }
}
