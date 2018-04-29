/**
 * Unavailabilities Entity - Handle mapping and relations to and from the database utilizing javax persistence annotations
 */
package com.revature.gambit.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "unavailabilities")
public class Unavailabilities {

	@Id
	@Column(name = "unavailabilities_id")
	@SequenceGenerator(name = "unavailabilities_id_seq", sequenceName = "unavailabilities_id_seq", allocationSize = 1)
	@GeneratedValue(generator = "unavailabilities_id_seq", strategy = GenerationType.AUTO)
	private Long unavailabilitiesId;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "batch_id")
	private Long batchId;

	@Column(name = "comments")
	private String comments;
	
	@Column(name = "room_id")
	private Long roomId;
	
	//Constructors
	public Unavailabilities( ) { }

	public Unavailabilities(Long unavailabilitiesId, LocalDate startDate, LocalDate endDate, Long batchId,
			String comments, Long roomId) {
		super();
		this.unavailabilitiesId = unavailabilitiesId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.batchId = batchId;
		this.comments = comments;
		this.roomId = roomId;
	}

	public Long getUnavailabilitiesId() {
		return unavailabilitiesId;
	}

	public void setUnavailabilitiesId(Long unavailabilitiesId) {
		this.unavailabilitiesId = unavailabilitiesId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
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
		return "Unavailabilities [unavailabilitiesId=" + unavailabilitiesId + ", startDate=" + startDate + ", endDate="
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
		result = prime * result + ((unavailabilitiesId == null) ? 0 : unavailabilitiesId.hashCode());
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
		if (unavailabilitiesId == null) {
			if (other.unavailabilitiesId != null)
				return false;
		} else if (!unavailabilitiesId.equals(other.unavailabilitiesId))
			return false;
		return true;
	}

	
	
	

}
