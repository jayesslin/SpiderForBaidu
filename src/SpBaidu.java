import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SpBaidu {
	public static String getPage(String url) throws MalformedURLException {
		
		String res = null;
		BufferedReader br = null;
		URL realUrl;
		try 
			{
			realUrl = new URL(url);
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
	//正则表达式匹配
	public static String RegexString(String targetStr, String patternStr) {
		  // 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		  // 相当于埋好了陷阱匹配的地方就会掉下去
		  
		Pattern pattern = Pattern.compile(patternStr);
		  // 定义一个matcher用来做匹配
		  Matcher matcher = pattern.matcher(targetStr);
		  // 如果找到了
		  if (matcher.find()) {
		   // 打印出结果
		   return matcher.group(1);
		  }
		  return "Nothing";
		 }
	public static void main(String args[]) throws MalformedURLException {
		
		String  url = "https://www.sephora.com/new-makeup?icid2=meganav_new_justarrived_makeup_link";
		//System.out.println(SpiderHolePage(url));
		String res = getPage(url);
		String res1 = RegexString(res, "data-at=\"(.+?)\"");
		System.out.println(res1);
	}
}
