public class peerProcess
{
	private static peerConnect pConnect;
	public static final fileSplit f = new fileSplit("/home/battery-issues/Documents/Project/test10Mb.db");
	public peerProcess(String peerID)
	{
	  pConnect = new peerConnect(peerID);	
	}
	public static void main(String[] args) throws Exception
	{
		try
		{
			if(args[0].equals("1001"))
			{
				f.readInpFile(args[0]);
			}
        peerProcess main = new peerProcess(args[0]);
        f.mkdir(args[0]);
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
		pConnect.startingPeer();

	}
}
