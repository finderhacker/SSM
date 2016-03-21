package ziji.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Test {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(33333);
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		/*BufferedInputStream is = new BufferedInputStream(s.getInputStream());
		
		byte[] b = new byte[1024];
		is.read(b, 0, 20);
		String str = new String(b,0, 20);*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str = br.readLine();
		System.out.printf("%s", str);
		
		
		OutputStream os = s.getOutputStream();
		os.write(123);
		
	}
}
