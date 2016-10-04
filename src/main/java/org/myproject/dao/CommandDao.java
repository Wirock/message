package org.myproject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.myproject.entity.Command;
/**
 * 命令相关数据相关
 * @author Czw
 *
 */
public interface CommandDao {
	/**
	 * 根据命令名和描述查询命令
	 * @param 要查询的命令名称name
	 * @param 要查询的命令描述description
	 * @return 查询结果Command对象集合
	 */
	public List<Command> queryAll(@Param("name")String name,@Param("description")String description);
	/**
	 * 根据命令名和描述查询当前页面的命令
	 * @param 要查询的命令名称name
	 * @param 要查询的命令描述description
	 * @return 查询结果Command对象集合
	 */
	public List<Command> queryByPage(@Param("name")String name,@Param("description")String description,@Param("offsetIndex")int offsetIndex,@Param("queryNumber")int queryNumber);
	/**
	 * 查询满足条件的命令总数
	 * @param name
	 * @param description
	 * @return
	 */
	public int commandCount(@Param("name")String name,@Param("description")String description);
	/**
	 * 根据id查询一条命令
	 * @param id要查询命令的id
	 * @return 查询结果Command对象
	 */
	public Command queryOne(int id);
	/**
	 * 根据id删除一条命令，包括其所有内容
	 * @param id命令的id
	 */
	public void deleteOne(int id);
	/**
	 * 批量删除命令及其内容
	 * @param idList命令id集合
	 */
	public void deleteBatch(List<Integer> idList);
	/**
	 * 添加一条新的命令
	 * @param command命令对象
	 */
	public void addOne(Command command);
	/**
	 * 更新一条命令的信息
	 * @param command命令对象
	 */
	public void update(Command command);
}
