package decorator.whyuse.shared;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MyFileReader implements MyReader {

    final private Scanner youDoAllTheWorkOk;
    final private File file;

    public MyFileReader(File in) {
        this.file = in;
        try {
            youDoAllTheWorkOk = new Scanner(new FileReader(in));
        } catch (FileNotFoundException e) {
            throw new IllegalStateException("Couldn't open file");
        }
    }

    @Override
    public String readLine() {
        return youDoAllTheWorkOk.nextLine();
    }

    @Override
    public String getSourceName() {
        return file.getName();
    }
}

