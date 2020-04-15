
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = readMatrix(scanner, size);
        ArrayDeque<String> eggs = new ArrayDeque<>();
        int bunyRowPositon = getRowPosition("B", matrix);
        int bunyColPositon = getColPosition("B", bunyRowPositon, matrix);

        int eggsChecker = findEggs(matrix);
        int eggsFinal = eggsChecker;

        boolean isOut = false;
        int carrot = 0;
        String command = scanner.nextLine();

        while (!command.equals("end") || eggsChecker == 0) {//

            int currentRow = bunyRowPositon;
            int currentCol = bunyColPositon;
            switch (command) {
                case "up":
                    currentRow -= 1;
                    break;
                case "down":
                    currentRow += 1;
                    break;
                case "left":
                    currentCol -= 1;
                    break;
                case "right":
                    currentCol += 1;
                    break;
            }
            isOut = checkIsOut(currentRow, currentCol, matrix.length);

            if (!isOut) {
                String currentSymbol = matrix[currentRow][currentCol];
                if (currentSymbol.equals("C")) {
                    carrot++;
                    matrix[bunyRowPositon][bunyColPositon] = "-";
                    matrix[currentRow][currentCol] = "B";
                    bunyRowPositon = currentRow;
                    bunyColPositon = currentCol;

                    if (command.equals("up")) {
                        if (currentRow == 0) {
                            currentRow = matrix.length - 1;
                        } else if (currentRow == matrix.length - 1) {
                            currentRow = 0;
                        } else {
                            currentRow += 1;

                        }
                    } else if (command.equals("down")) {
                        if (currentRow == matrix.length - 1) {
                            currentRow = 0;
                        } else if (currentRow == 0) {
                            currentRow = matrix.length - 1;
                        } else {
                            currentRow -= 1;
                        }

                    } else if (command.equals("left")) {
                        if (currentCol == 0) {
                            currentCol = matrix.length - 1;
                        } else if (currentCol == matrix.length - 1) {
                            currentCol = 0;
                        } else {
                            currentCol += 1;

                        }

                    } else if (command.equals("right")) {
                        if (currentCol == matrix.length - 1) {
                            currentCol = 0;
                        } else if (currentCol==0){
                            currentCol=matrix.length-1;
                        }else {
                            currentCol -= 1;

                        }
                    }
                    String currentSymbolCarrot = matrix[currentRow][currentCol];
                    if (currentSymbolCarrot.equals("-")) {
                        matrix[bunyRowPositon][bunyColPositon] = "-";
                        matrix[currentRow][currentCol] = "B";
                        bunyRowPositon = currentRow;
                        bunyColPositon = currentCol;
                    } else {
                        char checker = currentSymbol.charAt(0);
                        if (checker >= 97 && checker <= 122) {
                            eggs.offer(currentSymbol);
                            eggsChecker--;

                        }
                        matrix[bunyRowPositon][bunyColPositon] = "-";
                        matrix[currentRow][currentCol] = "B";
                        bunyRowPositon = currentRow;
                        bunyColPositon = currentCol;
                        if (eggsChecker == 0) {
                            break;
                        }
                    }
                } else if (currentSymbol.equals("-")) {
                    matrix[bunyRowPositon][bunyColPositon] = "-";
                    matrix[currentRow][currentCol] = "B";
                    bunyRowPositon = currentRow;
                    bunyColPositon = currentCol;
                } else {
                    char checker = currentSymbol.charAt(0);
                    if (checker >= 97 && checker <= 122) {
                        eggs.offer(currentSymbol);
                        eggsChecker--;

                    }
                    matrix[bunyRowPositon][bunyColPositon] = "-";
                    matrix[currentRow][currentCol] = "B";
                    bunyRowPositon = currentRow;
                    bunyColPositon = currentCol;
                    if (eggsChecker == 0) {
                        break;
                    }
                }
            } else {
                if (!eggs.isEmpty()) {
                    eggs.remove();
                    eggsFinal--;

                    if (eggsChecker == 0) {
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }


        if (eggsChecker == 0) {
            System.out.printf("Happy Easter! The Easter bunny collected %d eggs: ", eggsFinal);
            List<String> finalCoolection = new ArrayList<>();
            while (!eggs.isEmpty()) {

                finalCoolection.add(eggs.remove());
            }
            System.out.print(String.join(", ", finalCoolection));
            System.out.println(".");

        } else {
            System.out.printf("The Easter bunny failed to gather every egg. There are %d eggs left to collect.%n", eggsChecker);

        }


        printMatrix(matrix);
    }

    private static int findEggs(String[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col].charAt(0);
                if (symbol >= 97 && symbol <= 122) {
                    sum++;
                }
            }
        }
        return sum;
    }


    private static boolean checkIsOut(int currentRow, int currentCol, int length) {
        boolean isOut = currentRow < 0 || currentRow >= length || currentCol < 0 || currentCol >= length;
        return isOut;
    }

    private static int getColPosition(String b, int row, String[][] matrix) {
        int index = -1;
        for (int col = 0; col < matrix[row].length; col++) {
            if (matrix[row][col].equals("B")) {
                index = col;
                break;
            }
            if (index != -1) {
                break;
            }
        }
        return index;
    }

    private static int getRowPosition(String b, String[][] matrix) {
        int index = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    index = row;
                    break;
                }
            }
            if (index != -1) {
                break;
            }
        }
        return index;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(Scanner scanner, int size) {
        String[][] matrix = new String[size][size];
        for (int row = 0; row < matrix.length; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            matrix[row] = line;
        }
        return matrix;
    }
}
