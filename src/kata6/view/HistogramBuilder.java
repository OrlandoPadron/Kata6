package kata6.view;

import kata6.controller.Attribute; 
import java.util.List; 
import kata6.model.Histogram; 


public class HistogramBuilder<T> {
   
    private final List<T> items;
 
    
    public HistogramBuilder(List<T> items){
        this.items = items; 
    }
    
    public <A> Histogram<A> build(Attribute<T,A> attribute){
        Histogram<A> histog = new Histogram<>(); 
        for (T item : items){
            A value = attribute.get(item);
            histog.increment(value); 
            
        }
        return histog; 
    }
    
}
