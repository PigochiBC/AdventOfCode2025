import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
public class Day1 {
    public static void main(String[] args) {
        ArrayList<String> data = getDataFromFile("Day1.txt");
        int start = 50;
        int times = 0;
        // for (String line : data) {
        //     int amount = Integer.parseInt(line.substring(1));
        //     start = (line.substring(0,1).equals("R") ? start-amount : start+amount);
        //     if(start%100==0)times++;
            
        // }
        for(String line: data){
            int amount = Integer.parseInt(line.substring(1));
            String lOrR = line.substring(0,1);
            for(int i = 0; i < amount; i++){
                start+=(lOrR.equals("L") ? -1 : 1);
                if(start%100==0)times++;
            }
            
        }
        System.out.println(times);
        System.out.println(-758%100);
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