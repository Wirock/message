package org.myproject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.myproject.entity.Command;
/**
 * ��������������
 * @author Czw
 *
 */
public interface CommandDao {
	/**
	 * ������������������ѯ����
	 * @param Ҫ��ѯ����������name
	 * @param Ҫ��ѯ����������description
	 * @return ��ѯ���Command���󼯺�
	 */
	public List<Command> queryAll(@Param("name")String name,@Param("description")String description);
	/**
	 * ������������������ѯ��ǰҳ�������
	 * @param Ҫ��ѯ����������name
	 * @param Ҫ��ѯ����������description
	 * @return ��ѯ���Command���󼯺�
	 */
	public List<Command> queryByPage(@Param("name")String name,@Param("description")String description,@Param("offsetIndex")int offsetIndex,@Param("queryNumber")int queryNumber);
	/**
	 * ��ѯ������������������
	 * @param name
	 * @param description
	 * @return
	 */
	public int commandCount(@Param("name")String name,@Param("description")String description);
	/**
	 * ����id��ѯһ������
	 * @param idҪ��ѯ�����id
	 * @return ��ѯ���Command����
	 */
	public Command queryOne(int id);
	/**
	 * ����idɾ��һ�������������������
	 * @param id�����id
	 */
	public void deleteOne(int id);
	/**
	 * ����ɾ�����������
	 * @param idList����id����
	 */
	public void deleteBatch(List<Integer> idList);
	/**
	 * ���һ���µ�����
	 * @param command�������
	 */
	public void addOne(Command command);
	/**
	 * ����һ���������Ϣ
	 * @param command�������
	 */
	public void update(Command command);
}
