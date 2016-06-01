package sudokuSolver;

import java.util.HashSet;
import java.util.Iterator;

public class SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",
		//".98...3..","...8.3.2.","........6","...2759.."
		char[][] board={
				{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}
		};
		SudokuSolver solver=new SudokuSolver();
		solver.solveSudoku(board);
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public void solveSudoku(char[][] board) {
		System.out.println(solvingSudoku(board,0));
		//这样子实例化一个int二维数组有问题么，初始化之后是为0吧？
//		int[][] boardNum=new int[board.length][board[0].length];
//		for(int m=0;m<board.length;m++){
//			for(int n=0;n<board[0].length;n++){
//				if(board[m][n]!='.'){
//					boardNum[m][n]=Integer.parseInt(String.valueOf(board[m][n]));
//				}
//			}
//		}
//		HashSet<Integer> rowSet=new HashSet<Integer>();
//		HashSet<Integer> columnSet=new HashSet<Integer>();
//		HashSet<Integer> blockSet=new HashSet<Integer>();
//		HashSet<Integer> sameSet=new HashSet<Integer>();
//		while(!allBlankFilled(board)){
//			for(int i=0;i<board.length;i++){
//				for(int j=0;j<board[0].length;j++){
//					if(board[i][j]=='.'){
//						int temp=calculateTheEmptyNumber(i,j,boardNum,rowSet,columnSet,blockSet,sameSet);
//						if(temp>0){
//							board[i][j]=String.valueOf(temp).charAt(0);
//							boardNum[i][j]=temp;
//						}
//					}
//				}
//			}
//		}
    }
	
	public boolean solvingSudoku(char[][] board,int pos){
		if(pos>80){
			return true;
		}
		int row=pos/9,column=pos%9;
		if(board[row][column]=='.'){
			for(int i=1;i<10;i++){			
				board[row][column]=String.valueOf(i).charAt(0);
				if(isValidSudoku(board)){
					if(!solvingSudoku(board,pos+1)){
						board[row][column]='.';
						continue;
					}
					else{
						return true;
					}
				}
				else{
					board[row][column]='.';
					continue;
				}
			}
			return false;
		}
		else{
			if(!solvingSudoku(board,pos+1)){
				return false;
			}
			else{
				return true;
			}
		}
//		return false;
	}
	
	public boolean isValidSudoku(char[][] board) {
		HashSet<Integer> nums=new HashSet<Integer>();	
		char[] temp=new char[9];
		for(int i=0;i<9;i++){
			nums.clear();
			if(isValidPart(board[i],nums)==false){
				return false;
			}
			for(int j=0;j<9;j++){
				temp[j]=board[j][i];
			}
			nums.clear();
			if(isValidPart(temp,nums)==false){
				return false;
			}
		}
		int[][] array={{0,1,2},{3,4,5},{6,7,8}};
		for(int m=0;m<3;m++){
			for(int n=0;n<3;n++){
				temp[0]=board[array[m][0]][array[n][0]];
				temp[1]=board[array[m][0]][array[n][1]];
				temp[2]=board[array[m][0]][array[n][2]];
				temp[3]=board[array[m][1]][array[n][0]];
				temp[4]=board[array[m][1]][array[n][1]];
				temp[5]=board[array[m][1]][array[n][2]];
				temp[6]=board[array[m][2]][array[n][0]];
				temp[7]=board[array[m][2]][array[n][1]];
				temp[8]=board[array[m][2]][array[n][2]];
				nums.clear();
				if(isValidPart(temp,nums)==false){
					return false;
				}
			}
		}
        return true;
    }
	
	public boolean isValidPart(char[] part, HashSet<Integer> ints){
		for(int i=0;i<part.length;i++){
			if(part[i]!='.'){
				Integer num=Integer.parseInt(String.valueOf(part[i]));
				if(ints.contains(num)){
					ints.clear();
					return false;
				}
				else{
					ints.add(num);
				}
			}
		}
		ints.clear();
		return true;
	}
	
//	private int calculateTheEmptyNumber(int i,int j,int[][] nums,HashSet<Integer> row,HashSet<Integer> column,HashSet<Integer> block,HashSet<Integer> same){
//		initNumSet(row);
//		initNumSet(column);
//		initNumSet(block);
//		same.clear();
//		for(int k=0;k<9;k++){
//			if(nums[i][k]!=0){
//				row.remove(nums[i][k]);
//			}
//		}
//		for(int p=0;p<9;p++){
//			if(nums[p][j]!=0){
//				column.remove(nums[p][j]);
//			}
//		}
//		for(int x=(i/3)*3;x<(i/3)*3+3;x++){
//			for(int y=(j/3)*3;y<(j/3)*3+3;y++){
//				if(nums[x][y]!=0){
//					block.remove(nums[x][y]);
//				}
//			}
//		}
//		for(Integer rowNum: row){
//			if(column.contains(rowNum)&&block.contains(rowNum)){
//				same.add(rowNum);
//			}
//		}
//		if(same.size()==1){
//			Iterator<Integer> it=same.iterator();
//			return it.next();
//		}
//		else{
//			int rowA=0,rowB=0,columnC=0,columnD=0;
//			switch(i%3){
//			case 0:
//				rowA=i+1;
//				rowB=i+2;
//				break;
//			case 1:
//				rowA=i-1;
//				rowB=i+1;
//				break;
//			case 2:
//				rowA=i-2;
//				rowB=i-1;
//			}
//			switch(j%3){
//			case 0:
//				columnC=j+1;
//				columnD=j+2;
//				break;
//			case 1:
//				columnC=j-1;
//				columnD=j+1;
//				break;
//			case 2:
//				columnC=j-2;
//				columnD=j-1;
//			}
//			return judgeTheBlankByRowsAndColumns(i,j,rowA,rowB,columnC,columnD,nums,same);
//		}
////		return -1;
//	}
//	private int judgeTheBlankByRowsAndColumns(int i,int j,int rowA,int rowB,int columnC,int columnD,int[][] nums,HashSet<Integer> same){
//		for(int k=0;k<nums[0].length;k++){
//			if(same.contains(nums[rowA][k])&&rowContains(nums[rowA][k],rowB,nums)
//					&&columnContains(nums[rowA][k],columnC,nums)&&columnContains(nums[rowA][k],columnD,nums)){
//				return nums[rowA][k];
//			}
//		}
//		return -1;
//	}
//	private boolean rowContains(int target,int row,int[][] nums){
//		for(int j=0;j<nums[0].length;j++){
//			if(nums[row][j]==target){
//				return true;
//			}
//		}
//		return false;
//	}
//	private boolean columnContains(int target,int column,int[][] nums){
//		for(int i=0;i<nums.length;i++){
//			if(nums[i][column]==target){
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	private void initNumSet(HashSet<Integer> numSet){
//		numSet.clear();
//		for(int i=1;i<10;i++){
//			numSet.add(i);
//		}
//	}
//	
//	private boolean allBlankFilled(char[][] chars){
//		for(int i=0;i<chars.length;i++){
//			for(int j=0;j<chars[0].length;j++){
//				if(chars[i][j]=='.'){
//					return false;
//				}
//			}
//		}
//		return true;
//	}

}
