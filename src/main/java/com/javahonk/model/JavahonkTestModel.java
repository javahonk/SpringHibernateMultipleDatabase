package com.javahonk.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
import org.hibernate.annotations.Type;

@Entity
@Table(name="javahonk.dbo.javahonktable")
public class JavahonkTestModel {
	
	@Id
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="ric_code")
	private String ric_code;
	
	@Column(name="name")
	private String name;
	
	@Column(name="libor_rate")
	private float libor_rate;
	
	@Column(name="libor_rate_date")
	private int libor_rate_date;
	
	@Column(name="extracting_date")
	@Type(type = "com.wfs.otc.common.hibernate.LocalDateHibernateUserType")
	private LocalDate extracting_date;
 
	public JavahonkTestModel() {
		
	}
 
	public JavahonkTestModel(String symbol, String ric_code,
			String name, float libor_rate, int libor_rate_date,
			LocalDate extracting_date) {
		super();
		this.symbol = symbol;
		this.ric_code = ric_code;
		this.name = name;
		this.libor_rate = libor_rate;
		this.libor_rate_date = libor_rate_date;
		this.extracting_date = extracting_date;
	}
 
	public String getSymbol() {
		return symbol;
	}
 
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
 
	public String getRic_code() {
		return ric_code;
	}
 
	public void setRic_code(String ric_code) {
		this.ric_code = ric_code;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public float getLibor_rate() {
		return libor_rate;
	}
 
	public void setLibor_rate(float libor_rate) {
		this.libor_rate = libor_rate;
	}
 
	public int getLibor_rate_date() {
		return libor_rate_date;
	}
 
	public void setLibor_rate_date(int libor_rate_date) {
		this.libor_rate_date = libor_rate_date;
	}
 
	public LocalDate getExtracting_date() {
		return extracting_date;
	}
 
	public void setExtracting_date(LocalDate extracting_date) {
		this.extracting_date = extracting_date;
	}
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((extracting_date == null) ? 0 : extracting_date.hashCode());
		result = prime * result + Float.floatToIntBits(libor_rate);
		result = prime * result + libor_rate_date;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((ric_code == null) ? 0 : ric_code.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavahonkTestModel other = (JavahonkTestModel) obj;
		if (extracting_date == null) {
			if (other.extracting_date != null)
				return false;
		} else if (!extracting_date.equals(other.extracting_date))
			return false;
		if (Float.floatToIntBits(libor_rate) != Float
				.floatToIntBits(other.libor_rate))
			return false;
		if (libor_rate_date != other.libor_rate_date)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ric_code == null) {
			if (other.ric_code != null)
				return false;
		} else if (!ric_code.equals(other.ric_code))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}
 
	@Override
	public String toString() {
		return "EquitySwapInterestRateModel [symbol=" + symbol + ", ric_code="
				+ ric_code + ", name=" + name + ", libor_rate=" + libor_rate
				+ ", libor_rate_date=" + libor_rate_date + ", extracting_date="
				+ extracting_date + "]";
	}

}
