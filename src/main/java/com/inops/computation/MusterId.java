package com.inops.computation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
@ToString
@AllArgsConstructor
@Embeddable
public class MusterId implements Serializable{
	
	@Column(name = "empid")
	private String employeeId;

	@Column(name = "tdate")
	private Date attendanceDate;
}
