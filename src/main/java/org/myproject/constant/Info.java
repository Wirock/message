package org.myproject.constant;

public enum Info {
	HELP_COMMAND("����"),
	NO_MATCHING_CONTENT("��û����·���ơ���������������˵ʲô����");
	private String information;
	private Info(String information){
		this.information = information;
	}
	public String getInformation() {
		return information;
	}
	
}
