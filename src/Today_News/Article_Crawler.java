package Today_News;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Article_Crawler {

	public void article_crawling(String URL) throws IOException {
		
		Document doc = Jsoup.connect(URL).get();

		Elements elements_article_text = doc.select("div.content div._article_body_contents");
		Elements elements_article_title = doc.select("div.content div.article_header div.article_info h3");
		Elements elements_article_time = doc.select("div.content div._article_header div.article_info span.t11");
		
		
		String delet_tag = "[<].*[>]";
		
		for(Element element : elements_article_text) { //����
			
			System.out.println(element.toString().replaceAll(delet_tag, "").replace("function _flash_removeCallback() {}", "").replace("// flash ������ ��ȸ�ϱ� ���� �Լ� �߰�", ""));
			
		}
		System.out.println(elements_article_title.toString().split("<h3 id=\"articleTitle\">")[1].split("</h3>")[0]); //����
		System.out.println(elements_article_time.toString().split("<span class=\"t11\">")[1].split("</span")[0]); //����Է� �ð�
	}
	
}
