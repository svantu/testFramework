package BrowserManager;

public class DriverManagerFactory {

	
	public static DriverManager getManager(DriverType type) {
		if(type==type.CHROME) {
			return new ChromeDriverManager();
		}
		else if(type==type.FIREFOX) {
			return  new FireFoxDriverManager();
		}else if(type == type.INTERNETEXPLORER)
			return new IEDriverManager();
		return null;
	}



}
