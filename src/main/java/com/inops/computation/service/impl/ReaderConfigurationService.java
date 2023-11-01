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
@Service("readerConfigurationService")
public class ReaderConfigurationService implements IReaderOperation {

	private final Checksum checksum;
	private Reader reader;

	@Override
	public List<byte[]> SetReader(Reader reader) {
		try {
			log.info("Reader data generation started");
			List<Byte> message = new ArrayList<>();
			byte[] buffer = new byte[1024];
			int count = 0;

			message.add((byte) Integer.parseInt(reader.getValidationMode()));
			message.add((byte) reader.getIo().charAt(0));
			message.add((byte) (reader.isFingerEnable() ? 1 : 0));
			message.add((byte) (reader.isKeyEnable() ? 1 : 0));
			message.add((byte) (reader.isDiplayEnable() ? 1 : 0));
			message.add((byte) Integer.parseInt(reader.getControlDevice()));

			String cc1Ips[] = reader.getCc1().split("\\.");
			for (int x = 0; x < cc1Ips.length; x++) {
				message.add((byte) (Integer.parseInt(Integer.toHexString(Integer.valueOf(cc1Ips[x])), 16) & 0xff));
			}
			String cc2Ips[] = reader.getCc2().split("\\.");

			for (int x = 0; x < cc2Ips.length; x++) {
				message.add((byte) (Integer.parseInt(Integer.toHexString(Integer.valueOf(cc2Ips[x])), 16) & 0xff));
			}
			message.add((byte) Integer.parseInt(reader.getRunningCc()));

			count = message.size() + 2;

			buffer[0] = 0x2; // STX
			buffer[1] = (byte) (count >> 8); // MSB
			buffer[2] = (byte) count; // LSB
			buffer[3] = 0x15; // CMD

			log.info("Reader data generation completed");

			return checksum.add(message, 4, buffer);

		} catch (Exception e) {
			log.error("Reader Configuration Error {}",  e);
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
		try {
			log.info("GetReader data generation started");
			List<byte[]> data = new ArrayList<byte[]>();
			byte[] buffer = new byte[] { 0x02, 0x0, 0x2, 0x14, (byte) 0xEA, 0x3 };
			data.add(buffer);
			log.info("GetReader data generation completed");
			return data;
		} catch (Exception e) {
			log.error("Get Reader Configuration Exception {}", e);
		}
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
