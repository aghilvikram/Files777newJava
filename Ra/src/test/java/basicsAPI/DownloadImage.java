package basicsAPI;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadImage {

	public static void main(String[] args) throws IOException {
		String downloadUrl="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAIAAAD8GO2jAAAA1UlEQVR4AWOwDp9LUzTELRi1wDdtaf+8w9sPXDtx7h4Q7Tt2c92OS9SxwCZibtesg0+fv3756i0aoo4FkxcdgxhHEwtiite8ePmGhhas3HIB2cRL1x5t3HV5xebzEEQFC67efAI3/cDxW7aR86icip6/QIRP9+xD1E+myOHTPv3AqAVA1DJ1/76jN+EI2YKLVx8hS+0+cgMY5yRbMHfVKbBxhNGFqw+B6mloweY9V2hrAbAIIceCugl7gE6DI2QTT124jyyVXrNxEKaiUQtGLRi1YNQCAMs01I34bbYCAAAAAElFTkSuQmCC";
		String fileName="C:\\Users\\QQA0431\\eclipse-workspace\\Ra\\newimage";
		/*URL url=new URL(downloadUrl);
		InputStream is=url.openStream();
		OutputStream os=new FileOutputStream(fileName);*/
		BufferedInputStream in=null;
		FileOutputStream fout=null;
		in=new BufferedInputStream(new URL(downloadUrl).openStream());
		fout=new FileOutputStream(fileName);
		byte[] buffer=new byte[1024];
		int count;
		
		while((count=in.read(buffer,0,1024))!=-1)
		{
			System.out.println(count);
			fout.write(buffer,0,count);
		}
		System.out.println(fileName);
		
		in.close();
		fout.close();
		}
		

	}


