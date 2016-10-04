package org.myproject.service;
/**
 * 命令信息修改相关服务
 * @author Czw
 *
 */
public interface ModificationService {
	/**
	 * 添加一条没有内容的命令
	 * @param name命令名称
	 * @param description描述
	 */
	public void addOneCommand(String name, String description);
	/**
	 * 更新一条命令的名称和描述
	 * @param id要更新的命令的id
	 * @param name新的命令名称
	 * @param description新的描述
	 */
	public void updateCommand(String id, String name, String description);
	/**
	 * 删去一条命令及其包含所有内容
	 * @param id命令id
	 */
	public void deleteOneCommand(String id);
	/**
	 * 批量删除命令及其包含所有内容
	 * @param ids命令Id集合
	 */
	public void deleteCommands(String[] ids);
	/**
	 * 添加一条内容
	 * @param content内容
	 * @param commandId内容对应的命令id
	 */
	public void addOneContent(String content, String commandId);
	/**
	 * 更新一条内容
	 * @param id内容id
	 * @param commandId对应的命令id
	 * @param content内容
	 */
	public void updateContent(String id, String commandId, String content);
	/**
	 * 删除一条内容
	 * @param id内容id
	 */
	public void deleteContent(String id);
	/**
	 * 批量删除内容
	 * @param ids内容id集合
	 */
	public void deleteContents(String[] ids);
}
