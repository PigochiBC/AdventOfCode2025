import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<String> data = getDataFromFile("Day4.txt");
        ArrayList<ArrayList<String>> data2 = new ArrayList<>();
        for(String str: data){
            ArrayList<String> temp = new ArrayList<>();
            for(int i = 0; i < str.length();i++){
                temp.add(str.substring(i,i+1)); 
            }
            data2.add(temp);
        }
        //row column traversal
        int sum = 0;
        boolean foundRemovable = true;
        while(foundRemovable){
            foundRemovable = false;
            ArrayList<String> removableIndexes = new ArrayList<>();
            for(int i = 0; i < data2.size(); i++){
                for(int j = 0; j < data2.get(i).size(); j++){
                    //check each adjacent, skip error
                    int count = 0;
                    if(!data2.get(i).get(j).equals("@"))continue;
                    for(int x = 0; x<8; x++){
                        //start at top left, go to middle left counter clockwise
                        try{
                            switch(x){
                                case 0:
                                    if(data2.get(i-1).get(j-1).equals("@"))count++;
                                    break;
                                case 1:
                                    if(data2.get(i-1).get(j).equals("@"))count++;
                                    break;
                                case 2:
                                    if(data2.get(i-1).get(j+1).equals("@"))count++;
                                    break;
                                case 3:
                                    if(data2.get(i).get(j+1).equals("@"))count++;
                                    break;
                                case 4:
                                    if(data2.get(i+1).get(j+1).equals("@"))count++;
                                    break;
                                case 5:
                                    if(data2.get(i+1).get(j).equals("@"))count++;
                                    break;      
                                case 6:
                                    if(data2.get(i+1).get(j-1).equals("@"))count++;
                                    break;
                                case 7:
                                    if(data2.get(i).get(j-1).equals("@"))count++;
                                    break;
                            }
                        }catch(Exception e){
                            continue;
                        }
                    }
                    if(count<4){
                        System.out.println("VALID FOUND AT : " + i  + "," + j);
                        removableIndexes.add(i + "," + j);
                        foundRemovable = true;
                        sum++;
                    }

                }
            }
            for(String str: removableIndexes){
                String[] strSplit = str.split(",");
                int row = Integer.parseInt(strSplit[0]);
                int col = Integer.parseInt(strSplit[1]);
                data2.get(row).set(col,"x");
            }
        }
        
        System.out.println(sum);
    }   
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
