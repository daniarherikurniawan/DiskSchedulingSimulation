
public class MainDiskScheduling {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C_LOOK myC_LOOK = new C_LOOK();
		myC_LOOK.getTotalMovementForEachList();
		myC_LOOK.printEachTotalMovement();
		
		LOOK myLOOK = new LOOK();
		myLOOK.getTotalMovementForEachList();
		myLOOK.printEachTotalMovement();
		
		C_SCAN myC_SCAN = new C_SCAN();
		myC_SCAN.getTotalMovementForEachList();
		myC_SCAN.printEachTotalMovement();
		
		
		SCAN mySCAN = new SCAN();
		mySCAN.getTotalMovementForEachList();
		mySCAN.printEachTotalMovement();
		
		SSTF mySSTF = new SSTF();
		mySSTF.getTotalMovementForEachList();
		mySSTF.printEachTotalMovement();
		
		FCFS myFCFS = new FCFS();
		myFCFS.getTotalMovementForEachList();
		myFCFS.printEachTotalMovement();
	}
}
