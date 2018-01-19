
package kata6.controller;

import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramBuilder;
import kata6.view.HistogramDisplay;
import kata6.view.MailListReader;
import java.sql.SQLException;
import kata6.model.Person; 
import kata6.view.DataBaseList; 

public class Kata6 {
    
    private final String filename = "emails.txt";
    private List<Mail> mailList;
    
    private List<Person> personList; 
    
    private HistogramBuilder<Mail> builderMail;
    private HistogramBuilder<Person> builderPerson; 
    
    private Histogram<String> domains;
    private Histogram<Character> letters;
    private Histogram<Character> gender;
    private Histogram<Float> weight; 
    

    
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Kata6 kata6 = new Kata6();
        kata6.execute();        
    }
    
    
    private final void execute() throws IOException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
    
    private void input() throws IOException, ClassNotFoundException, SQLException {
        mailList = MailListReader.read(filename);
        
        personList = DataBaseList.read();
        builderMail = new HistogramBuilder<>(mailList);
        personList = DataBaseList.read(); 
        builderMail = new HistogramBuilder<>(mailList); 
        builderPerson = new HistogramBuilder<>(personList); 
    }
    
    private void process() {
        domains = builderMail.build(new Attribute<Mail, String>(){
            @Override
            public String get(Mail item){
                
                return item.getMail().split("@")[1]; 
            }
        });
        
        letters = builderMail.build(new Attribute<Mail, Character>(){
            @Override
            public Character get(Mail item){
                
                return item.getMail().charAt(0); 
            }
        
        });
    }
    
    private void output() {
        
        
        new HistogramDisplay<>(letters, "First character", "Number of emails").execute(); 
        new HistogramDisplay<>(domains, "Domains", "Number of emails").execute(); 
        new HistogramDisplay<>(gender, "Gender", "Number of persons").execute(); 
        new HistogramDisplay<>(weight, "Weight", "Number of persons").execute(); 

    }
    
    
    
    
}
