package com.gavin.initalizestart.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Blog控制器
 * @author Administrator
 *
*/
@RestController
@RequestMapping("/blogs")
public class BlogController {
	@Autowired
	private BlogRepoditory blogRepository;
	@GetMapping
	public List<EsBlog> list(@RequestParam(value="title",required=false,defaultValue="") String title,
							@requestParam(value="content",required=false) String content,
							@requestParam(value="pageIndex",required=false) String pageIndex,
							@requestParam(value="pageSize",required=false) String pageSize){
		// 数据在 Test 里面先初始化了，这里只管取数据
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<Blog> page = blogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, content, pageable);
		
		return page.getContent();
	}
}
