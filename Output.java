
public class Output {
	public int value, nodesCount;
	public PositionList a;
	public String toString(){
		return 	"BoardPosition:\t\t\t" + a + "\nPositions Evaluated:\t" + nodesCount + "\nMINIMAX estimate:\t\t" + value;
	}
	
}
