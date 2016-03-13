import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadCommonFile {
	public Properties prop;
  public ReadCommonFile (){
	  try{
    this.prop = new Properties();
    String fileName = "Common.cfg";
    InputStream is = new FileInputStream(fileName);
    prop.load(is);
	  }
	  catch (Exception e){
		  System.out.println(e);
	  }
  }
  public String getProperty(String key){
	  String propertyValue = this.prop.getProperty(key);
	  return propertyValue;
  }
}