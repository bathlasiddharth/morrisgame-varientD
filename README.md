# morrisgame-varientD

Programming Environment: Eclipse, Java<br>

To compile the source codes:<br>
	javac *.java<br>

To run the program:<br>
	java <programName> <inputFileName> <outputFileName> <depth><br>
	List of programs:<br>
		ABGame<br>
		ABOpening<br>
		MiniMaxGame<br>
		MiniMaxGameBlack<br>
		MiniMaxGameImproved<br>
		MiniMaxOpening<br>
		MiniMaxOpeningBlack<br>
		MiniMaxOpeningImproved<br>
		
Outputs for 2 input cases are shown in Output.txt<br>
<br><br>
Improvement of Static Estimation function: I created a function to calculate how many potential mills W has. I returned estimated value as 1000*(whiteCount - blackCount + potentialMillCount) - movesCount in case where all given conditions i.e. #black pieces and #white pieces are more than 2. 
