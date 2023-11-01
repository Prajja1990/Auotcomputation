package com.inops.computation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

	private String cc1;
	private String cc2;
	private String runningCc;
	private String validationMode;
	private String controlDevice;
	private String io;
	private String readerIp;
	private int readerPort;
	private boolean fingerEnable;
	private boolean keyEnable;
	private boolean diplayEnable;
}
