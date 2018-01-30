package decorator.whyuse.imperative;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import decorator.whyuse.shared.MyReader;

public class MyMaybeBufferedReaderImperative implements MyReader {

    final private Queue<String> lines = new LinkedList<String>();
    private final Scanner youDoAllTheWorkOk;
    private final File file;
    private final boolean isBuffered;

    public MyMaybeBufferedReaderImperative(File in, boolean buffered) {
        this.isBuffered = buffered;
        this.file = in;
        try {
            youDoAllTheWorkOk = new Scanner(new FileReader(in));
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Couldn't open file");
        }
    }

    public String getSourceName() {
        return file.getName();
    }

    public String readLine() {
        if (lines.size() == 0) {
            if (isBuffered) {
                for (int k = 0; k < 100; k++) {
                    lines.add(youDoAllTheWorkOk.nextLine());
                }
            } else {
                lines.add(youDoAllTheWorkOk.nextLine());
            }
        }
        return lines.remove();
    }
}
