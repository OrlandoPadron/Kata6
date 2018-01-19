
package kata6.controller;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramBuilder;
import kata6.view.HistogramDisplay;
import kata6.view.MailListReader;

public class Kata6 {
    
    private final String filename = "emails.txt";
    private List<Mail> mailList;
    
    private Histogram<String> domains;
    private Histogram<Character> letters;
    
    private HistogramBuilder<Mail> builder;
    
    
    
    public static void main(String[] args) throws IOException {
        Kata6 kata6 = new Kata6();
        kata6.execute();        
    }
    
    
    private final void execute() throws IOException {
        input();
        process();
        output();
    }
    
    private void input() throws IOException {
        mailList = MailListReader.read(filename);
        builder = new HistogramBuilder<>(mailList); 
    }
    
    private void process() {
        domains = builder.build(new Attribute<Mail, String>(){
            @Override
            public String get(Mail item){
                
                return item.getMail().split("@")[1]; 
            }
        });
        
        letters = builder.build(new Attribute<Mail, Character>(){
            @Override
            public Character get(Mail item){
                
                return item.getMail().charAt(0); 
            }
        
        });
    }
    
    private void output() {
        
        
        new HistogramDisplay<>(letters, "First character").execute(); 
        new HistogramDisplay<>(domains, "Domains").execute(); 

    }
    
    
    
    
}
