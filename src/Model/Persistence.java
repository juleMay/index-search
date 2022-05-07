package Model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Persistence {

    private String file;
    private final int RECORD_LIMIT;
    private final int RECORD_SIZE;

    public Persistence() {
        this.file = "src/Resources/data.txt";
        this.RECORD_LIMIT = 1000000;
        this.RECORD_SIZE = 14;
    }

    public Persistence(String path, String name, int recordLimit, int recordSize) {
        this.file = path + name;
        this.RECORD_LIMIT = recordLimit;
        this.RECORD_SIZE = recordSize;
    }

    public boolean isFileCreated() {
        try {
            RandomAccessFile varReader = new RandomAccessFile(this.file, "r");
            boolean varFlag = varReader.length() > 0;
            varReader.close();
            return varFlag;
        } catch (IOException ex) {
            return false;
        }
    }

    private void deleteRecords() {
        try {
            RandomAccessFile varWriter = new RandomAccessFile(this.file, "rw");
            varWriter.getChannel().truncate(0);
            varWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private byte[] createRecord(int searchKey, int value) {
        String varRecord;
        String varBlock = "             \n";
        varRecord = searchKey + " " + value;
        varRecord += varBlock.substring(varRecord.length());
        return varRecord.getBytes(StandardCharsets.UTF_8);
    }

    public void createFile(int[] searchKeys) {
        deleteRecords();
        try {
            RandomAccessFile varWriter = new RandomAccessFile(this.file, "rw");
            FileChannel varChannel = varWriter.getChannel();
            ByteBuffer varBuffer = ByteBuffer.allocate(RECORD_SIZE);
            Random varRandom = new Random();
            for (int i = 0; i < searchKeys.length; i++) {
                varBuffer = ByteBuffer.wrap(createRecord(searchKeys[i], varRandom.nextInt(RECORD_LIMIT - 1) + 1));
                varChannel.write(varBuffer, i * RECORD_SIZE);
            }
            varChannel.close();
            varWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int addRecord(int searchKey, int value) {
        try {
            RandomAccessFile varWriter = new RandomAccessFile(this.file, "rw");
            FileChannel varChannel = varWriter.getChannel();
            ByteBuffer varBuffer = ByteBuffer.allocate(RECORD_SIZE);
            int varIndex = (int) varChannel.size();
            varBuffer = ByteBuffer.wrap(createRecord(searchKey, value));
            varChannel.write(varBuffer, varIndex);
            varChannel.close();
            varWriter.close();
            return varIndex / RECORD_SIZE;
        } catch (IOException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public String getRecord(int index) {
        try {
            RandomAccessFile varReader = new RandomAccessFile(this.file, "r");
            FileChannel varChannel = varReader.getChannel();
            ByteBuffer varBuffer = ByteBuffer.allocate(RECORD_SIZE - 1);
            varChannel.read(varBuffer, index * RECORD_SIZE);
            varChannel.close();
            varReader.close();
            return new String(varBuffer.array(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getRecords() {
        try {
            RandomAccessFile varReader = new RandomAccessFile(this.file, "r");
            FileChannel varChannel = varReader.getChannel();
            ByteBuffer varBuffer = ByteBuffer.allocate((int) varChannel.size());
            varChannel.read(varBuffer);
            varChannel.close();
            varReader.close();
            return new String(varBuffer.array(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}