package com.gavin.initalizestart.domin.es;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 描述：Blog文档
 * 创建时间: 2018年8月28日 下午11:35:33 
 *
 * @author gang.yan
 */

@Document(indexName = "bolg",type = "bolg")
public class EsBlog implements Serializable{
	/** 
	 * serialVersionUID: TODO
	 */ 
	private static final long serialVersionUID = 1L;
	
	@Id //主键
	private String id;
	private String title;
	private String summary;
	private String content;
	
	 public EsBlog() { //JPA 规范要求
		// TODO Auto-generated constructor stub
	}
		
	public  EsBlog(String title,String summary,String content) {
		this.title = title;
		this.summary = summary;
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
    public String toString() {
        return String.format(
                "User[id=%d, title='%s', content='%s']",
                id, title, content);
    }
	
}
