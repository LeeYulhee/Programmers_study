import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int questionCount = Integer.parseInt(br.readLine());

        TreeSet<Integer> questionLevel = new TreeSet<>();
        Map<Integer, TreeSet<Integer>> questions = new HashMap<>();

        for(int i = 0; i < questionCount; i++) {
            String[] strArray = br.readLine().split(" ");

            int questionNum = Integer.parseInt(strArray[0]);
            int level = Integer.parseInt(strArray[1]);

            questionLevel.add(level);
            questions.computeIfAbsent(level, k -> new TreeSet<>()).add(questionNum);
        }

        int commandCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < commandCount; i++) {
            String[] strArray = br.readLine().split(" ");

            String command = strArray[0];

            switch(command) {
                case "add": int level = Integer.parseInt(strArray[2]);
                            int questionNum = Integer.parseInt(strArray[1]);
                            questionLevel.add(level);
                            questions.computeIfAbsent(level, k -> new TreeSet<>()).add(questionNum);
                            break;
                case "recommend": if(Integer.parseInt(strArray[1]) == 1) {
                                    int questionRecommend = questionLevel.last();
                                    System.out.println(questions.get(questionRecommend).last());
                                  } else {
                                    int questionRecommend = questionLevel.first();
                                    System.out.println(questions.get(questionRecommend).first());
                                  }
                                  break;
                case "solved": int solvedNum = 0;
                               int solvedQuestionNum = Integer.parseInt(strArray[1]);
                               for(Map.Entry<Integer, TreeSet<Integer>> entry : questions.entrySet()) {
                                   if(entry.getValue().floor(solvedQuestionNum) == null) {
                                       continue;
                                   }

                                   int closeQuestionNum = entry.getValue().floor(solvedQuestionNum);
                                   if(closeQuestionNum == solvedQuestionNum) {
                                       solvedNum = entry.getKey();
                                       break;
                                   }
                               } 
                               
                               questions.get(solvedNum).remove(solvedQuestionNum);
                               if(questions.get(solvedNum).isEmpty()) questionLevel.remove(solvedNum);
                               break;
            }
        }

    }
}