# morrisgame-varientD

Programming Environment: Eclipse, Java

To compile the source codes:
	javac *.java

To run the program:
	java <programName> <inputFileName> <outputFileName> <depth>
	List of programs:
		ABGame
		ABOpening
		MiniMaxGame
		MiniMaxGameBlack
		MiniMaxGameImproved
		MiniMaxOpening
		MiniMaxOpeningBlack
		MiniMaxOpeningImproved
		
Outputs for 2 input cases are shown in Output.txt

Improvement of Static Estimation function: I created a function to calculate how many potential mills W has. I returned estimated value as 1000*(whiteCount - blackCount + potentialMillCount) - movesCount in case where all given conditions i.e. #black pieces and #white pieces are more than 2. 
