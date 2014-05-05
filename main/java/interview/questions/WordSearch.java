package interview.questions;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean exist(char[][] board, String word) {
		if (word== null || word.length()==0) return true;
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for (int i = 0; i < board.length; ++i) {
	        for (int j = 0; j < board[0].length; ++j) {
	          if (greedy(visited, word, 0, word.length(), board, i, j )) {
	            return true;
	          }
	        }
	      }
	      return false;
		
		
	}
	
	boolean greedy(boolean[][] visited, String word, int curPos, int length, char[][] board, int i, int j) {
		if (board[i][j]!=word.charAt(curPos)) {
		  return false;
		}
		if (curPos == length-1) return true;
		
		visited[i][j] = true;
		
		if (j+1 < length && !visited[i][j+1] && greedy(visited, word, curPos +1, length, board, i, j +1)) return true;
		if (j-1 > 0 && !visited[i][j-1] &&  greedy(visited, word, curPos +1, length, board, i, j -1)) return true;
		if (i+1 < length && !visited[i+1][j] && greedy(visited, word, curPos +1, length, board, i+1, j)) return true;
		if (i-1 < length && !visited[i-1][j] && greedy(visited, word, curPos +1, length, board, i-1,j)) return true;
		visited[i][j] = false;
		return false;
	}

}
