//We will check people's attitudes towards Donald trump using this website as an example
//reference VADER Sentiment Analysis --> https://medium.com/@piocalderon/vader-sentiment-analysis-explained-f1c4f9101cd9
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  
  public static void main(String args[]){
      //sentiment Lexicon
    
      HashMap<String, Double> positiveWords = new HashMap<>(); //create a matching weigh each words
      HashMap<String, Double> negativeWords = new HashMap<>();
      HashMap<String, Double> neutralWords = new HashMap<>();

      String url = "https://www.pbs.org/newshour/politics/poll-trump-should-be-charged-for-jan-6-about-half-of-americans-say";
      ArrayList<String> wordsList = new ArrayList<>();
    
      try { 
          Document document = Jsoup.connect(url).get();
          document = Jsoup.parse(document.outerHtml());
          String content = document.text(); //parsed 
          String[] words = content.split("\\W+");
          ArrayList<String> wordsList2 = new ArrayList<>(Arrays.asList(words)); 
          wordsList.addAll(wordsList2);
          
      } catch (Exception ex) {
          ex.printStackTrace();
      }

    
    
    Nlp.addValues(positiveWords, negativeWords, neutralWords);
    Nlp.clean(wordsList);

    double positiveScore = Nlp.getScore(positiveWords, wordsList);
    double negativeScore = Nlp.getScore(negativeWords, wordsList);
    double neutralScore = Nlp.getScore(neutralWords, wordsList);

    Nlp.analyzeScore(positiveScore + negativeScore + neutralScore);

  }

}




