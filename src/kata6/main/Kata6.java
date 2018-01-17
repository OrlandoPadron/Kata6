
package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    public static void main(String[] args) throws IOException {
        
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }
    
    private final String filename = "emails.txt";
    private List<String> mailList;
    private Histogram<String> histogram;
    
    private final void execute() throws IOException {
        input();
        process();
        output();
    }
    
    private void input() throws IOException {
        mailList = MailListReader.read(filename);
    }
    
    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
    
    
    
}
