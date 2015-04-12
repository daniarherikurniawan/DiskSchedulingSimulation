import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class SCAN {
	public int TotalMovementRandom;
	public int TotalMovementAsc;
	public int TotalMovementDesc;
	public float AvgMovement;
	ListOfQueue List = new ListOfQueue();
	
	SCAN(){
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
		if(IsDirectionToZero())
			TotalMovement = currPos+ myVec.elementAt(myVec.size()-1);
		else
			TotalMovement = (List.NumberOfCylinder - 1 - currPos) + 
							(List.NumberOfCylinder - 1 - myVec.elementAt(0));
		return TotalMovement;
	}
	
	public void getTotalMovementForEachList(){
		TotalMovementRandom = StartMove(List.Random);
		TotalMovementAsc= StartMove(List.Asc);
		TotalMovementDesc= StartMove(List.Desc);
		AvgMovement = (TotalMovementRandom+TotalMovementAsc+TotalMovementDesc)/3;
	}
	
	public void printEachTotalMovement(){
		System.out.println("\nResult from using SCAN algorithm ");
		System.out.println("Total movement from random input : "+TotalMovementRandom);
		System.out.println("Total movement from ascending input : "+TotalMovementAsc);
		System.out.println("Total movement from descending input : "+TotalMovementDesc);
		System.out.println("Average movement from all input : "+AvgMovement);
	}
}
