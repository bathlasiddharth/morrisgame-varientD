import java.util.*;


public class Generate {
	
	
	
	public static ArrayList<PositionList> generateAdd(PositionList board){
		ArrayList<PositionList> a = new ArrayList();
		
		for(int i=0; i<board.size(); i++){
			if(board.get(i)==positionType.X){
				PositionList c = board.getCopy();
				c.set(i, positionType.W);
				
				if(isCloseMill(i,c)){
					a=generateRemove(c,a);
				}
				else{
					a.add(c);
				}
				
			}
		}
		
		
		return a;
	}

	private static ArrayList<PositionList> generateRemove(PositionList board, ArrayList<PositionList> a) {
		for (int i = 0; i < board.size(); i++){
			if (board.get(i) == positionType.B){
				if (!isCloseMill(i, board)){
					PositionList b = board.getCopy();
					b.set(i, positionType.X);
					a.add(b);
				}
			}
		}
		return a;
	}

	private static boolean isCloseMill(int i, PositionList c) {
		// TODO Auto-generated method stub
		positionType a = c.get(i);
		if(a==positionType.X){
			return false;
		}else{
			return checkMillList(c, i, a);
		}
	}

	private static boolean checkMillList(PositionList c, int i, positionType a) {
		switch(i){
		case 0:
			return (checkMill(c, a, 1, 2) || checkMill(c, a, 8, 20) || checkMill(c, a, 3, 6));
		case 1:
			return (checkMill(c, a, 0, 2));
		case 2:
			return (checkMill(c, a, 0, 1) || checkMill(c, a, 5, 7) || checkMill(c, a, 13, 22));
		case 3:
			return (checkMill(c, a, 0, 6) || checkMill(c, a, 4, 5) || checkMill(c, a, 9, 17));
		case 4:
			return (checkMill(c, a, 3, 5));
		case 5:
			return (checkMill(c, a, 3, 4) || checkMill(c, a, 2, 7) || checkMill(c, a, 12, 19));
		case 6:
			return (checkMill(c, a, 0, 3) || checkMill(c, a, 10, 14));
		case 7:
			return (checkMill(c, a, 2, 5) || checkMill(c, a, 11, 16));
		case 8:
			return (checkMill(c, a, 0, 20) || checkMill(c, a, 9, 10));
		case 9:
			return (checkMill(c, a, 8, 10) || checkMill(c, a, 3, 17));
		case 10:
			return (checkMill(c, a, 8, 9) || checkMill(c, a, 6, 14));
		case 11:
			return (checkMill(c, a, 7, 16) || checkMill(c, a, 12, 13));
		case 12:
			return (checkMill(c, a, 11, 13) || checkMill(c, a, 5, 19));
		case 13:
			return (checkMill(c, a, 11, 12) || checkMill(c, a, 2, 22));
		case 14:
			return (checkMill(c, a, 17, 20) || checkMill(c, a, 15, 16) || checkMill(c, a, 6, 14));
		case 15:
			return (checkMill(c, a, 14, 16) || checkMill(c, a, 18, 21));
		case 16:
			return (checkMill(c, a, 14, 15) || checkMill(c, a, 19, 22) || checkMill(c, a, 7, 11));
		case 17:
			return (checkMill(c, a, 3, 9) || checkMill(c, a, 14, 20) || checkMill(c, a, 18, 19));
		case 18:
			return (checkMill(c, a, 17, 19) || checkMill(c, a, 15, 21));
		case 19:
			return (checkMill(c, a, 17, 18) || checkMill(c, a, 16, 22) || checkMill(c, a, 5, 12));
		case 20:
			return (checkMill(c, a, 0, 8) || checkMill(c, a, 14, 17) || checkMill(c, a, 21, 22));
		case 21:
			return (checkMill(c, a, 20, 22) || checkMill(c, a, 15, 18));
		case 22:
			return (checkMill(c, a, 2, 13) || checkMill(c, a, 16, 19) || checkMill(c, a, 20, 21));
		default:
			return false;
		}
	}
	
	private static boolean checkMill(PositionList a, positionType c, int v1, int v2){
		return (a.get(v1) == c && a.get(v2) == c);
	}
	
