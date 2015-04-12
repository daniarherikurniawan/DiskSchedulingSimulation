import java.util.Collections;
import java.util.Vector;

public class SSTF {
	public int TotalMovementRandom;
	public int TotalMovementAsc;
	public int TotalMovementDesc;
	public float AvgMovement;
	ListOfQueue List = new ListOfQueue();
	
	SSTF(){
		//List.generateAllTypeList();
		List.setAllTypeListFromFile();
		TotalMovementRandom = 0;
		TotalMovementAsc = 0;
		AvgMovement = 0;
		TotalMovementDesc = 0;
	}
	
	private int StartMove(Vector<Integer> myVec){
		int currPos = List.StartCylinder;
		myVec.add(currPos);
		Collections.sort(myVec);
		int TotalMovement = 0;		
		
		while(myVec.size()>1){
			int IdxCurrPos = myVec.indexOf(currPos);
			int DistanceWithPrev = 99999999;
			int DistanceWithNext = 99999999;
			if(IdxCurrPos!=0)
				DistanceWithPrev = Math.abs(currPos - myVec.elementAt(IdxCurrPos - 1));
			if(IdxCurrPos!=myVec.size()-1)
				DistanceWithNext = Math.abs(currPos - myVec.elementAt(IdxCurrPos + 1));
			if(DistanceWithNext < DistanceWithPrev){
				currPos = myVec.elementAt(IdxCurrPos +1);
				TotalMovement += DistanceWithNext;
			}else{
				currPos = myVec.elementAt(IdxCurrPos -1);
				TotalMovement += DistanceWithPrev;
			}
			myVec.removeElementAt(IdxCurrPos);
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
		System.out.println("\nResult from using SSTF algorithm ");
		System.out.println("Total movement from random input : "+TotalMovementRandom);
		System.out.println("Total movement from ascending input : "+TotalMovementAsc);
		System.out.println("Total movement from descending input : "+TotalMovementDesc);
		System.out.println("Average movement from all input : "+AvgMovement);
	}
}
