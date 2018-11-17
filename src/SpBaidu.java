import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class SpBaidu {
	public static String SpiderHolePage(String url) throws MalformedURLException {
		String urltmp = "https://"+url;
		String res = null;
		BufferedReader br = null;
		URL realUrl;
		try 
			{
			realUrl = new URL(urltmp);
			URLConnection connect = realUrl.openConnection();
			connect.connect();
			br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			String Line; 
			while ((Line= br.readLine())!= null) {
				res += Line;
				}
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} finally
				{
					try
					{
						if (br != null)
						{
							br.close();
						}
					} catch (Exception e2)
					{
						e2.printStackTrace();
					}
				}
		return res;
	}
	public static void splitprint(String  sentences) {
		for(int i=0; i<sentences.length()-300;i+=300) {
			System.out.println(sentences.substring(i, i+300));
		}
	}
	public static void main(String args[]) throws MalformedURLException {
		
		String  url = "www.sephora.com";
		//System.out.println(SpiderHolePage(url));
		splitprint(SpiderHolePage(url));
	}
}
