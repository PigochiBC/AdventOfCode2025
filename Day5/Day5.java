import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Day5 {
    public static void main(String[] args) {
        ArrayList<String> data = getDataFromFile("Day5.txt");

        //first sort the ranges by min
        ArrayList<long[]> ranges = new ArrayList<>();   
        for(String range : data) {
            String[] parts = range.split("-");
            long min = Long.parseLong(parts[0]);
            long max = Long.parseLong(parts[1]);
            // Store or process min and max as needed
            ranges.add(new long[]{min, max});

        }
        // Now sort the ranges based on the min value
        ranges.sort((a, b) -> Long.compare(a[0], b[0]));
        mergeOverlappingRanges(ranges);
        long count = 0;
        for(long[] range : ranges) {
           count+= range[1] - range[0] + 1;
        }
        System.out.println(count);
    }
    public static void mergeOverlappingRanges(ArrayList<long[]> ranges) {
        // Implementation for merging overlapping ranges goes here
        for(int i = 1; i < ranges.size(); i++) {
            long[] current = ranges.get(i);
            long[] previous = ranges.get(i - 1);
            if(current[0] <= previous[1]) {
                // Overlapping ranges, merge them
                previous[1] = Math.max(previous[1], current[1]);
                ranges.remove(i);
                i--; // Adjust index after removal
            }
        }
        // Print merged ranges
        for(long[] range : ranges) {
            System.out.println(range[0] + "-" + range[1]);
        }
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