	public static ArrayList<PositionList> generateHopping(PositionList board){
		ArrayList<PositionList> a = new ArrayList<PositionList>();
		for (int i = 0; i < board.size(); i++){
			if (board.get(i) == positionType.W){
				for (int j = 0; j < board.size(); j++){
					if (board.get(j) == positionType.X){
						PositionList b = board.getCopy();
						b.set(i, positionType.X);
						b.set(j, positionType.W);
						if (isCloseMill(j, b))
							generateRemove(b, a);
						else
							a.add(b);
					}
				}
			}
		}
		return a;
	}
	
	
	public static ArrayList<PositionList> generateMove(PositionList board){
		ArrayList<PositionList> a = new ArrayList<PositionList>();
		for (int i = 0; i < board.size(); i++){
			if (board.get(i) == positionType.W){
				List<Integer> n = getNeighbors(i);
				for (int j : n){
					if (board.get(j) == positionType.X){
						PositionList b = board.getCopy();
						b.set(i, positionType.X);
						b.set(j, positionType.W);
						if (isCloseMill(j, b)){
							a = generateRemove(b, a);
						}
						else{
							a.add(b);
						}
					}
				}
			}
		}
		return a;
	}
	
	
	public static ArrayList<Integer> getNeighbors(int i){
		switch(i){
			case 0:
				return new ArrayList<Integer>(Arrays.asList(1, 3, 8));
			case 1:
				return new ArrayList<Integer>(Arrays.asList(0, 2, 4));
			case 2:
				return new ArrayList<Integer>(Arrays.asList(1, 5, 13));
			case 3:
				return new ArrayList<Integer>(Arrays.asList(0, 4, 6, 9));
			case 4:
				return new ArrayList<Integer>(Arrays.asList(1, 3, 5));
			case 5:
				return new ArrayList<Integer>(Arrays.asList(2, 4, 7, 12));
			case 6:
				return new ArrayList<Integer>(Arrays.asList(3, 7, 10));
			case 7:
				return new ArrayList<Integer>(Arrays.asList(5, 6, 11));
			case 8:
				return new ArrayList<Integer>(Arrays.asList(0, 9, 20));
			case 9:
				return new ArrayList<Integer>(Arrays.asList(3, 8, 10, 17));
			case 10:
				return new ArrayList<Integer>(Arrays.asList(6, 9, 14));
			case 11:
				return new ArrayList<Integer>(Arrays.asList(7, 12, 16));
			case 12:
				return new ArrayList<Integer>(Arrays.asList(5, 11, 13, 19));
			case 13:
				return new ArrayList<Integer>(Arrays.asList(2, 12, 22));
			case 14:
				return new ArrayList<Integer>(Arrays.asList(10, 15, 17));
			case 15:
				return new ArrayList<Integer>(Arrays.asList(14, 16, 18));
			case 16:
				return new ArrayList<Integer>(Arrays.asList(11, 15, 19));
			case 17:
				return new ArrayList<Integer>(Arrays.asList(9, 14, 18, 20));
			case 18:
				return new ArrayList<Integer>(Arrays.asList(15, 17, 19, 21));
			case 19:
				return new ArrayList<Integer>(Arrays.asList(12, 16, 18, 22));
			case 20:
				return new ArrayList<Integer>(Arrays.asList(8, 17, 21));
			case 21:
				return new ArrayList<Integer>(Arrays.asList(18, 20, 22));
			case 22:
				return new ArrayList<Integer>(Arrays.asList(13, 19, 21));
			default:
				return (new ArrayList<Integer>());
		}
	}
	
	public static int staticEstimationOpening(PositionList board){
		return board.getPieceCount(positionType.W)-board.getPieceCount(positionType.B);
	}
	
	public static ArrayList<PositionList> generateMovesOpening(PositionList board){
		return generateAdd(board);
	}
	
	public static ArrayList<PositionList> generateMovesMidgameEndgame(PositionList board){
		if (board.getPieceCount(positionType.W) == 3)
			return generateHopping(board);
		else
			return generateMove(board);
	}
	
	public static int staticEstimationMidGameEndGame(PositionList board){
		int whiteCount = board.getPieceCount(positionType.W);
		int blackCount = board.getPieceCount(positionType.B);
		ArrayList<PositionList> l = generateMovesMidgameEndgameBlack(board);
		int movesCount = l.size();
		if (blackCount <= 2)
			return 10000;
		else if (whiteCount <= 2)
			return -10000;
		else if (movesCount == 0)
			return 10000;
		else
			return 1000*(whiteCount - blackCount) - movesCount;
	}
	
	public static ArrayList<PositionList> generateMovesOpeningBlack(PositionList board){
		PositionList tempBoard = board.flip();
		ArrayList<PositionList> moves = generateMovesOpening(tempBoard);
		for (int i = 0; i < moves.size(); i++){
			PositionList b = moves.get(i);
			moves.set(i, b.flip());
		}
		return moves;
	}
	
	public static ArrayList<PositionList> generateMovesMidgameEndgameBlack(PositionList board){
		PositionList tempboard = board.flip();
		ArrayList<PositionList> moves = generateMovesMidgameEndgame(tempboard);
		ArrayList<PositionList> output = new ArrayList<PositionList>();
		for (int i = 0; i < moves.size(); i++){
			PositionList b = moves.get(i);
			output.add(b.flip());
		}
		return output;
	}
	
	//Improvement in Static Estimation: take into account how many potential mills W has 	
	public static int getPotentialMillsCount(positionType pos, PositionList board){
		int counter = 0;
		for (int i = 0; i< board.size(); i++){
			positionType a = board.get(i);
			if (a == positionType.X){
				if (checkMillList(board, i, a))
					counter++;
			}
		}
		return counter;
	}
		
	
	public static int staticEstimationOpeningImproved(PositionList board){
		return (board.getPieceCount(positionType.W) + getPotentialMillsCount(positionType.W, board) - board.getPieceCount(positionType.B));
	}
	
	public static int staticEstimationMidgameEndgameImproved(PositionList board){
		int blackCount = board.getPieceCount(positionType.B);
		int whiteCount = board.getPieceCount(positionType.W);
		int potentialMillCount = getPotentialMillsCount(positionType.W, board);
		ArrayList<PositionList> l = generateMovesMidgameEndgameBlack(board);
		int movesCount = l.size();
		if (blackCount <= 2){
			return 10000;
		}
		else if (whiteCount <= 2){
			return -10000;
		}
		else if (movesCount == 0){
			return 10000;
		}
		else{
			return 1000*(whiteCount - blackCount + potentialMillCount) - movesCount;
		}
	}
}
