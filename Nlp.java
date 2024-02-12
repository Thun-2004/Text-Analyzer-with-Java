import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

public class Nlp{
  public static void clean(ArrayList<String> list) {
    ArrayList<String> useless = new ArrayList<>();
    
    useless.add("the");
    useless.add("a");
    useless.add(".");
    useless.add(",");
    ArrayList<String> beingRemoved = new ArrayList<>();
    for (int index = list.size()-1 ; index >= 0; index--) {
      for (int i = useless.size()-1; i >= 0 ; i--){
        if (list.get(index).equals(useless.get(i))) {
          beingRemoved.add(list.get(index));
        }
      }
    }
    list.removeAll(beingRemoved);
    
  }

  public static void addValues(HashMap<String, Double> positiveWords, HashMap<String, Double> negativeWords, HashMap<String, Double> neutralWords){
        //each word is given an emotion intensity from  -4(very negative) to 4 (very positive) and We're trying to choose domain-specific sentiment opinion words to increase the accuracy.
        //the score as a value is not a reliable figure because the actual number should be calculated from multipla layers of neural networks. So this is just a demonstration of how it roughly works.
      //Each Hashmap contains the mapping between key(word) and value(emotion intensity but this in from our opinion , you can try to adjust it)
        positiveWords.put("support",4.0);
        positiveWords.put("favorably",4.0);
        positiveWords.put("like",4.0);
        positiveWords.put("resilience",2.0);
        positiveWords.put("promote",4.0);
        positiveWords.put("attention",2.0);
        positiveWords.put("reliable",2.0);
        positiveWords.put("benefits",2.0);
        positiveWords.put("large",3.0);
        positiveWords.put("audience",3.0);
        positiveWords.put("better",3.0);
        positiveWords.put("propose",1.0);
        positiveWords.put("advocate",4.0);
        positiveWords.put("initiative",3.0);
        positiveWords.put("develop",3.0);

        negativeWords.put("unsure",-1.5);
        negativeWords.put("no",-3.0);
        negativeWords.put("not",-3.0);
        negativeWords.put("not to",-4.0);
        negativeWords.put("tough",-1.5);
        negativeWords.put("disgrace",-3.0);
        negativeWords.put("impeach",-4.0);
        negativeWords.put("inequality",-2.0);
        negativeWords.put("avoid",-3.0);
        negativeWords.put("no one",-2.0);
        negativeWords.put("wrong",-3.0);
        negativeWords.put("get rid of",-3.0);
        negativeWords.put("getting rid of",-3.0);
        negativeWords.put("concern",-1.0);
        negativeWords.put("issue",-1.0);
        negativeWords.put("exploit",-2.0);
        negativeWords.put("unemployment",-2.0);
        negativeWords.put("scandal",-3.0);

        neutralWords.put("think",0.1);
        neutralWords.put("consider",0.1);
        neutralWords.put("feel",0.1);
        neutralWords.put("ok",0.1);
        neutralWords.put("not bad",0.1);
        neutralWords.put("suggest",0.1);
        neutralWords.put("claim",0.1);
        neutralWords.put("assume",0.1);
        neutralWords.put("discuss",0.1);
        neutralWords.put("evaluate",0.1);
        neutralWords.put("fairly",0.1);
        neutralWords.put("factual",0.1);
        neutralWords.put("statement",0.1);
        neutralWords.put("viewpoint",0.1);
        neutralWords.put("neutral",0.1);
        neutralWords.put("equal",0.1);
        neutralWords.put("judgement",0.1);
        neutralWords.put("fair",0.1);

    }

    public static double getScore(HashMap<String, Double>sentimentList, ArrayList<String> text) {
        double score = 0;
        for(String word:  sentimentList.keySet()){
            for(int j = 0; j < text.size(); j++){
                if (word.equals(text.get(j))){
                    score += sentimentList.get(word);
                }
            }
        }

        return score;
    }

    public static void analyzeScore(double totalScore){
        //this equation is the same one that is used in VADER Sentiment Analysis
        //15 is a normalization parameter
        //Generally the result will be ranged from -1(most negative) to 1(most positive)
        double evaluation = totalScore/Math.sqrt(Math.pow(totalScore, 2) + 15);
        System.out.println("Evaluated Score: " + evaluation);
        if(evaluation < -0.2){
            System.out.println("According to this website,people tend to have negative views towards Donald Trump");
        }else if(evaluation < 0.2){
            System.out.println("According to this website, people tend to have neutral views towards Donald Trump");
        }else {
            System.out.println("people have tend to have positive views towards Donald Trump");
        }
    }
}