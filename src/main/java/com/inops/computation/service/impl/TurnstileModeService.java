package com.inops.computation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inops.computation.model.Reader;
import com.inops.computation.service.IReaderOperation;
import com.inops.computation.util.Checksum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Log4j2
@RequiredArgsConstructor
@Service("turnstileModeService")
public class TurnstileModeService implements IReaderOperation {

	private final Checksum checksum;

	private String controlDevice;

	@Override
	public List<byte[]> SetReader(Reader reader) {
		try {
			log.info("Turnstile data generation started");
			
			List<Byte> messsage = new ArrayList<Byte>();
			byte[] buffer = new byte[1024];
			int count = 3;

			buffer[0] = 0x02; // STX
			buffer[1] = (byte) (count >> 8); // MSB
			buffer[2] = (byte) count; // LSB
			buffer[3] = 0x25; // CMD

			messsage.add((byte) Integer.parseInt(controlDevice));
			log.info("Turnstile data generation completed");
			
			return checksum.add(messsage, 4, buffer);

		} catch (Exception e) {
			log.error("Turnstile Configuration Error {}", e);
		}
		return null;
	}

	@Override
	public List<byte[]> ClearReader(Reader reader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<byte[]> GetReader(Reader reader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean RetriveReader(List<byte[]> readers) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<byte[]> OnlineReader(List<byte[]> readers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ReaderResponse(List<byte[]> readers) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int punchcount(List<byte[]> readers) {
		// TODO Auto-generated method stub
		return 0;
	}

}
