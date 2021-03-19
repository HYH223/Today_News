package Today_News;

import java.util.ArrayList;
import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

public class Title_Analysis {

	public ArrayList<String> Text_Analysis(String Content_Text) {
		
	    Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
//	    String strToAnalyze = "����������μ��������� ����'����ȣ����' �ҳ��� ���Ϸ��� �";
	
	    KomoranResult analyzeResultList = komoran.analyze(Content_Text);
//	    KomoranResult analyzeResultList = komoran.analyze(strToAnalyze);
	
//	    System.out.println(analyzeResultList.getPlainText());
	
	    List<Token> tokenList = analyzeResultList.getTokenList();
	    ArrayList<String> keyWord = new ArrayList<String>();
	    
	    for (Token token : tokenList) {
	//        System.out.format("(%2d, %2d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());
	        if(token.getPos().equals("NNP")) {
//	        	System.out.println(token.getMorph()+token.getPos());
	        	keyWord.add(token.getMorph());
	        }        
        }
	    return keyWord;
    }
}