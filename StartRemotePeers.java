/*
 *                     CEN5501C Project2
 * This is the program starting remote processes.
 * This program was only tested on CISE SunOS environment.
 * If you use another environment, for example, linux environment in CISE 
 * or other environments not in CISE, it is not guaranteed to work properly.
 * It is your responsibility to adapt this program to your running environment.
 */

import java.io.*;
import java.util.*;

/*
 * The StartRemotePeers class begins remote peer processes. 
 * It reads configuration file PeerInfo.cfg and starts remote peer processes.
 * You must modify this program a little bit if your peer processes are written in C or C++.
 * Please look at the lines below the comment saying IMPORTANT.
 */
public class StartRemotePeers {

	public Vector<RemotePeerInfo> peerInfoVector;
	public ArrayList<ArrayList<readCommonCfg>> list;
	public int counter = 1;

	public void getConfiguration()
	{
		String st;
		int i1;
		peerInfoVector = new Vector<RemotePeerInfo>();
		//read the common.cfg file and set the variables
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("PeerInfo.cfg"));
			while((st = in.readLine()) != null) {
				
				 String[] tokens = st.split("\\s+");
		    	 //System.out.println("tokens begin ----");
			     //for (int x=0; x<tokens.length; x++) {
			     //    System.out.println(tokens[x]);
			     //}
		         //System.out.println("tokens end ----");
			    
			     peerInfoVector.addElement(new RemotePeerInfo(tokens[0], tokens[1], tokens[2]));
			
			}
			
			in.close();
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	public void readCommonFile()
	{
		String st;
		list = new ArrayList<ArrayList<readCommonCfg>>();
		ArrayList<String> arr = new ArrayList<String>();
		 for(int i = 1; i < 8; ++i) {
            list.add(new ArrayList<readCommonCfg>());
        }
		try {
			BufferedReader input = new BufferedReader(new FileReader("Common.cfg"));
			while((st = input.readLine()) != null) 
			{
				String[] tokens = st.split("\\s+");
				arr.add(tokens[1]);
			}

			list.get(counter).add(new readCommonCfg(arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4), arr.get(5)));
			input.close();
			counter++;
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			StartRemotePeers myStart = new StartRemotePeers();
			myStart.getConfiguration();
					
			// get current path
			String path = System.getProperty("user.dir");
			
			// start clients at remote hosts
			for (int i = 0; i < myStart.peerInfoVector.size(); i++) {
				RemotePeerInfo pInfo = (RemotePeerInfo) myStart.peerInfoVector.elementAt(i);
				
				System.out.println("Start remote peer " + pInfo.peerId +  " at " + pInfo.peerAddress );

				
				// *********************** IMPORTANT *************************** //
				// If your program is JAVA, use this line.
				Runtime.getRuntime().exec("ssh " + pInfo.peerAddress + " cd " + path + "; java peerProcess " + pInfo.peerId);
				myStart.readCommonFile();
				// If your program is C/C++, use this line instead of the above line. 
				//Runtime.getRuntime().exec("ssh " + pInfo.peerAddress + " cd " + path + "; ./peerProcess " + pInfo.peerId);
			}		
			System.out.println("Starting all remote peers has done." );

		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
