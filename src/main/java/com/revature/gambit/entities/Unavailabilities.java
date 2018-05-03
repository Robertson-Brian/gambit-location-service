/**
 * Unavailabilities Entity - Handle mapping and relations to and from the database utilizing javax persistence annotations
 */
package com.revature.gambit.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unavailabilities")
public class Unavailabilities {

	@Id
	@Column(name = "unavailability_id", columnDefinition = "SERIAL")    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/**
	 * For Oracle
	 */
	//@SequenceGenerator(name = "unavailability_id_seq", sequenceName = "unavailability_id_seq", allocationSize = 1)
	//@GeneratedValue(generator = "unavailability_id_seq", strategy = GenerationType.AUTO)
	private Long unavailabilityId;

	@Column(name = "start_date", columnDefinition = "DATE")
	private Timestamp startDate;

	@Column(name = "end_date", columnDefinition = "DATE")
	private Timestamp endDate;
	
	@Column(name = "room_id")
	private Long roomId;
	
	@Column(name = "comments")
	private String comments;

	@Column(name = "batch_id")
	private Long batchId;

	
	//Constructors
	public Unavailabilities( ) { }

	public Unavailabilities(Long unavailabilityId, Timestamp startDate, Timestamp endDate, Long batchId,
			String comments, Long roomId) {
		super();
		this.unavailabilityId = unavailabilityId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.batchId = batchId;
		this.comments = comments;
		this.roomId = roomId;
	}

	public Long getUnavailabilityId() {
		return unavailabilityId;
	}

	public void setUnavailabilitiesId(Long unavailabilityId) {
		this.unavailabilityId = unavailabilityId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "Unavailabilities [unavailabilityId=" + unavailabilityId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", batchId=" + batchId + ", comments=" + comments + ", roomId=" + roomId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((unavailabilityId == null) ? 0 : unavailabilityId.hashCode());
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
		Unavailabilities other = (Unavailabilities) obj;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (unavailabilityId == null) {
			if (other.unavailabilityId != null)
				return false;
		} else if (!unavailabilityId.equals(other.unavailabilityId))
			return false;
		return true;
	}

	
	
	

}
