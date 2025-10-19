import java.util.*;

public class Program5 {

    public static int minSumm(List<List<Integer>> trgl) {
        for (int row = 1; row < trgl.size(); row++) {
            for (int col = 0; col < trgl.get(row).size(); col++) {

                if (col == 0) {
                    int newValue = trgl.get(row).get(col) + trgl.get(row - 1).get(col);
                    trgl.get(row).set(col, newValue);

                } else if (col == trgl.get(row).size() - 1) {
                    int currSum = trgl.get(row).get(col) + trgl.get(row - 1).get(col - 1);
                    trgl.get(row).set(col, currSum);

                } else {
                    int left = trgl.get(row - 1).get(col - 1);
                    int right = trgl.get(row - 1).get(col);
                    int currSum = trgl.get(row).get(col) + Math.min(left, right);
                    trgl.get(row).set(col, currSum);
                }
            }
        }

        int minSum = Integer.MAX_VALUE;
        List<Integer> baseOfTriangle = trgl.get(trgl.size()-1);
        for (int i = 0; i < baseOfTriangle.size(); i++) {
            int curr_num = baseOfTriangle.get(i);
            if (curr_num < minSum) {
                minSum = curr_num;
            }
        }
        return minSum;

    }
    public static int minSumm2(List<List<Integer>> triangle) {
        return recursion(triangle, 0, 0, new HashMap<>());
    }

    private static int recursion(List<List<Integer>> triangle, int row, int col,
                           Map<String, Integer> interim) {
        // Ключ для мемоизации
        String key = row + "," + col;

        // Если уже вычисляли - возвращаем из кеша
        if (interim.containsKey(key)) {
            return interim.get(key);
        }

        // Базовый случай: дошли до дна треугольника
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        // Рекурсивно ищем минимальные пути в обе стороны
        int leftPath = recursion(triangle, row + 1, col, interim);
        int rightPath = recursion(triangle, row + 1, col + 1, interim);

        // Текущий результат = текущее число + минимум из путей
        int result = triangle.get(row).get(col) + Math.min(leftPath, rightPath);

        interim.put(key, result);

        return result;
    }


    public static void main(String[] args) {
        // Первый тестовый пример
        List<List<Integer>> triangle1 = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );

        // Второй тестовый пример
        List<List<Integer>> triangle2 = Arrays.asList(
                Arrays.asList(-1),
                Arrays.asList(2, 3),
                Arrays.asList(1, -1, -3),
                Arrays.asList(4, 2, 1, 3)
        );
        // Первый способ решения задачи
        System.out.println("Минимальная сумма 1 : " + minSumm(triangle1));

        // Второй способ решения задачи
        System.out.println("Минимальная сумма 2 : " + minSumm2(triangle2));

    }
}
