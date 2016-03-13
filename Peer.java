import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Peer
{
	public String ID;
	public String IP_ADD;
	public String port;
	public String bitfield;
	public int NUMBEROFCHUNKS;
	private peerConnect pc;	
	public Peer(peerConnect pc)
	{
		this.pc = pc;
		this.ID = pc.getID();
		this.IP_ADD = pc.getIPaddress();
		this.port = pc.getPort();
		this.bitfield = pc.getBitfield();
		this.NUMBEROFCHUNKS = pc.getNumberOfChunks();
	}
}