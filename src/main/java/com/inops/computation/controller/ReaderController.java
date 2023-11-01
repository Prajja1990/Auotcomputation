package com.inops.computation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inops.computation.model.Reader;
import com.inops.computation.service.IReaderOperation;
import com.inops.computation.util.SocketConnection;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReaderController {

	private final IReaderOperation readerConfigurationService, turnstileModeService, beepSoundService,
			readerTimeService;
	private final SocketConnection socket;

	private List<byte[]> data;

	@PostMapping("/setReader")
	private List<byte[]> setReader(@RequestBody Reader reader) {
		data = readerConfigurationService.SetReader(reader);
		socket.clientSocket(data, reader.getReaderIp());
		return data;
	}

	@PostMapping("/setTurnstile")
	private List<byte[]> setTurnstile(@RequestBody Reader reader) {
		data = turnstileModeService.SetReader(reader);
		socket.clientSocket(data, reader.getReaderIp());
		return data;
	}

	@PostMapping("/setBeep")
	private List<byte[]> setBeep(@RequestBody Reader reader) {
		data = beepSoundService.SetReader(reader);
		socket.clientSocket(data, reader.getReaderIp());
		return data;
	}

	@PostMapping("/setTime")
	private List<byte[]> setTime(@RequestBody Reader reader) {
		data = readerTimeService.SetReader(reader);
		socket.clientSocket(data, reader.getReaderIp());
		return data;
	}
}
