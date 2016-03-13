import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Peer extends Thread
{
	public String ID;
	public String IP_ADD;
	public String port;
	public String bitfield;
	public int NUMBEROFCHUNKS;
	private peerConnect pc;
	private Boolean infiniteRunning;
	public Peer(peerConnect pc)
	{
		this.pc = pc;
		this.ID = pc.getID();
		this.IP_ADD = pc.getIPaddress();
		this.port = pc.getPort();
		this.bitfield = pc.getBitfield();
		this.NUMBEROFCHUNKS = pc.getNumberOfChunks();
		this.infiniteRunning = true;
	}

	@Override
	public void run()
	{
		System.out.println("Thread sequence initiated");
		while(infiniteRunning)
		{
			//logic to implement what this thread does when other peers connect
		}
	}
}