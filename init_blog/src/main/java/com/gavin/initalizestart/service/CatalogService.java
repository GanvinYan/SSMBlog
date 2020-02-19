package com.gavin.initalizestart.service;

import com.gavin.initalizestart.domain.Catalog;
import com.gavin.initalizestart.domain.User;

import java.util.List;

public interface CatalogService {

    /**
     * 保存Catalog
     * @param catalog
     * @return
     */
    Catalog saveCatalog(Catalog catalog);

    /**
     * 删除Catalog
     * @param id
     */
    void removeCatalog(Long id);

    /**
     * 根据id获取Catalog
     * @param id
     * @return
     */
    Catalog getCatalogById(Long id);

    /**
     * 获取Catalog列表
     * @param user
     * @return
     */
    List<Catalog> listCatalogs(User user);
}
