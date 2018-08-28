package com.gavin.initalizestart.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.gavin.initalizestart.domin.es.EsBlog;

/**
 * 描述：EsBlog Repository 接口
 * 创建时间: 2018年8月28日 下午11:50:53 
 *
 * @author gang.yan
 */

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
	Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
	
}
