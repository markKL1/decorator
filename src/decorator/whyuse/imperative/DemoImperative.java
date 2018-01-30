package decorator.whyuse.imperative;

import java.io.File;

import decorator.whyuse.shared.MyReader;
import decorator.whyuse.shared.Utils;

public class DemoImperative {
    public static void main(String[] args) {
        MyReader rdr = new MyMaybeBufferedReaderImperative(new File("demo.txt"), true);
        for (int k = 0; k < 250; k++) {
            System.out.println(k + ": " + rdr.readLine());
        }
        System.out.println("Those were the first 250 lines of " + rdr.getSourceName());
        // It doesn't work with other readers...
        // MyReader seqrdr = new MyMaybeBufferedReaderImperative(new MySequenceReader());
        // It IS polymorphic
        Utils.functionForMyReaders(rdr);
    }
}
