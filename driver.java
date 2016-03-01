import java.util.*;
import java.io.*;

public class driver
{
	public static void main(String[] args) throws IOException
	{
		fileSplit f = new fileSplit("/home/battery-issues/Documents/Project/test10Mb.db");
		f.readInpFile();
		f.printHashMap();
	}
}