import java.io.File;
import java.io.IOException;
import java.util.*;
import javafx.util.Pair;
import java.util.Collections;


public class main {
    public  double jaccard(String query,String doc) {
        HashSet<String> d1=new HashSet<>();
        HashSet<String> d2=new HashSet<>();
        String[] arr1 = query.split(" ");
        try{
            Scanner s = new Scanner(new File(doc));
            ArrayList<String> arr2 = new ArrayList<String>();
            while (s.hasNext()){
                arr2.add(s.next());
            }
            s.close();
            for (int i = 0; i < arr1.length; i++) {
                d1.add(arr1[i].toLowerCase());
            }
            for (int i = 0; i < arr2.size(); i++) {
                d2.add(arr2.get(i).toLowerCase());
            }
            HashSet<String> intersect=new HashSet<>(d1);
            intersect.retainAll(d2);

            HashSet<String> union=new HashSet<>(d1);
            union.addAll(d2);
            return  (double)intersect.size()/(double)union.size();
        }
        catch (Exception e){
            System.out.println("error");
        }
        return 0;
    }

    public static void main(String args[]) {
        main main= new main();
        System.out.println("enter your query");
        String query;
        Scanner input = new Scanner(System.in);
        query=input.nextLine();
        String []docs=new  String[]{
                "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\100.txt",
                    "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\101.txt",
                    "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\102.txt",
                    "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\103.txt",
                    "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\104.txt",
                    "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\105.txt",
                    "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\106.txt",
                    "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\107.txt",
                    "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\108.txt",
                    "D:\\FCAI\\3rd year\\second term\\Information Retrieval\\assignment\\1\\docs\\109.txt"

        };
        double []values= new double[docs.length];
        String []docsPath= new String[docs.length];

        double []resultValues= new double[docs.length];
        String []resultDocsPath= new String[docs.length];


        for (int i = 0; i < docs.length; i++) {
            values[i]=main.jaccard(query,docs[i]);
            docsPath[i]=docs[i];
        }
        int lenght = docs.length;
        for (int i = 0; i < lenght; i++) {
            double max = 0;
            int maxIndex=0;
            for (int j = 0; j < docs.length; j++) {
                if(values[j]>max){
                    max=values[j];
                    maxIndex=j;
                }
            }
            resultValues[i]=max;
            resultDocsPath[i]=docsPath[maxIndex];

            values[maxIndex]=0;
        }
        for (int i = 0; i < docs.length; i++) {
            System.out.print(String.format("%.5f",resultValues[i])+"   ");
            System.out.println(resultDocsPath[i]);
        }

    }
}
