/**
 * Building Entities - Handles mapping and relations to and from the database utilizing javax persistence annotations
 * @author Stephen Lovick | 1803-USF-MAR05
 * @author Jake Trump | 1803-USF-MAR05
 */
package com.revature.gambit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="buildings")
public class Building {
	
	@Id
	@Column(name="building_id")
	@SequenceGenerator(name = "building_id_seq", sequenceName = "building_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "building_id_seq", strategy = GenerationType.AUTO)
	private Long buildingId;
	
	@Column(name="street_address")
	private String streetAddress;
	
	@Column(name="building_number")
	private Long buildingNumber;

	@Column(name="location_id")
	private Long locationId;

	@Transient
	@ManyToOne(fetch=FetchType.LAZY)
	private Location location;

	public Building() { }

	public Building(Long buildingId, String streetAddress, Long buildingNumber, Long locationId, Location location) {
		super();
		this.buildingId = buildingId;
		this.streetAddress = streetAddress;
		this.buildingNumber = buildingNumber;
		this.locationId = locationId;
		this.location = location;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", streetAddress=" + streetAddress + ", buildingNumber="
				+ buildingNumber + ", locationId=" + locationId + ", location=" + location + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingId == null) ? 0 : buildingId.hashCode());
		result = prime * result + ((buildingNumber == null) ? 0 : buildingNumber.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
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
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
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
