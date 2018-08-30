package com.gavin.initalizestart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gavin.initalizestart.domin.es.EsBlog;
import com.gavin.initalizestart.repository.EsBlogRepository;

/**
 * Blog控制器
 * @author Administrator
 *
*/
@RestController
@RequestMapping("/blogs")
public class BlogController {
	@Autowired
	private EsBlogRepository blogRepository;
	@GetMapping
	public List<EsBlog> list(@RequestParam(value="title",defaultValue="") String title,
							@RequestParam(value="content",defaultValue="") String content,
							@RequestParam(value="summary",defaultValue="") String summary,
							@RequestParam(value="pageIndex",defaultValue="0") int pageIndex,
							@RequestParam(value="pageSize",defaultValue="20") int pageSize){
		// 数据在 Test 里面先初始化了，这里只管取数据
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<EsBlog> page = blogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
		
		return page.getContent();
	}
}
