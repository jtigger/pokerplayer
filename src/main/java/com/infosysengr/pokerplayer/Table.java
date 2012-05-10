package com.infosysengr.pokerplayer;

public class Table {
	String tableId;

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	@Override
	public String toString() {
		return tableId;
	}
	
	public static enum Status {
		NO_GAME("NoGame");
		
		private String value;
		
		Status(String value) {
			this.value = value;
		}
	}

}
