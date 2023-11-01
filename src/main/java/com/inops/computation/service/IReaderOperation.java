package com.inops.computation.service;

import java.util.List;

import com.inops.computation.model.Reader;

public interface IReaderOperation {

	public List<byte[]> SetReader(Reader reader);

	public List<byte[]> ClearReader(Reader reader);

	public List<byte[]> GetReader(Reader reader);

	public boolean RetriveReader(List<byte[]> readers);

	public List<byte[]> OnlineReader(List<byte[]> readers);

	public boolean ReaderResponse(List<byte[]> readers);

	public int punchcount(List<byte[]> readers);

}
