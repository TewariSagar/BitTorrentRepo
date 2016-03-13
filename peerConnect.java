import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

public class peerConnect
{
	private static String peerID;
	//private String[] recTokens;
	public HashMap<String, List<String>> returnHM
;	public String FILESIZE;
	public String PIECESIZE;
	public String LISTENINGPORT;
	private CopyOnWriteArrayList<Peer> pList;
	private List<String> getFromHashmap;
	private int NUMBEROFCHUNKS;
	 public peerConnect(String peerID)
	{
		this.peerID = peerID;
		returnHM = new HashMap<String, List<String>>();
		readPeerInfo pInfo = new readPeerInfo();
		ReadCommonFile rcf = new ReadCommonFile();	
		FILESIZE= rcf.getProperty("FileSize");
		PIECESIZE = rcf.getProperty("PieceSize");
		returnHM = pInfo.getConfigurationPeerInfo();
		getFromHashmap = new ArrayList<String>();
		getFromHashmap = returnHM.get(peerID);
		LISTENINGPORT = getFromHashmap.get(2);
		NUMBEROFCHUNKS = Integer.parseInt(FILESIZE)/Integer.parseInt(PIECESIZE);
		// /System.out.println(Filesize + " " + Piecesize);
	}

	public void startingPeer()
	{
		    pList = new CopyOnWriteArrayList<Peer>();
		    Peer nayaPeer = new Peer(this);
		    pList.add(nayaPeer);
		    // System.out.println(pList.get(0).ID);
	}
	public String getIPaddress()
	{
		return getFromHashmap.get(1);
	}

	public String getID()
	{
		return getFromHashmap.get(0);
	}

	public String getPort()
	{
		return getFromHashmap.get(2);
	}

	public String getBitfield()
	{
		return getFromHashmap.get(3);
	}

	public int getNumberOfChunks()
	{
		return NUMBEROFCHUNKS;
	}
}

