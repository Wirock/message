package org.myproject.entity;

import java.util.List;

/**
 *与命令对应的实体类
 */
public class Command {
private Integer id;
private String name;
private String description;
private List<CommandContent> contentList;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public List<CommandContent> getContentList() {
	return contentList;
}
public void setContentList(List<CommandContent> contentList) {
	this.contentList = contentList;
}
@Override
public String toString() {
	return "Command [id=" + id + ", name=" + name + ", description=" + description + ", contentList=" + contentList
			+ "]";
}

}
