package POJO;

public class BookingDatesPOJO {
	private String checkin;
	private String checkout;

	public BookingDatesPOJO(String checkin, String checkout) {
		super();
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public BookingDatesPOJO() {
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

}
