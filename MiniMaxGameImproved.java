import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MiniMaxGameImproved {

	public static void main(String[] args) throws IOException{
		String inputFileName = args[0];
		String outputFileName = args[1];
		int depth = Integer.parseInt(args[2]);
		PositionList initialBoard = new PositionList(FileOperations.getBoardConfiguration(inputFileName));
		Output output = MiniMax(depth, true, initialBoard);
		FileOperations.writeOutput(output, outputFileName);
	}

	public static Output MiniMax(int depth, boolean isWhite, PositionList board){
		Output output = new Output();
		if (depth == 0){
			output.value = Generate.staticEstimationMidgameEndgameImproved(board);
			output.nodesCount++;
			return output;
		}
		Output in = new Output();
		ArrayList<PositionList> nextMoves = (isWhite) ? Generate.generateMovesMidgameEndgame(board) : Generate.generateMovesMidgameEndgameBlack(board);
		output.value = (isWhite) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		for (PositionList b : nextMoves){
			if (isWhite){
				in = MiniMax(depth - 1, false, b);
				output.nodesCount += in.nodesCount;
				if (in.value > output.value){
					output.value = in.value;
					output.a = b;
				}
			}
			else{
				in = MiniMax(depth - 1, true, b);
				output.nodesCount += in.nodesCount;
				output.nodesCount++;
				if (in.value < output.value){
					output.value = in.value;
					output.a = b;
				}
			}
		}
		return output;
	}
}
