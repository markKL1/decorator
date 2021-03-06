package decorator.whyuse.decorate;

import java.util.LinkedList;
import java.util.Queue;

import decorator.whyuse.shared.MyReader;

public class MyBufferedReaderDecorate implements MyReader {

    final private Queue<String> lines = new LinkedList<String>();
    final private MyReader reader;

    public MyBufferedReaderDecorate(MyReader reader) {
        this.reader = reader;
    }

    public String readLine() {
        if (lines.size() == 0) {
            for (int k = 0; k < 100; k++) {
                lines.add(reader.readLine());
            }
        }
        return lines.remove();
    }

    // NOT an override
    public String getSourceName() {
        // Rather boring to write this...
        return reader.getSourceName();
    }
}
