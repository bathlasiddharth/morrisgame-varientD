import java.io.IOException;
import java.util.ArrayList;


public class ABOpening {
	public static void main(String[] args) throws IOException{
		String inputFileName = args[0];
		String outputFileName = args[1];
		int depth = Integer.parseInt(args[2]);
		PositionList initialBoard = new PositionList(FileOperations.getBoardConfiguration(inputFileName));
		Output output = ABMiniMax(depth, true, initialBoard, Integer.MIN_VALUE, Integer.MAX_VALUE);
		FileOperations.writeOutput(output, outputFileName);
	}
	
	public static Output ABMiniMax(int depth, boolean isWhite, PositionList board, int alpha, int beta){
		Output output = new Output();

		if (depth == 0){
			output.value = Generate.staticEstimationOpening(board);
			output.nodesCount++;
			return output;
		}

		Output in = new Output();
		ArrayList<PositionList> nextMoves = (isWhite) ? Generate.generateMovesOpening(board) : Generate.generateMovesOpeningBlack(board);
		for (PositionList b : nextMoves){
			if (isWhite){
				in = ABMiniMax(depth - 1, false, b, alpha, beta);
				output.nodesCount += in.nodesCount;
				if (in.value > alpha){
					alpha = in.value;
					output.a = b;
				}
			}
			else{
				in = ABMiniMax(depth - 1, true, b, alpha, beta);
				output.nodesCount += in.nodesCount;
				output.nodesCount++;
				if (in.value < beta){
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
