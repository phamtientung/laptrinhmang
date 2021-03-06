import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AppEchoServer {

	public static void main(String[] args) {
		try {
			// mở cổng và bắt đầu nghe
			ServerSocket Socketserver = new ServerSocket(8888);
			System.out.println("I'm listening on 8888 port...");
			// luôn luôn lắng nghe
			while(true)
			{
					// khi có 1 yêu cầu tới, ,thì Accept
					// mở 1 Socket để làm viêc với client đó
					Socket socketClient =  Socketserver.accept();
				//  lấy về luồng xuất			
					OutputStream osTcClient = socketClient.getOutputStream();
					OutputStreamWriter Write2Client = new OutputStreamWriter(osTcClient);
					BufferedWriter buffwrite = new BufferedWriter(Write2Client);
					
					InputStream in = socketClient.getInputStream();
					InputStreamReader inReader = new InputStreamReader(in); 
					BufferedReader buffRead = new BufferedReader(inReader);
					// ===== giao tiếp theo giao thức thiết kế
					while(true)
					{
						// nhận dữ liệu
					String chuoinhan = buffRead.readLine();
					
					
					// in ra nếu muôn 
					// gửi trả
					String chuoigui = chuoinhan;
					buffwrite.write(chuoigui+"\n");
					buffwrite.flush();
					if(chuoigui.equals("Bye")) break;
					
					}	
					socketClient.close();
				}
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}


}
