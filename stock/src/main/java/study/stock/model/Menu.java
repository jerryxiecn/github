package study.stock.model;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Menu implements java.io.Serializable {
	private String id;
	private Menu pid;
	private String text;
	private String url;
	private String iconcls;
	private BigDecimal seq;
	private Set<Menu> menus = new HashSet<Menu>(0);
	
	
	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(String id, String text) {
		this.id = id;
		this.text = text;
	}

	/** full constructor */
	public Menu(String id, Menu pid, String text, String url, String iconcls, BigDecimal seq) {
		this.id = id;
		this.pid = pid;
		this.text = text;
		this.url = url;
		this.iconcls = iconcls;
		this.seq = seq;

	}
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Menu getPid() {
		return this.pid;
	}

	public void setPid(Menu pid) {
		this.pid = pid;
	}
	public String getIconcls() {
		return this.iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}
	public BigDecimal getSeq() {
		return this.seq;
	}

	public void setSeq(BigDecimal seq) {
		this.seq = seq;
	}
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}	
}
