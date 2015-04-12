import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;
import java.util.Collections;

public class ListOfQueue {
	public final int NumberOfCylinder = 100000;
	public final int DefaultNumberOfCylinder = 200;
	public int StartCylinder;
	public int PrevCylinder;
	public Vector<Integer> Random = new Vector<Integer>();
	public Vector<Integer> Asc = new Vector<Integer>();
	public Vector<Integer> Desc = new Vector<Integer>();
	public Vector<Integer> DefaultList = new Vector<Integer>();
	public int DefaultStart;
	ListOfQueue(){
		DefaultList.add(98);
		DefaultList.add(183);
		DefaultList.add(37);
		DefaultList.add(122);
		DefaultList.add(14);
		DefaultList.add(124);
		DefaultList.add(65);
		DefaultList.add(67);
		DefaultStart = 53;
	}
	
	public void generateAllTypeList(){
		generateStartAndPrevCylinderToFile();
		generateRandomToFile();
		generateAscToFile();
		generateDescToFile();
	}
	
	public void setAllTypeListFromFile(){
		setStartAndPrevCylinderToFile();
		setRandomFromFile();
		setAscFromFile();
		setDescFromFile();
	}
	
	private void generateStartAndPrevCylinderToFile(){
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(NumberOfCylinder);
		int start = randomInt;
		randomInt = randomGenerator.nextInt(NumberOfCylinder);
		int prev = randomInt;
		BufferedWriter outputWriter = null;
		  try {
			outputWriter = new BufferedWriter(new FileWriter("StartAndPrev.txt"));
			outputWriter.write(Integer.toString(start));
			  outputWriter.newLine();
			  outputWriter.write(Integer.toString(prev));
			  outputWriter.flush();  
			  outputWriter.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private void setStartAndPrevCylinderToFile(){
		Scanner s;
		try {
			s = new Scanner(new File("StartAndPrev.txt"));
			StartCylinder = s.nextInt();
			PrevCylinder = s.nextInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void makeRandomList(){
		Random.removeAllElements();
		Random randomGenerator = new Random();
		for(int i = 0; i <100 ; i++){
			int randomInt = randomGenerator.nextInt(NumberOfCylinder);
			if(!Random.contains(randomInt))
				Random.add(randomInt);
		}
	}
	
	private void writeRandomToFile() throws IOException{
		BufferedWriter outputWriter = null;
		  outputWriter = new BufferedWriter(new FileWriter("Random.txt"));
		  for (int i = 0; i < Random.size(); i++) {
		    outputWriter.write(Integer.toString(Random.elementAt(i)));
		    outputWriter.newLine();
		  }
		  outputWriter.flush();  
		  outputWriter.close();
		  Random.removeAllElements();
	}
	private void writeAscToFile() throws IOException{
		BufferedWriter outputWriter = null;
		  outputWriter = new BufferedWriter(new FileWriter("Asc.txt"));
		  for (int i = 0; i < Random.size(); i++) {
		    outputWriter.write(Integer.toString(Random.elementAt(i)));
		    outputWriter.newLine();
		  }
		  outputWriter.flush();  
		  outputWriter.close();
		  Random.removeAllElements();
	}
	private void writeDescToFile() throws IOException{
		BufferedWriter outputWriter = null;
		  outputWriter = new BufferedWriter(new FileWriter("Desc.txt"));
		  for (int i = Random.size() - 1 ; i >= 0; i--) {
		    outputWriter.write(Integer.toString(Random.elementAt(i)));
		    outputWriter.newLine();
		  }
		  outputWriter.flush();  
		  outputWriter.close();
		  Random.removeAllElements();
	}
	private void generateRandomToFile(){
		makeRandomList();
		try {
			writeRandomToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printVector(Vector<Integer> myVec){
		System.out.println("Elment in your vector : ");
		for (int i = 0 ; i < myVec.size() ; i++){
			System.out.println("Idx : "+i+"  "+myVec.elementAt(i));
		}
	}
	
	private void generateAscToFile(){
		makeRandomList();
		Collections.sort(Random);
		try {
			writeAscToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void generateDescToFile(){
		makeRandomList();
		Collections.sort(Random);
		try {
			writeDescToFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setRandomFromFile(){
		Random.removeAllElements();
		Scanner s;
		try {
			s = new Scanner(new File("Random.txt"));
			for (int i = 0; i < 100; i++){
			    Random.add(s.nextInt());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setAscFromFile(){
		Asc.removeAllElements();
		Scanner s;
		try {
			s = new Scanner(new File("Asc.txt"));
			for (int i = 0; i < 100; i++){
			    Asc.add(s.nextInt());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setDescFromFile(){
		Desc.removeAllElements();
		Scanner s;
		try {
			s = new Scanner(new File("Desc.txt"));
			for (int i = 0; i < 100; i++)
			    Desc.add(s.nextInt());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
