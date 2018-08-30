package com.gavin.initalizestart.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.gavin.initalizestart.domin.es.EsBlog;

/**
 * 描述：EsBlog Repository 接口
 * 创建时间: 2018年8月28日 下午11:50:53 
 *http://localhost:8080/blogs?title=%E6%80%9D&summary=%E7%9B%B8%E6%80%9D&content=%E7%9B%B8%E6%80%9D
 * @author gang.yan
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest  {
	
	@Autowired
	private EsBlogRepository esBlogRepository;
	
	@Before
	public void initRepositoryDate() {
		//清除所有数据
		 esBlogRepository.deleteAll();
		
		 esBlogRepository.save( new EsBlog("登鹳雀楼","王之涣的登鹳雀楼",
				"白日依山尽，黄河入海流。欲穷千里目，更上一层楼。"));
		 esBlogRepository.save( new EsBlog("相思","王维的相思",
					"红豆生南国，春来发几枝 。愿君多采撷，此物最相思。"));
		 
		 esBlogRepository.save( new EsBlog("相思","李商隐的相思",
				 "风波不信菱枝弱，月露谁教桂叶香。直道相思了无益，未妨惆怅是清狂。"));

	}
			
	@Test
	public void testFindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(){
		String title = "思";
		String summary = "相思";
		String content = "相思";
		
		 Pageable pageable = new PageRequest(0, 20);
		 Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title,summary, content, pageable);
		 assertThat(page.getTotalElements()).isEqualTo(2);
		 
		 System.out.println("------Start");
		 for (EsBlog blog  : page.getContent()) {
			System.out.println(blog.toString());
		}
		 System.out.println("------End");
	}
	
}
