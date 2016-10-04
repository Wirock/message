package org.myproject.dao;

import java.util.List;

import org.myproject.entity.CommandContent;

/**
 * ����������ݲ���
 * @author Czw
 *
 */
public interface ContentDao {
	/**
	 * ɾ����������
	 * @param idҪɾ�����ݵ�id
	 */
	public void deleteOne(int id);
	/**
	 * ����ɾ������
	 * @param idList����id����
	 */
	public void deleteBatch(List<Integer> idList);
	/**
	 * ɾ��commandId��Ӧ����������
	 * @param commandIdҪɾ�����ݶ�Ӧ�������id
	 */
	public void deleteByCommandId(int commandId);
	/**
	 * ɾ��commandIdList����������commandId��Ӧ����������
	 * @param commandIdListҪɾ�����ݶ�Ӧ�������id�ļ���
	 */
	public void deleteBatchByCommandId(List<Integer> commandIdList);
	/**
	 * ���һ������
	 * @param commandContent���ݶ���
	 */
	public void addOne(CommandContent commandContent);
	/**
	 * ����һ������
	 * @param commandContent�����������ݵ����ݶ���
	 */
	public void update(CommandContent commandContent);
}
