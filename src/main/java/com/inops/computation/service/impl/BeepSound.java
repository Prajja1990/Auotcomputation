package com.inops.computation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inops.computation.model.Reader;
import com.inops.computation.service.IReaderOperation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Log4j2
@RequiredArgsConstructor
@Service("beepSoundService")
public class BeepSound implements IReaderOperation {

	@Override
	public List<byte[]> SetReader(Reader reader) {
		try {
			List<byte[]> data = new ArrayList<byte[]>();
			byte[] buffer = new byte[] { 0x02, 0x00, 0x02, 0x10, (byte) 0xee, 0x03 };
			data.add(buffer);
			return data;
		} catch (Exception e) {
			log.error("Beep Sound Exception {}", e);
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
