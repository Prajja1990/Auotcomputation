package com.inops.computation.util;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service("socket")
@Log4j2
public class SocketConnection {

	 public int clientSocket(List<byte[]> data, String readerip){
	        byte[] response = new byte[1024];
	        int i = 0;
	        try {
	        	
	        	 Socket socket = new Socket(readerip, 2500);
	 	        try (DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream()) ) {
	 	        	        	
	 	            socket.setSoTimeout(3000);
	 	            
	 	            for (int x = 0; x < data.size(); x++) {
	 	                byte[] readerconfig = data.get(x);
	 	                outputStream.write(readerconfig);
	 	                outputStream.flush();
	 	            }
	 	            i = 1;
	 	        } catch (Exception e) {
	 	        	log.error("Socket Exception {}", e);
	 	        }
				
			} catch (Exception e) {
				log.error("Socket Exception {}", e);
			}
	       
	        return i;
	    }
}
