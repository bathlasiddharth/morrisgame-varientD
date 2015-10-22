import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ABGame {
	public static void main(String[] args) throws IOException{
		String inputFileName = args[0];
		String outputFileName = args[1];
		int depth = Integer.parseInt(args[2]);

		PositionList initialBoard = new PositionList(FileOperations.getBoardConfiguration(inputFileName));
		Output output = ABMiniMax(depth, true, initialBoard, Integer.MIN_VALUE, Integer.MAX_VALUE);
		FileOperations.writeOutput(output, outputFileName);
	}
	
	/*
		Minimax Procedure for finding optimal move with Alpha-Beta Pruning
	*/
	public static Output ABMiniMax(int depth, boolean isWhite, PositionList board, int alpha, int beta){
		Output output = new Output();

		/* Means that we are at a terminal node */
		if (depth == 0){
			output.value = Generate.staticEstimationMidGameEndGame(board);
			output.nodesCount++;
			return output;
		}

		ArrayList<PositionList> nextMoves;
		Output in = new Output();
		nextMoves = (isWhite) ? Generate.generateMovesMidgameEndgame(board) : Generate.generateMovesMidgameEndgameBlack(board);
		for (PositionList b : nextMoves){
			if (isWhite){
				in = ABMiniMax(depth - 1, false, b, alpha, beta);
				output.nodesCount += in.nodesCount;
				output.nodesCount++;
				if (in.value > alpha)
				{
					alpha = in.value;
					output.a = b;
				}
			}
			else{
				in = ABMiniMax(depth - 1, true, b, alpha, beta);
				output.nodesCount += in.nodesCount;
				if (in.value < beta)
				{
					beta = in.value;
					output.a = b;
				}
			}
			if (alpha >= beta){
				break;
			}
		}
		
		output.value = (isWhite) ? alpha : beta;
		return output;
	}
}
