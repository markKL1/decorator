package decorator.whyuse.decorate;

import java.io.File;

import decorator.whyuse.shared.MyFileReader;
import decorator.whyuse.shared.MySequenceReader;
import decorator.whyuse.shared.Utils;
import decorator.whyuse.inkotlin.MyBufferedReaderKotlin;

public class DemoDecorate {
    public static void main(String[] args) {
        MyBufferedReaderKotlin rdr = new MyBufferedReaderKotlin(new MyFileReader(new File("demo.txt")));
        for (int k = 0; k < 250; k++) {
            System.out.println(k + ": " + rdr.readLine());
        }
        System.out.println("Those were the first 250 lines of " + rdr.getSourceName());
        // It also works for other readers!
        MyBufferedReaderKotlin seqrdr = new MyBufferedReaderKotlin(new MySequenceReader());
        // And it's polymorphic!
        Utils.functionForMyReaders(rdr);
    }
}
