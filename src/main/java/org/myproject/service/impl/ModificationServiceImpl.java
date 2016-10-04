package org.myproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.myproject.dao.CommandDao;
import org.myproject.dao.ContentDao;
import org.myproject.entity.Command;
import org.myproject.entity.CommandContent;
import org.myproject.service.ModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 命令信息修改服务实现类
 * @author Czw
 *
 */
@Service
public class ModificationServiceImpl implements ModificationService {
	@Autowired
	private CommandDao commandDao;
	@Autowired
	private ContentDao contentDao;
	public void addOneCommand(String name, String description) {
		if(name!=null&&!name.trim().equals("")){
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			commandDao.addOne(command);
		}

	}

	public void updateCommand(String id, String name, String description) {
		if(id!=null&&!id.trim().equals("")){
			Command command = new Command();
			command.setId(Integer.valueOf(id));
			command.setName(name);
			command.setDescription(description);
			commandDao.update(command);
		}
	}
	@Transactional
	public void deleteOneCommand(String id) {
		if(id!=null&&!id.trim().equals("")){
			commandDao.deleteOne(Integer.valueOf(id));
			contentDao.deleteByCommandId(Integer.valueOf(id));
		}	

	}
	@Transactional
	public void deleteCommands(String[] ids) {
		List<Integer> idList = new ArrayList<Integer>();
		for(int i=0;i<ids.length;i++){
			idList.add(i,Integer.valueOf(ids[i]));
		}
		commandDao.deleteBatch(idList);
		contentDao.deleteBatchByCommandId(idList);
	}

	public void addOneContent(String content, String commandId) {
		if(content!=null&&!content.trim().equals("")){
			CommandContent commandContent = new CommandContent();
			commandContent.setContent(content);
			commandContent.setCommandId(Integer.valueOf(commandId));
			contentDao.addOne(commandContent);
		}

	}

	public void updateContent(String id, String commandId, String content) {
		if(id!=null&&!id.trim().equals("")){
			CommandContent commandContent = new CommandContent();
			commandContent.setId(Integer.valueOf(id));
			commandContent.setContent(content);
			commandContent.setCommandId(Integer.valueOf(commandId));
			contentDao.update(commandContent);
		}

	}

	public void deleteContent(String id) {
		if(id!=null&&!id.trim().equals("")){
			contentDao.deleteOne(Integer.valueOf(id));
		}	
	}

	public void deleteContents(String[] ids) {
		List<Integer> idList = new ArrayList<Integer>();
		for(int i=0;i<ids.length;i++){
			idList.add(i,Integer.valueOf(ids[i]));
		}
		contentDao.deleteBatch(idList);
	}

}
