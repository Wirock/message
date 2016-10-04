package org.myproject.daotest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myproject.dao.CommandDao;
import org.myproject.entity.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring的配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CommandDaoTest {
	@Autowired
	private CommandDao commandDao;
	@Test
	public void testQueryAll(){
		List<Command> commandList=commandDao.queryAll("天气","天");
		System.out.println(commandList);
	}
	@Test
	public void testQueryOne(){
		Command command=commandDao.queryOne(23);
		System.out.println(command);
	}
	@Test
	public void addOne(){
		Command command = new Command();
		command.setName("天气");
		command.setDescription("天气预报");
		commandDao.addOne(command);
		List<Command> commandList=commandDao.queryAll("天气","");
		System.out.println(commandList);
	}
	@Test
	public void testUpdate(){
		Command command = new Command();
		command.setId(23);
		command.setName("旅游");
		command.setDescription("美景");
		commandDao.update(command);
		System.out.println(commandDao.queryOne(23));
	}
	@Test
	public void testDeleteOne(){
		commandDao.deleteOne(23);
		System.out.println(commandDao.queryOne(23));
	}
	@Test
	public void testDeleteBatch(){
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(27);
		idList.add(28);
		commandDao.deleteBatch(idList);
		System.out.println(commandDao.queryAll("",""));
	}
}
