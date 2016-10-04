package org.myproject.service;
/**
 * ������Ϣ�޸���ط���
 * @author Czw
 *
 */
public interface ModificationService {
	/**
	 * ���һ��û�����ݵ�����
	 * @param name��������
	 * @param description����
	 */
	public void addOneCommand(String name, String description);
	/**
	 * ����һ����������ƺ�����
	 * @param idҪ���µ������id
	 * @param name�µ���������
	 * @param description�µ�����
	 */
	public void updateCommand(String id, String name, String description);
	/**
	 * ɾȥһ������������������
	 * @param id����id
	 */
	public void deleteOneCommand(String id);
	/**
	 * ����ɾ������������������
	 * @param ids����Id����
	 */
	public void deleteCommands(String[] ids);
	/**
	 * ���һ������
	 * @param content����
	 * @param commandId���ݶ�Ӧ������id
	 */
	public void addOneContent(String content, String commandId);
	/**
	 * ����һ������
	 * @param id����id
	 * @param commandId��Ӧ������id
	 * @param content����
	 */
	public void updateContent(String id, String commandId, String content);
	/**
	 * ɾ��һ������
	 * @param id����id
	 */
	public void deleteContent(String id);
	/**
	 * ����ɾ������
	 * @param ids����id����
	 */
	public void deleteContents(String[] ids);
}
