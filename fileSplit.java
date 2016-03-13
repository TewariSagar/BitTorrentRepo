import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class fileSplit
{
	String inpFile;
	byte[] chunkarr;
	FileInputStream f = null;
	private static int chunkSize = 32768;
	HashMap<Integer, String> h = new HashMap<Integer, String>();
 	public fileSplit(String inpFile)
	{
		this.inpFile = inpFile;
	}

	public void readInpFile(String arg0) throws IOException
	{
		System.out.println("Owner is splitting the file......");
		chunkarr = new byte[chunkSize];
		int x = 0;
		int counter = 0;
		try
		{
			f  = new FileInputStream(inpFile);
			BufferedInputStream bis = new BufferedInputStream(f);
			
			while((x = bis.read(chunkarr, 0, chunkSize)) > 0)
			{
				try
				{
					File n = new File("/home/battery-issues/Documents/Project/peer_" + arg0, "test" + String.valueOf(counter) + ".db");
					FileOutputStream fo = new FileOutputStream(n);
					fo.write(chunkarr, 0, x);
					String value_string = "test" + String.valueOf(counter) + ".db";
					h.put(counter, value_string);
					counter++;
				}
				catch(IOException ex)
				{
					System.out.println(ex.toString());
				}
			}
			f.close();
		}
				catch(IOException ex)
				{
					System.out.println(ex.toString());
				}

	}



	public void printHashMap()
	{
		Set<Integer> keys = h.keySet();
		for (Integer key : keys)
	    System.out.println(key + " " + h.get(key));
	}

	public void mkdir(String peername)
	{
			File file = new File("peer_"+ peername);
			if (!file.exists()) 
			{
				if (file.mkdir()) 
				{
					System.out.println("Directory was not found");
					System.out.println("Directory is created!");
				} else 
				{
					System.out.println("Failed to create directory!");
				}
			}
		}
}
