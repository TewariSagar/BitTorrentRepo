import java.io.*;
import java.util.*;

public class peerConnect
{
	private static String peerID;
	//private String[] recTokens;
	public HashMap<String, List<String>> returnHM;
	 public peerConnect(String peerID)
	{
		this.peerID = peerID;
		returnHM = new HashMap<String, List<String>>();
		readPeerInfo pInfo = new readPeerInfo();	
		returnHM = pInfo.getConfigurationPeerInfo();
		System.out.println(returnHM.get(peerID));
	}
	
	
	

	
			
	

}

