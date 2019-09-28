package SDE_Remote_Assignment_v20.example.SDE_Remote_Assignment_v20.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {

	@Id
	private String card_no;
	private boolean isBlacklisted;
	private String card_holder;
	private String expiry_month;
	private String expiry_year;



	public Card() {
		super();
	}


	public Card(String card_no, boolean isBlacklisted, String card_holder, String expiry_month, String expiry_year) {
		super();
		this.card_no = card_no;
		this.isBlacklisted = isBlacklisted;
		this.card_holder = card_holder;
		this.expiry_month = expiry_month;
		this.expiry_year = expiry_year;
	}


	public String getCard_holder() {
		return card_holder;
	}


	public void setCard_holder(String card_holder) {
		this.card_holder = card_holder;
	}


	public String getExpiry_month() {
		return expiry_month;
	}


	public void setExpiry_month(String expiry_month) {
		this.expiry_month = expiry_month;
	}


	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public boolean isBlacklisted() {
		return isBlacklisted;
	}

	public void setBlacklisted(boolean isBlacklisted) {
		this.isBlacklisted = isBlacklisted;
	}

	public String getExpiry_day() {
		return expiry_month;
	}

	public void setExpiry_day(String expiry_month) {
		this.expiry_month = expiry_month;
	}

	public String getExpiry_year() {
		return expiry_year;
	}

	public void setExpiry_year(String expiry_year) {
		this.expiry_year = expiry_year;
	}

	@Override
	public String toString() {
		return "card [card_no=" + card_no + ", isBlacklisted=" + isBlacklisted + ", expiry_day=" + expiry_month
				+ ", expiry_year=" + expiry_year + "]";
	}

}
