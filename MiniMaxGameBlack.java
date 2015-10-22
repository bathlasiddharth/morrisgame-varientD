import java.io.IOException;
import java.util.ArrayList;




public class MiniMaxGameBlack {
	public static void main(String[] args) throws IOException{
		String inputFileName = args[0];
		String outputFileName = args[1];
		int depth = Integer.parseInt(args[2]);
		PositionList initialBoard = new PositionList(FileOperations.getBoardConfiguration(inputFileName));
		Output output = MiniMax(depth, true, initialBoard);
		FileOperations.writeOutput(output, outputFileName);
	}

	public static Output MiniMax(int depth, boolean isBlack, PositionList board){
		Output output = new Output();
		if (depth == 0){
			output.value = Generate.staticEstimationMidGameEndGame(board);
			output.nodesCount++;
			return output;
		}

		Output in = new Output();
		ArrayList<PositionList> nextMoves = (isBlack) ? Generate.generateMovesMidgameEndgameBlack(board) : Generate.generateMovesMidgameEndgame(board);
		output.value = (isBlack) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		for (PositionList b : nextMoves){
			if (isBlack){
				in = MiniMax(depth - 1, false, b);
				output.nodesCount += in.nodesCount;
				if (in.value > output.value)
				{
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
