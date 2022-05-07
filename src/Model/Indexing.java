package Model;

import java.util.Random;

import BPlusTree.BPlusTree;

public class Indexing {
	
    private BPlusTree tree;
    private Persistence file;
    private final int recordLimit = 999999;

    public Indexing() {
        this.tree = new BPlusTree(5);
        this.file = new Persistence();
    }

    private int[] randomIntArray(int n) {
        int[] varIntArray = new int[n];
        Random varRandom = new Random();
        int varRandInt = 0;
        int varNumRands = (int) (recordLimit - n) / 2;
        for (int i = 0; i < varIntArray.length; i++) {
            if (varNumRands > 0) {
                varRandInt += varRandom.nextInt(2);
                varNumRands--;
            }
            varRandInt++;
            varIntArray[i] = varRandInt;
        }
        int varRandIndex;
        int varTemp;
        for (int i = 0; i < varIntArray.length; i++) {
            varRandIndex = varRandom.nextInt(varIntArray.length);
            varTemp = varIntArray[varRandIndex];
            varIntArray[varRandIndex] = varIntArray[i];
            varIntArray[i] = varTemp;
        }
        return varIntArray;
    }

    public void createFile(int numRecords) {
        int[] searchKeys = randomIntArray(numRecords);
        for (int i = 0; i < searchKeys.length; i++) {
            tree.insert(searchKeys[i], i);
        }
        file.createFile(searchKeys);
    }

    public boolean addRecord(int searchKey, int value) {
        if (tree.search(searchKey) == null) {
            int index = file.addRecord(searchKey, value);
            if (index != -1) {
                tree.insert(searchKey, index);
                return true;
            }
        }
        return false;
    }

    private int[] getRecord(String record) {
        int[] varRecordArray = new int[2];
        String varKey = record.substring(0, record.indexOf(" "));
        String varValue = record.substring(record.indexOf(" ") + 1);
        int varEndIndex = varValue.indexOf(" ") < 0 ? varValue.length() : varValue.indexOf(" ");
        varValue = varValue.substring(0, varEndIndex);
        varRecordArray[0] = Integer.parseInt(varKey);
        varRecordArray[1] = Integer.parseInt(varValue);
        return varRecordArray;
    }

    /*
     * Busqueda sobre archivo public int secuencialSearch(int searchKey) { int[]
     * varRecords = getRecord(file.getRecord(0)); int i = 1; while (i <
     * this.recordLimit) { i++; varRecords = getRecord(file.getRecord(0)); if
     * (varRecords[0] == searchKey) { return varRecords[1]; } } return -1; }
     */

    public int secuencialSearch(int searchKey) {
        String[] varRecords = file.getRecords().split("\n");
        int[] varRecord;
        for (int i = 0; i < varRecords.length; i++) {
            varRecord = getRecord(varRecords[i]);
            if (varRecord[0] == searchKey) {
                return varRecord[1];
            }
        }
        return -1;
    }

    public int indexSearch(int searchKey) {
        Integer index = tree.search(searchKey);
        if (index != null) {
            return getRecord(file.getRecord(index))[1];
        }
        return -1;
    }

    public boolean isFileCreated() {
        return this.file.isFileCreated();
    }

    public void initIndexing() {
        String[] varRecords = file.getRecords().split("\n");
        BPlusTree varTree = new BPlusTree(5);
        int[] varRecord;
        for (int i = 0; i < varRecords.length; i++) {
            varRecord = getRecord(varRecords[i]);
            varTree.insert(varRecord[0], i);
        }
        this.tree = varTree;
    }
}