public class peerProcess
{

		public static final fileSplit f = new fileSplit("/home/battery-issues/Documents/Project/test10Mb.db");
	public peerProcess()
	{
		
	}
	public static void main(String[] args) throws Exception
	{
		try
		{
			if(args[0].equals("1001"))
			{
				f.readInpFile();
			}
        peerProcess main = new peerProcess();
        f.mkdir(args[0]);
		}
		catch(Exception ex)
		{
			System.out.println(ex.toString());
		}
	}
}
