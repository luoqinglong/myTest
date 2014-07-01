/**
 * TODO
 */
package com.xeezee.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author luoqinglong
 * @date 2014-3-16
 * @url http://blog.csdn.net/showwair/article/details/7488523
 * @url http://www.iteye.com/topic/834447
 */
public class TestNIO
{

	private final Charset charset = Charset.forName("UTF-8");// 创建UTF-8字符集
	private SocketChannel channel;

	public void getHTMLContent()
	{
		try
		{
			this.connect();
			this.sendRequest();
			this.readResponse();
		}
		catch (IOException e)
		{
			System.err.println(e.toString());
		}
		finally
		{
			if (this.channel != null)
			{
				try
				{
					this.channel.close();
				}
				catch (IOException e)
				{
				}
			}
		}
	}

	private void connect() throws IOException
	{// 连接到CSDN
		InetSocketAddress socketAddress = new InetSocketAddress("http://www.csdn.net", 80);
		this.channel = SocketChannel.open(socketAddress);
		// 使用工厂方法open创建一个channel并将它连接到指定地址上
		// 相当与SocketChannel.open().connect(socketAddress);调用
	}

	private void sendRequest() throws IOException
	{
		this.channel.write(this.charset.encode("GET " + "/document" + "\r\n\r\n"));// 发送GET请求到CSDN的文档中心
		// 使用channel.write方法，它需要CharByte类型的参数，使用
		// Charset.encode(String)方法转换字符串。
	}

	private void readResponse() throws IOException
	{// 读取应答
		ByteBuffer buffer = ByteBuffer.allocate(1024);// 创建1024字节的缓冲
		while (this.channel.read(buffer) != -1)
		{
			buffer.flip();// flip方法在读缓冲区字节操作之前调用。
			System.out.println(this.charset.decode(buffer));
			// 使用Charset.decode方法将字节转换为字符串
			buffer.clear();// 清空缓冲
		}
	}

	public static void main(String[] args)
	{
		new TestNIO().getHTMLContent();
	}
}
