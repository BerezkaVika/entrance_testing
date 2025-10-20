// Задача 2. Ответ: 120


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data_prog_contest_problem_2.txt"));
            String line;
            boolean first_line = true;
            int[] parts = new int[507];
            while ((line = reader.readLine()) != null) {
                if (first_line) {
                    first_line = false;
                    continue;
                }
                String[] str_numbers = line.trim().split(" ");

                for (int i = 0; i < str_numbers.length; i++) {
                    int num = Integer.parseInt(str_numbers[i]);
                    parts[i] = num;
                }
            }
            reader.close();
            Set<Integer> found_letters  = new HashSet<Integer>();
            int idexOfLastLetter = -1;
            System.out.println();
            for (int i = 0; i < parts.length; i++) {

                if (1<= parts[i] &&  parts[i]<=26) {
                    found_letters.add(parts[i]);
                }
                if (found_letters.size() == 26) {
                    idexOfLastLetter = i;
                    break;
                }
            }
            if (idexOfLastLetter != -1) {
                System.out.println("Индекс последней найденной буквы: " + idexOfLastLetter);
                int min_length = idexOfLastLetter + 1;
                System.out.println("Длина минимальной последовательности: " + min_length);
            }
            else{
                System.out.println("NONE");
            }

        } catch (IOException e) {
            System.err.println("Error: " + e);
        }


    }
    public static int findIndex(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
