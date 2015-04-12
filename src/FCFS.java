import java.util.Vector;

public class FCFS {
	public int TotalMovementRandom;
	public int TotalMovementAsc;
	public int TotalMovementDesc;
	public float AvgMovement;
	ListOfQueue List = new ListOfQueue();
	
	FCFS(){
		//List.generateAllTypeList();
		List.setAllTypeListFromFile();
		TotalMovementRandom = 0;
		TotalMovementAsc = 0;
		AvgMovement = 0;
		TotalMovementDesc = 0;
	}
	
	private int StartMove(Vector<Integer> myVec){
		int currPos = List.StartCylinder;
		int TotalMovement = 0;
		for(int i = 0; i < myVec.size(); i++){
			TotalMovement += Math.abs(currPos-myVec.elementAt(i));
			currPos = myVec.elementAt(i);
		}
		return TotalMovement;
	}
	
	public void getTotalMovementForEachList(){
		TotalMovementRandom = StartMove(List.Random);
		TotalMovementAsc= StartMove(List.Asc);
		TotalMovementDesc= StartMove(List.Desc);
		AvgMovement = (TotalMovementRandom+TotalMovementAsc+TotalMovementDesc)/3;
	}
	
	public void printEachTotalMovement(){
		System.out.println("\nResult from using FCFS algorithm ");
		System.out.println("Total movement from random input : "+TotalMovementRandom);
		System.out.println("Total movement from ascending input : "+TotalMovementAsc);
		System.out.println("Total movement from descending input : "+TotalMovementDesc);
		System.out.println("Average movement from all input : "+AvgMovement);
	}
}
