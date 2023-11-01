package com.inops.computation.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Log4j2
@Service("checksum")
public class Checksum {

	private List<byte[]> data;

	public List<byte[]> add(List<Byte> message, int startsat, byte[] further) {
		try {
			data = new ArrayList<byte[]>();
			byte checksum = 0;
			for (int x = 0; x < message.size(); x++) {
				further[startsat++] = (byte) message.get(x);
			}
			for (int y = 1; y < further.length; y++) {
				checksum = (byte) (checksum + further[y]);
			}
			checksum = (byte) (~checksum + 1);
			further[startsat++] = (byte) checksum;
			further[startsat] = 0x03;

			data.add(further);
		} catch (Exception e) {
			log.error("Checksum exception {}", e);
		}

		return data;
	}
}
