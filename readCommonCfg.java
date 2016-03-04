
public class readCommonCfg
{
	public String preferredNeighbors; 
	public String unchokingInterval;
	public String optimisticUnchoke;
	public String filename;
	public String filesize;
	public String chunksize;

public readCommonCfg(String preferredNeighbors, String unchokingInterval, String optimisticUnchoke, String filename, String filesize, String chunksize)
{
	this.preferredNeighbors = preferredNeighbors;
	this.unchokingInterval = unchokingInterval;
	this.optimisticUnchoke = optimisticUnchoke;
	this.filename = filename;
	this.filesize = filesize;
	this.chunksize = chunksize;
	//System.out.println("NumberOfPreferredNeighbors " + preferredNeighbors);
	//System.out.println("UnchokingInterval " + unchokingInterval);
	//System.out.println("OptimisticUnchokingInterval " + optimisticUnchoke); 
	//System.out.println("FileName " + filename);
	//System.out.println("FileSize " + filesize);
	//System.out.println("PieceSize " + chunksize);
}	 
}
