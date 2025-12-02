import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
public class Day2 {
    public static void main(String[] args) {
       ArrayList<String> data = getDataFromFile("Day2.txt");
       long sum = 0;
       for(String line: data){
            //separate each line into two parts
            String[] parts = line.split("-");
            long min = Long.parseLong(parts[0]);
            long max = Long.parseLong(parts[1]);
            for(long i = min; i <= max; i++){
                //check repeating digits from 0 to length of number and only increase sum if whole string is made of repeating digits
                String numStr = Long.toString(i);
                //for loop not working properly, needs fixing
                for(int j = 1; j < numStr.length(); j++){
                    boolean allSame = true;
                    if(numStr.length()%j != 0){
                        //num length is not divisible by j, skip
                        continue;
                    }else{
                        //check if all j digits in the number are the same
                        
                        long toCheck = Long.parseLong(numStr.substring(0,j));
                        
                        for(int k = 0; k < numStr.length(); k+=j){
                            long currentPart = Long.parseLong(numStr.substring(k, Math.min(k+j, numStr.length())));
                            
                            if(currentPart != toCheck){
                                allSame = false;
                                break;
                            }
                        }
                    }
                    if(allSame){
                        System.out.println(i);
                        sum += i;
                        break;
                    }
                }
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
                for(String part : line.split(",")) {
                    data.add(part.trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}