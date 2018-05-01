/**
 * Building Entities - Handles mapping and relations to and from the database utilizing javax persistence annotations
 * @author Stephen Lovick | 1803-USF-MAR05
 * @author Jake Trump | 1803-USF-MAR05
 */
package com.revature.gambit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="buildings")
public class Building {
	
	@Id
	@Column(name = "building_id", columnDefinition = "SERIAL")    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/**
	 * For Oracle
	 */
//	@SequenceGenerator(name = "building_id_seq", sequenceName = "building_id_seq", allocationSize = 1)
//	@GeneratedValue(generator = "building_id_seq", strategy = GenerationType.AUTO)
	private Long buildingId;
	
	@Column(name="street_address")
	private String streetAddress;
	
	@Column(name="building_number")
	private Long buildingNumber;

	@Column(name="location_id")
	private Long locationId;


	public Building() { }

	public Building(Long buildingId, String streetAddress, Long buildingNumber, Long locationId) {
		super();
		this.buildingId = buildingId;
		this.streetAddress = streetAddress;
		this.buildingNumber = buildingNumber;
		this.locationId = locationId;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public Long getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(Long buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", streetAddress=" + streetAddress + ", buildingNumber="
				+ buildingNumber + ", locationId=" + locationId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingId == null) ? 0 : buildingId.hashCode());
		result = prime * result + ((buildingNumber == null) ? 0 : buildingNumber.hashCode());
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
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
		Building other = (Building) obj;
		if (buildingId == null) {
			if (other.buildingId != null)
				return false;
		} else if (!buildingId.equals(other.buildingId))
			return false;
		if (buildingNumber == null) {
			if (other.buildingNumber != null)
				return false;
		} else if (!buildingNumber.equals(other.buildingNumber))
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		if (streetAddress == null) {
			if (other.streetAddress != null)
				return false;
		} else if (!streetAddress.equals(other.streetAddress))
			return false;
		return true;
	}

	
		
}
