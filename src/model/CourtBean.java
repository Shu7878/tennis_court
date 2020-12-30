package model;

import java.io.Serializable;

public class CourtBean implements Serializable {
	private int court_id;
	private String court_name;
	private String court_address;
	private int court_cost;
	private String court_time;

	public int getCourt_id() {
		return court_id;
	}

	public void setCourt_id(int court_id) {
		this.court_id = court_id;
	}

	public String getCourt_name() {
		return court_name;
	}

	public void setCourt_name(String court_name) {
		this.court_name = court_name;
	}

	public String getCourt_address() {
		return court_address;
	}

	public void setCourt_address(String court_address) {
		this.court_address = court_address;
	}

	public int getCourt_cost() {
		return court_cost;
	}

	public void setCourt_cost(int court_cost) {
		this.court_cost = court_cost;
	}

	public String getCourt_time() {
		return court_time;
	}

	public void setCourt_time(String court_time) {
		this.court_time = court_time;
	}

}
