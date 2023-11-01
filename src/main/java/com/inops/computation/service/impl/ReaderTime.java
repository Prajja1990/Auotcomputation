package com.inops.computation.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
@Service("readerTimeService")
public class ReaderTime implements IReaderOperation {

	private final Checksum checksum;

	SimpleDateFormat dateFormate = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmss");
	Calendar cal = Calendar.getInstance();

	@Override
	public List<byte[]> SetReader(Reader reader) {
		int count = 0;
		byte[] buffer = new byte[1024];
		List<Byte> dateTime = new ArrayList<Byte>();
		List<byte[]> data = new ArrayList<byte[]>();
		try {
			List<String> datelist = format();
			count = datelist.size() + 2; // Total Count
			buffer[0] = 0x02; // STX
			buffer[1] = (byte) (count >> 8); // MSB
			buffer[2] = (byte) count; // LSB
			buffer[3] = 0x12; // CMD

			for (String part : datelist) {
				String str = Integer.toHexString(Integer.parseInt(part));
				dateTime.add((byte) (Integer.parseInt(str, 16) & 0xff));
			}

			data = checksum.add(dateTime, 4, buffer);
		} catch (Exception e) {
			log.error("Date Time Exception {}", e);
		}
		return data;
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

	private List<String> format() {
		Date toDay = new Date();
		String date = dateFormate.format(toDay);
		String time = timeFormat.format(toDay);
		cal.setTime(toDay);
		int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		String weekDay = String.format("%02d", week);
		String format = date + "" + weekDay + "" + time;

		return getParts(format, 2);
	}

	private static List<String> getParts(String string, int partitionSize) {
		List<String> parts = new ArrayList<String>();
		int len = string.length();
		for (int i = 0; i < len; i += partitionSize) {
			parts.add(string.substring(i, Math.min(len, i + partitionSize)));
		}
		return parts;
	}

}
