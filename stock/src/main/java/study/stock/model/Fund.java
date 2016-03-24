package study.stock.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Fund {
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