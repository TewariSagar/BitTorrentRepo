import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;
import java.net.*;

public class peerConnect extends Thread
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
	private Boolean peerFlag;
	private ServerSocket serverSocket;
	private ArrayList<String> temp; 
	private String tempSERVERNAME;
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
		    //Start the peer thread to make it work with other peers
		    // System.out.println(pList.get(0).ID);
		    nayaPeer.start();
		    if(peerID.equals("1001"))
		    {}
			else
			retrievePeerInfo();
		    peerFlag = true;
	}

	public void retrievePeerInfo()
	{
		int tempPort;
		String tempIP;
		Map<String, List<String>> map = new TreeMap<String, List<String>>(returnHM);
		Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()) {
              Map.Entry me2 = (Map.Entry)iterator2.next();
              temp = new ArrayList<String>();
              if(me2.getKey().equals(peerID))
              	break;
              else
              {
              	System.out.println(me2.getValue());
              	temp = (ArrayList<String>)me2.getValue();
              	tempPort = Integer.parseInt(temp.get(2));
              	tempIP = temp.get(1);
              	makeConnection(tempPort, tempIP);
              	//System.out.print(me2.getKey() + ": ");
              	//System.out.println(me2.getValue());
          	  }
          }
	}

	public void makeConnection(int port, String serverName)
	{
		tempSERVERNAME = "localhost";
		try
		{
			Socket client = new Socket(tempSERVERNAME, port);
			System.out.println("Just connected to "  + client.getRemoteSocketAddress());
		}
		catch(IOException e)
      	{
         	e.printStackTrace();
      	}
	}

	// logic to maka a background process that waits for other incoming peer connections
	@Override
	public void run()
	{
		try
        {
         	serverSocket = new ServerSocket(Integer.parseInt(LISTENINGPORT));
      		serverSocket.setSoTimeout(15000);
      		System.out.println("Waiting for Peers on port " + serverSocket.getLocalPort() + "...");
			while(peerFlag)
      		{
         		Socket server = serverSocket.accept();
            	System.out.println("Just connected to " + server.getRemoteSocketAddress());
            	/*DataInputStream in = new DataInputStream(server.getInputStream());
            	System.out.println(in.readUTF());
            	DataOutputStream out = new DataOutputStream(server.getOutputStream());*/
            	//out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
            	//server.close();
         	}
         }
         catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
         }
         catch(IOException e)
         {
            e.printStackTrace();
         }
     
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

