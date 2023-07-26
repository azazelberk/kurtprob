import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
class Result {
    public static int uniqueWolfs(List<Integer> arr) {
        int [] ids = { 0, 0, 0, 0, 0 };
        int maxId = 4;
        for (int i = 0; i < arr.size(); i++) {
            int currentId = arr.get(i);
            ids[currentId - 1]++;
            if (ids[currentId - 1] >= ids[maxId] && currentId < maxId) {
                maxId = currentId;
            }
        }
        return maxId;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(/*new FileWriter(System.getenv("OUTPUT_PATH"))*/new OutputStreamWriter(System.out));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(toList());
        int result = Result.uniqueWolfs(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
