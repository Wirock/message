package org.myproject.servicetest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myproject.entity.Command;
import org.myproject.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class QueryServiceTest {
	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private QueryService queryService;
	@Test
	public void testQueryCommands(){
		List<Command> commandList = queryService.queryCommands(null, null);
		logger.info("commandList={}",commandList);
	}
	@Test
	public void TestQueryContents(){
		Command command = queryService.queryContents("2");
		logger.info("command={}",command);
	}
	@Test
	public void testQueryByCommandName(){
		String str1 = queryService.queryByCommandName("°ïÖú");
		String str2 = queryService.queryByCommandName("afqwefq");
		String str3 = queryService.queryByCommandName("²é¿´");
		logger.info("help={},no-matching={},query={}",str1,str2,str3);
	}
}
