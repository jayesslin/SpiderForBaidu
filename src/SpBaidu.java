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
	//������ʽƥ��
	public static String RegexString(String targetStr, String patternStr) {
		  // ����һ����ʽģ�壬����ʹ��������ʽ����������Ҫץ������
		  // �൱�����������ƥ��ĵط��ͻ����ȥ
		  
		Pattern pattern = Pattern.compile(patternStr);
		  // ����һ��matcher������ƥ��
		  Matcher matcher = pattern.matcher(targetStr);
		  // ����ҵ���
		  if (matcher.find()) {
		   // ��ӡ�����
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
