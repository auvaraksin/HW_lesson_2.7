package pro.sky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //task1
        System.out.println("Задание 1");
        List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 4, 4, 4, 5, 5, 6, 6, 7, 8, 10, 10, 11, 12));
        printOddNumbers(nums);
        System.out.println();

        //task2
        System.out.println("Задание 2");
        printEvenNumbersWithoutRepetition(nums);
        System.out.println();

        //task3
        System.out.println("Задание 3");
        List<String> words = new ArrayList<>(List.of("Один", "Два", "Десять", "Два", "Три", "Четыре", "Пять", "Пять",
                "Шесть", "Семь", "Семь", "Семь", "Два", "Семь", "Восемь", "Девять", "Десять", "Восемь", "Восемь"));
        printUniqueWords(words);
        System.out.println();

        //task4
        System.out.println("Задание 4");
        printDuplicateWords(words);
        System.out.println();
    }

    public static void printOddNumbers(List<Integer> nums) {
        System.out.println("Исходный массив");
        printArrayInteger(nums);
        if (nums.isEmpty()) {
            System.out.println("Список пуст. Выборка невозможна");
        } else {
            List<Integer> selectedNums = new ArrayList<>();
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i).intValue() % 2 != 0) {
                    selectedNums.add(nums.get(i));
                }
            }
            if (selectedNums.isEmpty()) {
                System.out.println("Требуемый массив отсутствует");
            } else {
                System.out.println("Требуемый массив");
                printArrayInteger(selectedNums);
            }
        }
    }

    public static void printEvenNumbersWithoutRepetition(List<Integer> nums) {
        System.out.println("Исходный массив");
        printArrayInteger(nums);
        if (nums.isEmpty()) {
            System.out.println("Список пуст. Выборка невозможна");
        } else {
            List<Integer> selectedNums = new ArrayList<>();
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i).intValue() % 2 == 0 && !selectedNums.contains(nums.get(i))) {
                    selectedNums.add(nums.get(i));
                }
            }
            if (selectedNums.isEmpty()) {
                System.out.println("Требуемый массив отсутствует");
            } else {
                Collections.sort(selectedNums);
                System.out.println("Требуемый массив");
                printArrayInteger(selectedNums);
            }
        }
    }

    public static void printUniqueWords(List<String> words) {
        System.out.println("Исходный список слов");
        printArrayString(words);
        if (words.isEmpty()) {
            System.out.println("Список пуст. Уникальные слова отсутствуют");
        }
        if (words.size() == 1) {
            System.out.println("Требуемый массив");
            System.out.println(words.get(0));
        }
        if (words.size() == 2) {
            if (!words.get(0).equals(words.get(1))) {
                System.out.println("Требуемый массив");
                System.out.println(words.get(0) + " " + words.get(1));
            } else {
                System.out.println("Уникальные слова отсутствуют");
            }
        }
        if (words.size() > 2) {
            List<String> selectedWords = new ArrayList<>();
            List<String> exchangeList = new ArrayList<>();
            for (int i = 0; i <= words.size() - 1; i++) {
                boolean isUniqueWord = true;
                for (int j = i + 1; j < words.size(); j++) {
                    if (words.get(i).equals(words.get(j))) {
                        isUniqueWord = false;
                    }
                }
                if (!exchangeList.contains(words.get(i)) && !isUniqueWord) {
                    exchangeList.add(words.get(i));
                }
                if (!exchangeList.contains(words.get(i)) && isUniqueWord) {
                    selectedWords.add(words.get(i));
                }
            }
            if (selectedWords.isEmpty()) {
                System.out.println("Уникальные слова отсутствуют");
            } else {
                System.out.println("Требуемый список слов");
                printArrayString(selectedWords);
            }
        }
    }

    public static void printDuplicateWords(List<String> words) {
        System.out.println("Исходный список слов");
        printArrayString(words);
        if (words.isEmpty()) {
            System.out.println("Список пуст. Поиск повторяющихся слов невозможен");
        }
        if (words.size() == 1) {
            System.out.println("Список состоит из одного слова. Поиск повторяющихся слов невозможен");
        }
        if (words.size() > 1) {
            List<String> selectedWords = new ArrayList<>();
            for (int i = 0; i <= words.size() - 1; i++) {
                boolean isUniqueWord = true;
                for (int j = i + 1; j < words.size(); j++) {
                    if (words.get(i).equals(words.get(j))) {
                        isUniqueWord = false;
                    }
                }
                if (!selectedWords.contains(words.get(i)) && !isUniqueWord) {
                    selectedWords.add(words.get(i));
                }
            }
            if (selectedWords.isEmpty()) {
                System.out.println("Повторящиеся слова не найдены");
            } else {
                System.out.println("Сведения о повторяющихся словах в списке");
                int counter;
                for (int i = 0; i < selectedWords.size(); i++) {
                    counter = 0;
                    for (int j = 0; j < words.size(); j++) {
                        if (selectedWords.get(i).equals(words.get(j))) {
                            counter++;
                        }
                    }
                    System.out.println("Слово " + selectedWords.get(i) + ", количество повторений: " + counter);
                }
            }
        }
    }

    public static void printArrayInteger(List<Integer> nums) {
        if (!nums.isEmpty()) {
            for (Integer num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void printArrayString(List<String> words) {
        if (!words.isEmpty()) {
            for (String word : words) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
