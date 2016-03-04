import java.io.*;
import java.util.*;

public class readPeerInfo
{
	public HashMap<String, List<String>> hm;
	public HashMap<String, List<String>> getConfigurationPeerInfo()
	{
		
		//peerInfoVector = new Vector<RemotePeerInfo>();
		String st;
		int i1;
		//read the peerInfo.cfg file and set the variables
		hm = new HashMap<String, List<String>>();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("PeerInfo.cfg"));
			while((st = in.readLine()) != null) 
			{
				List<String> arr = new ArrayList<String>();
				String[] tokens = st.split("\\s+");
			    	 //System.out.println("tokens begin ----");
				     //for (int x=0; x<tokens.length; x++) {
				     //    System.out.println(tokens[x]);
				     //}
			         //System.out.println("tokens end ----");
				for(int  i = 0; i < tokens.length ; i++)
				{
					arr.add(tokens[i]);	
				}				
				//System.out.println(arr);
				hm.put(tokens[0], arr);	  
				//System.out.println(hm);              		    
			}
			
			in.close();
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return hm;
	}
}
