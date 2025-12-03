import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day3{
    public static void main(String[] args) {
        ArrayList<String> data = getDataFromFile("Day3.txt");
        //find max for each
        long sum = 0;
        // for(String str : data){
        //     int maxOnes = 0;
        //     int maxTens = 0;
        //     int indexOfTens = 0;
        //     for(int i =0; i<str.length();i++){
        //         int numAtIndex = Integer.parseInt(str.substring(i,i+1));
        //         if(numAtIndex>maxTens && i!=str.length()-1){
        //             maxTens=numAtIndex;
        //             indexOfTens =i;
        //         }
        //         //edge case for biggest num at the end, make it ones place
        //         else if(numAtIndex>maxTens && i==str.length()-1)maxOnes=numAtIndex;
        //     }
        //     for(int j =indexOfTens; j<str.length();j++){
        //         int numAtIndex = Integer.parseInt(str.substring(j,j+1));
        //         if(numAtIndex>maxOnes && j!=indexOfTens)maxOnes=numAtIndex;
                
        //     }
        //     sum+=(maxTens*10)+maxOnes;
        // }
        for(String str : data){
            
            int indexOfSearch = 0;
            int minimumSearchRange = 0;
            //range of search limited to the length-place we're searching for (1e12 place can only search up to str.length()-12)
            for(int i = 1; i <=12; i++){
                
                int max = 0;
                for(int j = minimumSearchRange; j<str.length()-(11-indexOfSearch);j++){
                    
                    int numAtIndex = Integer.parseInt(str.substring(j,j+1));
                    if(numAtIndex>max){
                        max=numAtIndex;
                        minimumSearchRange = j+1;

                    }

                }
                indexOfSearch++;
                
                sum+=max*(Math.pow(10,(12-i)));
                System.out.println(sum);
            }
            
        }
        System.out.println(sum);
    }
    //get data from file
    public static ArrayList<String> getDataFromFile(String filePath) {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}