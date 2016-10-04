package org.myproject.servicetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.myproject.service.ModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml"})
public class ModificationServiceTest {
	@Autowired
	private ModificationService modificationService; 
	@Test
	public void testAddOneCommand(){
		modificationService.addOneCommand("旅游", "美景美食");
	}
	@Test
	public void testUpdateCommand(){
		modificationService.updateCommand("30", "星座", "星座运势");
	}
	@Test
	public void testDeleteOneCommand(){
		modificationService.deleteOneCommand("34");
	}
	@Test
	public void testDeleteCommands(){
		String[] ids = {"32","33"};
		modificationService.deleteCommands(ids);
	}
	@Test
	public void testAddOneContent(){
		modificationService.addOneContent("123314", "32");
		modificationService.addOneContent("123314", "33");
		modificationService.addOneContent("123314", "34");
	}
	@Test
	public void testUpdateContent(){
		modificationService.updateContent("48", "30", "98765");
	}
	@Test
	public void testDeleteContent(){
		modificationService.deleteContent("50");
	}
	@Test
	public void testDeleteContents(){
		String[] ids={"48","49"};
		modificationService.deleteContents(ids);
	}
}
