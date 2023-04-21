package com.inops.computation;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Tblmuster")
public class MusterTable {

	@EmbeddedId
	private MusterId musterId;

	@Transient
	private String empName;
	@Transient
	private String department;
	@Transient
	private String cdare;

	@Column(name = "Shiftid")
	private String ShiftId;

	@Column(name = "Attid")
	private String attendanceId;

	@Column(name = "Leavetypeid")
	private String leaveTypeId;

	@Column(name = "Hrsworked")
	private int hoursWorked;

	@Column(name = "Extrahours")
	private int extraHours;

	@Column(name = "Latepunch")
	// private int latePunch;
	private String latePunch;

	@Column(name = "Earlyout")
	private int earlyOut;

	@Column(name = "Firstin")
	private String firstInPunch;

	@Column(name = "Lastout")
	private String lastOutPunch;

	@Column(name = "lunchout")
	private String lunchOut;

	@Column(name = "lunchin")
	private String lunchIn;
	
	@Transient
	private LocalDate attendanceDate;

}
