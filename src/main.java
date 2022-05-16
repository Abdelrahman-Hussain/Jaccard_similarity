import java.io.File;
import java.io.IOException;
import java.util.*;
import javafx.util.Pair;

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
        Vector<Pair<Double,String>> test= new Vector<Pair<Double,String>>();
        for (int i = 0; i < docs.length; i++) {
            main.jaccard(query,docs[i]);
        }

    }
}
