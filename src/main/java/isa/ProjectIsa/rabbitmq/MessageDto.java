package isa.ProjectIsa.rabbitmq;

import java.util.Date;

public class MessageDto {
    private String text;
    private String pharmacyName;
    private Date dateFrom;
    private Date dateTo;
    public MessageDto() {
    }
    public MessageDto(String text, String pharmacyName, Date dateFrom, Date dateTo) {
    	super();
    	this.text = text;
    	this.pharmacyName = pharmacyName;
    	this.dateFrom = dateFrom;
    	this.dateTo = dateTo;
    }
	public MessageDto(String text, String pharmacyName) {
		super();
		this.text = text;
		this.pharmacyName = pharmacyName;
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPharmacyName() {
		return pharmacyName;
	}
	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

    
}
