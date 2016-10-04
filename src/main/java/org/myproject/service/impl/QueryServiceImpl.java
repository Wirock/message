package org.myproject.service.impl;

import java.util.List;
import java.util.Random;

import org.myproject.constant.Info;
import org.myproject.dao.CommandDao;
import org.myproject.entity.Command;
import org.myproject.entity.CommandContent;
import org.myproject.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class QueryServiceImpl implements QueryService {
	@Autowired
	private CommandDao commandDao;
	public List<Command> queryCommands(String name, String description) {
		List<Command> commandList = commandDao.queryAll(name, description);
		return commandList;
	}

	public Command queryContents(String commandId) {
		Command command = commandDao.queryOne(Integer.valueOf(commandId));
		return command;
	}

	public String queryByCommandName(String commandName) {
		List<Command> commandList;
		if(Info.HELP_COMMAND.getInformation().equals(commandName)) {
			commandList = commandDao.queryAll(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
			}
			return result.toString();
		}
		commandList = commandDao.queryAll(commandName, null);
		if(commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			if(contentList.size()>0){
				int i = new Random().nextInt(contentList.size());
				return contentList.get(i).getContent();
			}else{
				return Info.NO_MATCHING_CONTENT.getInformation();
			}
		}
		return Info.NO_MATCHING_CONTENT.getInformation();
	}

	public List<Command> queryCommandsByPage(String name, String description, int offsetIndex, int queryNumber) {
		List<Command> commandList = commandDao.queryByPage(name, description,offsetIndex,queryNumber);
		return commandList;
	}

	public int queryCommandCount(String name, String description) {
		return commandDao.commandCount(name, description);
	}

}
