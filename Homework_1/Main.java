package com.company;

public class Main {
    public static void main(String[] args) {
        //long startTime = System.nanoTime();

        Main app = new Main();

        if (args.length < 3) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }

        int n = Integer.parseInt(args[0]);
        if (n <= 0) {
            System.out.println("The number of words (n) must be positive!");
            System.exit(-1);
        }
        int p = Integer.parseInt(args[1]);
        if (p <= 0) {
            System.out.println("The number of characters contained by a word (p) must be positive!");
            System.exit(-1);
        }
        char[] c = new char[args.length - 2];
        for (int i = 2; i < args.length; i++) {
            if (args[i].length() > 1) {
                System.out.println("Too many characters in argument no. " + (i + 1) + "!");
                System.exit(-1);
            }
            if (args[i].charAt(0) < 'A' || args[i].charAt(0) > 'Z') {
                System.out.println("The letters must be from [A-Z]!");
                System.exit(-1);
            }
            c[i - 2] = args[i].charAt(0);
        }
        String[] words = app.generate(n, p, c);
        for (String word : words)
            System.out.print(word + " ");
        System.out.println("\n");

        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < n; i++)
            matrix[i][i] = true;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (app.neighbor(words[i], words[j]))
                    matrix[i][j] = matrix[j][i] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        System.out.println();

        String[][] neighbors = new String[n][];
        int col;
        for (int i = 0; i < n; i++) {
            col = 0;
            for (int j = 0; j < n; j++)
                if (matrix[i][j])
                    col++;
            neighbors[i] = new String[col];
            col = 0;
            for (int j = 0; j < n; j++)
                if (matrix[i][j])
                    neighbors[i][col++] = words[j];
        }
        for (int i = 0; i < n; i++) {
            for (String neighbor : neighbors[i])
                System.out.print(neighbor + " ");
            System.out.println();
        }

        /*
        long endTime = System.nanoTime();
        /long timeElapsed = endTime - startTime;
        System.out.println("\nExecution time in nanoseconds: " + timeElapsed);
        */
    }

    public String[] generate(int n, int p, char[] c) {
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < p) {
                int pos = (int) (Math.random() * c.length); //pos -> [0, c.length]
                //System.out.println(pos);
                if (pos != c.length) {
                    sb.append(c[pos]);
                    j++;
                }
            }
            words[i] = sb.toString();
        }
        return words;
    }

    public boolean neighbor(String word1, String word2) {
        boolean[] exists = new boolean[26];
        for (int i = 0; i < word1.length(); i++)
            exists[word1.charAt(i) - 'A'] = true;
        for (int i = 0; i < word2.length(); i++)
            if (exists[word2.charAt(i) - 'A'])
                return true;
        return false;
    }
}