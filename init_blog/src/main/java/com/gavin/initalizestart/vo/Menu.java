package com.gavin.initalizestart.vo;

/**
 * @Description: 菜单 值对象
 * @Author: gang.yan
 * @Date: 2019/11/10 18:22
 * @Version: 1.0
 */
public class Menu {


    private static final long serialVersionUID = 1L;

    private String name;
    private String url;

    public Menu(String name, String url) {
        this.name = name;
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
