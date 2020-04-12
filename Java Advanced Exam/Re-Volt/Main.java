import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                int num = Integer.parseInt(scanner.nextLine());
                int command = Integer.parseInt(scanner.nextLine());

                char[][] matrix = readMatrix(scanner, num);
                int playerRow = positionRow('f', matrix);
                int playerCol = positionCol('f', playerRow, matrix);

                boolean outSide = false;
                int finishIndex = -1;
                for (int i = 0; i < command; i++) {
                    String line = scanner.nextLine();

                    int currentRowposition = playerRow;
                    int currentColposition = playerCol;

                    switch (line) {
                        case "up":
                            currentRowposition -= 1;
                            break;
                        case "down":
                            currentRowposition += 1;
                            break;
                        case "left":
                            currentColposition -= 1;
                            break;
                        case "right":
                            currentColposition += 1;
                            break;
                    }
                    outSide = isPlaerisOut(currentRowposition, currentColposition, matrix.length);
                    if (!outSide) {
                        char currentSymbol = matrix[currentRowposition][currentColposition];
                        if (currentSymbol == '-') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[currentRowposition][currentColposition] = 'f';
                            playerRow = currentRowposition;
                            playerCol = currentColposition;
                        } else if (currentSymbol == 'F') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[currentRowposition][currentColposition] = 'f';
                            playerRow = currentRowposition;
                            playerCol = currentColposition;
                            finishIndex++;
                            break;
                        } else if (currentSymbol == 'B') {
                            switch (line) {
                                case "up":
                                    currentRowposition -= 1;
                                    break;
                                case "down":
                                    currentRowposition += 1;
                                    break;
                                case "left":
                                    currentColposition -= 1;
                                    break;
                                case "right":
                                    currentColposition += 1;
                                    break;

                            }
                            outSide = isPlaerisOut(currentRowposition, currentColposition, matrix.length);
                            if (!outSide) {
                                currentSymbol = matrix[currentRowposition][currentColposition];
                                if (currentSymbol == '-') {
                                    matrix[playerRow][playerCol] = '-';
                                    matrix[currentRowposition][currentColposition] = 'f';
                                    playerRow = currentRowposition;
                                    playerCol = currentColposition;
                                } else if (currentSymbol == 'F') {
                                    matrix[playerRow][playerCol] = '-';
                                    matrix[currentRowposition][currentColposition] = 'f';
                                    playerRow = currentRowposition;
                                    playerCol = currentColposition;
                                    finishIndex++;
                                    break;
                                }
                            } else {
                                if (currentRowposition < 0) {
                                    currentRowposition = matrix.length - 1;
                                } else if (currentRowposition >= matrix.length) {
                                    currentRowposition = 0;
                                }
                                if (currentColposition < 0) {
                                    currentColposition = matrix.length - 1;
                                } else if (currentColposition >= matrix.length) {
                                    currentColposition = 0;
                                }
                                currentSymbol=matrix[currentRowposition][currentColposition];
                                if (currentSymbol == '-') {
                                    matrix[playerRow][playerCol] = '-';
                                    matrix[currentRowposition][currentColposition] = 'f';
                                    playerRow = currentRowposition;
                                    playerCol = currentColposition;
                                } else if (currentSymbol == 'F') {
                                    matrix[playerRow][playerCol] = '-';
                                    matrix[currentRowposition][currentColposition] = 'f';
                                    playerRow = currentRowposition;
                                    playerCol = currentColposition;
                                    finishIndex++;
                                    break;
                                }
                            }
                        }
                    } else {
                        if (currentRowposition < 0) {
                            currentRowposition = matrix.length - 1;
                        } else if (currentRowposition >= matrix.length) {
                            currentRowposition = 0;
                        }
                        if (currentColposition < 0) {
                            currentColposition = matrix.length - 1;
                        } else if (currentColposition >= matrix.length) {
                            currentColposition = 0;
                        }
                        matrix[playerRow][playerCol] = '-';
                        matrix[currentRowposition][currentColposition] = 'f';
                        playerRow = currentRowposition;
                        playerCol = currentColposition;
                    }
                }
                if (finishIndex != -1) {
                    System.out.println("Player won!");
                } else {
                    System.out.println("Player lost!");
                }
                printMatrix(matrix);
            }

            private static boolean isPlaerisOut(int currentRowposition, int currentColposition, int length) {
                boolean isOut = currentRowposition < 0 || currentRowposition >= length || currentColposition < 0 || currentColposition >= length;
                return isOut;
            }

            private static int positionCol(char f, int playerRow, char[][] matrix) {
                int index = -1;
                for (int col = 0; col < matrix[playerRow].length; col++) {
                    if (matrix[playerRow][col] == 'f') {
                        index = col;
                        break;
                    }
                    if (index != -1) {
                        break;
                    }
                }
                return index;
            }

            private static int positionRow(char f, char[][] matrix) {
                int index = -1;
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (matrix[row][col] == 'f') {
                            index = row;
                            break;
                        }
                        if (index != -1) {
                            break;
                        }
                    }
                }
                return index;
            }

            private static void printMatrix(char[][] matrix) {
                for (int row = 0; row < matrix.length; row++) {
                    for (int i = 0; i < matrix[row].length; i++) {
                        System.out.print(matrix[row][i]);
                    }
                    System.out.println();
                }
            }

            private static char[][] readMatrix(Scanner scanner, int num) {
                char[][] matrix = new char[num][num];
                for (int row = 0; row < matrix.length; row++) {
                    char[] line = scanner.nextLine().toCharArray();
                    matrix[row] = line;
                }
                return matrix;
            }
        }

