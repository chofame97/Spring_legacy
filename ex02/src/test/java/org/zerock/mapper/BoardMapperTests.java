package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	

	BoardVO vo = new BoardVO();
	
	
	@Test
	public void testGetList() {
		log.info("---------------------");
		boardMapper.getList();
	}
	
	@Test
	public void testInsert() {
		log.info("---------------------");
		
		vo.setTitle("Test 테스트");
		vo.setContent("Content 테스트");
		vo.setWriter("Tester");
		
		boardMapper.insert(vo);
		log.info("--------------------------------------------");
		log.info("after insert "+vo.getBno());
	}
	
	@Test
	public void testInsertSelectKey() {
		log.info("---------------------");
		
		vo.setTitle("AAATest 테스트");
		vo.setContent("AAAContent 테스트");
		vo.setWriter("tester");
		
		boardMapper.insertSelectkey(vo);
		log.info("--------------------------------------------");
		log.info("after insert selectKey "+vo.getBno());
	}
	
	@Test
	public void testRead() {
		BoardVO vo = boardMapper.read(9L);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		int count = boardMapper.delete(1L);
		log.info("count: "+count);
	}
	
	@Test
	public void testUpdate() {
		vo.setBno(2L);
		vo.setTitle("제목수정");
		vo.setContent("내용수정");
		vo.setWriter("user수정");
		log.info("count: "+boardMapper.update(vo));
	}
	
	
}
