import java.util.Scanner;
class AddTwoMatrix
{
    public static void main(String args[]) {
        int n, c, d;
        Scanner in = new Scanner(System.in);

        System.out.println("Introduceti numarul de elemente al matricelor\n n=");
        n = in.nextInt();

        int first[][] = new int[n][n];
        int second[][] = new int[n][n];
        int sum[][] = new int[n][n];
        int prod[][] = new int[n][n];

        System.out.println("Introduceti elementele primei matrice:");

        for (c = 0; c < n; c++)
            for (d = 0; d < n; d++)
                first[c][d] = in.nextInt();

        System.out.println("Introduceti elementele cele de-a doua matrice:");

        for (c = 0; c < n; c++)
            for (d = 0; d < n; d++)
                second[c][d] = in.nextInt();

        for (c = 0; c < n; c++)
            for (d = 0; d < n; d++)
                sum[c][d] = first[c][d] + second[c][d];

        System.out.println("Suma celor doua matrice introduse este: ");

        for (c = 0; c < n; c++) {
            for (d = 0; d < n; d++)
                System.out.print(sum[c][d] + "\t");

            System.out.println();
        }
        for (c = 0; c < n; c++)
            for (d = 0; d < n; d++)
                prod[c][d] = first[c][d] * second[c][d];
        System.out.println("Produsul celor doua matrice este: ");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    prod[i][j] += first[i][k] * second[k][j];

            }
        }
        for (c = 0; c < n; c++) {
            for (d = 0; d < n; d++)
                System.out.print(prod[c][d]+ ' ');

            System.out.println();
//        input.close();
        }
    }}
