package org.myproject.constant;

public enum Info {
	HELP_COMMAND("帮助"),
	NO_MATCHING_CONTENT("您没按套路出牌……我听不懂你在说什么哎！");
	private String information;
	private Info(String information){
		this.information = information;
	}
	public String getInformation() {
		return information;
	}
	
}
