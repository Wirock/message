package org.myproject.dao;

import java.util.List;

import org.myproject.entity.CommandContent;

/**
 * 内容相关数据操作
 * @author Czw
 *
 */
public interface ContentDao {
	/**
	 * 删除单条内容
	 * @param id要删除内容的id
	 */
	public void deleteOne(int id);
	/**
	 * 批量删除内容
	 * @param idList内容id集合
	 */
	public void deleteBatch(List<Integer> idList);
	/**
	 * 删除commandId对应的所有内容
	 * @param commandId要删除内容对应的命令的id
	 */
	public void deleteByCommandId(int commandId);
	/**
	 * 删除commandIdList集合中所有commandId对应的所有内容
	 * @param commandIdList要删除内容对应的命令的id的集合
	 */
	public void deleteBatchByCommandId(List<Integer> commandIdList);
	/**
	 * 添加一条内容
	 * @param commandContent内容对象
	 */
	public void addOne(CommandContent commandContent);
	/**
	 * 更新一条内容
	 * @param commandContent包含更新内容的数据对象
	 */
	public void update(CommandContent commandContent);
}
