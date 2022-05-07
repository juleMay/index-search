package Control;

import Model.Indexing;
import Utils.Stopwatch;

public class Controller {

	private Indexing database;
	private Stopwatch stopwatch;

	public Controller() {
		this.stopwatch = new Stopwatch();
		this.database = new Indexing();
		if (database.isFileCreated()) {
			database.initIndexing();
		}
	}

	
	public void createFile(int numRecords) {
		// crear archivo y arbol
		this.database.createFile(numRecords);
		// crear arbol si el archivo esta creado
		if (database.isFileCreated()) {
			database.initIndexing();
		}
	}
	
	
	public boolean isFileCreated() {
		return database.isFileCreated();
	}
	
	
	public boolean addRecord(int searchKey, int value) {
		return database.addRecord(searchKey, value);
	}

	
	public boolean isInRange(int value) {
		return (value > 0) && (value < 1000000);
	}

	
	public boolean isValidNumRecords(int value) {
		return (value > 0) && (value < 1000000);
	}
	
	
	public Object[] indexSearch(int searchKey) {
		startStopwatch();
		int value = database.indexSearch(searchKey);
		stopStopwatch();
		return searchResult(searchKey, value);
	}

	
	public Object[] secuencialSearch(int searchKey) {
		startStopwatch();
		int value = database.secuencialSearch(searchKey);
		stopStopwatch();
		return searchResult(searchKey, value);
	}
	
	
	private Object[] searchResult(int searchKey, int value) {
		Object[] varRow = null;
        if(value > 0) {
        	varRow = new Object[]{searchKey,value,elapsedTime(),""};
        }
        resetStopwatch();
		return varRow;
	}

	
	private void startStopwatch() {
		this.stopwatch.start();
	}

	
	private void stopStopwatch() {
		this.stopwatch.stop();
	}

	
	private void resetStopwatch() {
		this.stopwatch.reset();
	}

	
	private long elapsedTime() {
		return stopwatch.elapsedTime();
	}
}
