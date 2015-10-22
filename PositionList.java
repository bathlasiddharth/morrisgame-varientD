import java.util.*;


public class PositionList {
	public ArrayList<positionType> positionList;
	
	public PositionList(){
		positionList = new ArrayList();
		for (int i=0; i<23; i++)
			positionList.add(positionType.X);
	}
	
	public PositionList(ArrayList<Character> in){
		positionList = new ArrayList();
		for (char c:in){
			if(c=='W')
				positionList.add(positionType.W);
			else if(c=='X')
				positionList.add(positionType.X);
			else if(c=='B')
				positionList.add(positionType.B);
		}
	}
	
	public ArrayList<Character> getCharList(){
		ArrayList<Character> out = new ArrayList();
		for(positionType position:positionList)
			out.add(position.value);
		return out;
	}
	
	public PositionList getCopy(){
		ArrayList<Character> arr = getCharList();
		return (new PositionList(arr));
	}
	
	public int getPieceCount(positionType piece){
		int count=0;
		for(positionType pos:positionList){
			if(pos==piece)
				count++;
		}
		return count;
	}
	
	public PositionList flip(){
		PositionList output = new PositionList();
		for (int i = 0; i < positionList.size(); i++){
			positionType val = positionList.get(i);
			if (val == positionType.B)
				output.set(i, positionType.W);
			else if (val == positionType. W)
				output.set(i, positionType.B);
			else
				output.set(i, positionType.X);
		}
		return output;
	}
	
	public positionType get(int i){
		return positionList.get(i);
	}

	public int size(){
		return positionList.size();
	}

	public void add(positionType val){
		positionList.add(val);
	}

	public void set(int i, positionType val){
		positionList.set(i, val);
	}
	
	public String toString(){
		char[] output = new char[positionList.size()];
		for (int i = 0; i < positionList.size(); i++)
			output[i] = positionList.get(i).value;
		return new String(output);
	}
}
