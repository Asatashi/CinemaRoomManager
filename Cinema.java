package cinema;

public class Cinema {

    public static void display(String[][] x) {
        for (String[] strings : x) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] sits = new String[8][9];
        String s = "S";
        String sitsNum = "0123456789";
        System.out.println("Cinema:");
        for (int i = 0; i < sits.length; i++) {         //filling 2d array with sits and rows numbers
            for (int j = 0; j < sits[i].length; j++) {
                sits[i][j] = s;
                sits[0][j] = String.valueOf(sitsNum.indexOf(String.valueOf(j)));
                sits[i][0] = String.valueOf(sitsNum.indexOf(String.valueOf(i)));
                sits[0][0] = "";
            }
        }
        display(sits);
    }
}