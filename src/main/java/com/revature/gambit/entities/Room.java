/**
 * Room Entity - Handles mapping and relations to and from the database utilizing javax persistence annotations.
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Rooms")
public class Room {

	@Id
	@Column(name = "room_id")
	@SequenceGenerator(name = "room_id_seq", sequenceName = "room_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "room_id_seq", strategy = GenerationType.AUTO)
	private Long roomId;

	@Column(name = "room_number")
	private Long roomNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	//@Column(name = "building_id")
	@JoinColumn(name= "building_id")
	@Transient
	private Building building;
	
	private Long buildingId;

	@Column(name = "capacity")
	private Integer capacity;

	// Constructors
	public Room() {
	}

	public Room(Long roomId, Long roomNumber, Building building, Long buildingId, Integer capacity) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.building = building;
		this.buildingId = buildingId;
		this.capacity = capacity;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", building=" + building + ", buildingId="
				+ buildingId + ", capacity=" + capacity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((building == null) ? 0 : building.hashCode());
		result = prime * result + ((buildingId == null) ? 0 : buildingId.hashCode());
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((roomNumber == null) ? 0 : roomNumber.hashCode());
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
		Room other = (Room) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (buildingId == null) {
			if (other.buildingId != null)
				return false;
		} else if (!buildingId.equals(other.buildingId))
			return false;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		return true;
	}

		
	
}
