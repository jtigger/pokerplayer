package com.infosysengr.pokerplayer;

public class Player {
  private String nick;
	private int balance;

	public Player() {}
	public Player(String nick) {
		this.nick = nick;
	}
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
  
}
