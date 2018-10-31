/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueen;


public class NQueen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        placeQueens(4);
    }
    private static void placeQueens(int gridSize)
       {

         if(gridSize<4)
         {
            System.out.println("No Solution available");
         }
        else
         {
            int[][] board = new int[gridSize][gridSize];
             placeAllQueens(board, 0);
             printBoard(board);
         }
       }
        private static boolean placeAllQueens(int board[][], int row)
        {
        if(row>=board.length){
         return true;
        }
         boolean isAllQueensPlaced = false;
         for (int j = 0; j < board.length; j++)
        {
         if(isSafe(board, row, j))
        {
         board[row][j] = 1;
         isAllQueensPlaced = placeAllQueens(board, row+1);
         }
         if(isAllQueensPlaced)
        {
         break;
         }
        else
        {
         board[row][j] = 0;
         }
         }
         return isAllQueensPlaced;
        }
        private static boolean isSafe(int board[][], int row, int col){
             for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
        {
         if(board[i][j] == 1){
         return false;
         }
         }
        //Check Right Upper Diagonal
         for (int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
         if(board[i][j] == 1){
         return false;
         }
         }
         //Check in same Column
         for (int i = row-1; i >= 0; i--)
        {
         if(board[i][col] == 1){
         return false;
         }
         }
         return true;
        }
         private static void printBoard(int[][] board)
        {
        for (int row = 0; row < board.length; row++) {
         for (int col = 0; col < board.length; col++) {
         if(board[row][col] == 1){
         System.out.print("Q ");
         }
        else
        {
         System.out.print("_ ");
         }
         }
         System.out.println();
         }
         System.out.println("");
        }
}


