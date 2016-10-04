package org.myproject.service;

import java.util.List;

import org.myproject.entity.Command;

public interface QueryService {
	/**
	 * 通过搜索条件查询指令信息
	 * @param command
	 * @param description
	 * @return 包含内容的命令集合
	 */
	public List<Command> queryCommands(String name,String description);
	/**
	 * 通过搜索条件分页查询指令信息
	 * @param command
	 * @param description
	 * @return 包含内容的命令集合
	 */
	public List<Command> queryCommandsByPage(String name,String description,int offsetIndex,int queryNumber);	
	/**
	 * 查询符合条件的命令数量
	 * @param name
	 * @param description
	 * @return
	 */
	public int queryCommandCount(String name,String description);
	/**
	 *通过命令id获取对应的内容
	 * @param commandId
	 * @return 包含内容的命令
	 */
	public Command queryContents(String commandId);
	/**
	 * 通过指令名称查询自动回复的内容
	 * @param commandName指令名称
	 * @return 自动回复的内容
	 */
	public String queryByCommandName(String commandName);
}