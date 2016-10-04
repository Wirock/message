package org.myproject.daotest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myproject.dao.ContentDao;
import org.myproject.entity.CommandContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ContentDaoTest {
	@Autowired
	private ContentDao contentDao;
	@Test
	public void testAddOne(){
		CommandContent content = new CommandContent();
		content.setContent("12345");
		content.setCommandId(30);
		contentDao.addOne(content);
	}
	@Test
	public void testUpdate(){
		CommandContent content = new CommandContent();
		content.setContent("9876543");
		content.setCommandId(1);
		content.setId(39);
		contentDao.update(content);
	}
	@Test
	public void testDeleteOne(){
		contentDao.deleteOne(39);
	}
	@Test
	public void testDeleteBatch(){
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(40);
		idList.add(41);
		contentDao.deleteBatch(idList);
	}
	@Test
	public void testDeleteByCommandId(){
		contentDao.deleteByCommandId(29);
	}
	@Test
	public void testDeleteBatchByCommandId(){
		List<Integer> commandIdList = new ArrayList<Integer>();
		commandIdList.add(29);
		commandIdList.add(30);
		contentDao.deleteBatchByCommandId(commandIdList);
	}
}
