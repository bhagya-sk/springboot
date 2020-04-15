package com.reactiveworks.practice.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.hateoas.RepresentationModel;

@Embeddable
@AttributeOverrides({ @AttributeOverride(name = "city", column = @Column(name = "city")),
		@AttributeOverride(name = "state", column = @Column(name = "state")),
		@AttributeOverride(name = "pincode", column = @Column(name = "pincode")) })
public class Address extends RepresentationModel<Address>{

	private String city;
	private String state;
	private String pincode;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [ city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
