import java.util.Collections;
import java.util.Vector;


public class C_LOOK {
	public int TotalMovementRandom;
	public int TotalMovementAsc;
	public int TotalMovementDesc;
	public float AvgMovement;
	ListOfQueue List = new ListOfQueue();
	
	C_LOOK(){
		//List.generateAllTypeList();
		List.setAllTypeListFromFile();
		TotalMovementRandom = 0;
		TotalMovementAsc = 0;
		AvgMovement = 0;
		TotalMovementDesc = 0;
	}
	
	private boolean IsDirectionToZero(){
		return List.PrevCylinder > List.StartCylinder;
	}
	
	private int StartMove(Vector<Integer> myVec){
		int currPos = List.StartCylinder;
		myVec.add(currPos);
		Collections.sort(myVec);
		int TotalMovement = 0;
		int IdxCurrPos = myVec.indexOf(currPos);
		if(IsDirectionToZero())
			if(currPos == List.NumberOfCylinder-1)
				return currPos - myVec.elementAt(0);
			else
				TotalMovement = currPos-myVec.elementAt(0) + 1 + 
							myVec.elementAt(myVec.size()-1) - 
							myVec.elementAt(IdxCurrPos+1);
		else
			if(currPos == 0)
				return myVec.elementAt(myVec.size()-1);
			else
				TotalMovement = myVec.elementAt(myVec.size()-1)- currPos 
							+ 1 + myVec.elementAt(IdxCurrPos -1) -
							myVec.elementAt(0);
		return TotalMovement;
	}
	
	public void getTotalMovementForEachList(){
		TotalMovementRandom = StartMove(List.Random);
		TotalMovementAsc= StartMove(List.Asc);
		TotalMovementDesc= StartMove(List.Desc);
		AvgMovement = (TotalMovementRandom+TotalMovementAsc+TotalMovementDesc)/3;
	}
	
	public void printEachTotalMovement(){
		System.out.println("\nResult from using C_LOOK algorithm ");
		System.out.println("Total movement from random input : "+TotalMovementRandom);
		System.out.println("Total movement from ascending input : "+TotalMovementAsc);
		System.out.println("Total movement from descending input : "+TotalMovementDesc);
		System.out.println("Average movement from all input : "+AvgMovement);
	}
}
