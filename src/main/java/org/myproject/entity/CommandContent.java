package org.myproject.entity;
/**
 * 与命令内容相对应的实体类
 */
public class CommandContent {
	private Integer id;
	private String content;
	private Integer commandId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCommandId() {
		return commandId;
	}
	public void setCommandId(Integer commandId) {
		this.commandId = commandId;
	}
	@Override
	public String toString() {
		return "CommandContent [id=" + id + ", content=" + content + ", commandId=" + commandId + "]";
	}
	
}
