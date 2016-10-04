package org.myproject.service;

import java.util.List;

import org.myproject.entity.Command;

public interface QueryService {
	/**
	 * ͨ������������ѯָ����Ϣ
	 * @param command
	 * @param description
	 * @return �������ݵ������
	 */
	public List<Command> queryCommands(String name,String description);
	/**
	 * ͨ������������ҳ��ѯָ����Ϣ
	 * @param command
	 * @param description
	 * @return �������ݵ������
	 */
	public List<Command> queryCommandsByPage(String name,String description,int offsetIndex,int queryNumber);	
	/**
	 * ��ѯ������������������
	 * @param name
	 * @param description
	 * @return
	 */
	public int queryCommandCount(String name,String description);
	/**
	 *ͨ������id��ȡ��Ӧ������
	 * @param commandId
	 * @return �������ݵ�����
	 */
	public Command queryContents(String commandId);
	/**
	 * ͨ��ָ�����Ʋ�ѯ�Զ��ظ�������
	 * @param commandNameָ������
	 * @return �Զ��ظ�������
	 */
	public String queryByCommandName(String commandName);
}