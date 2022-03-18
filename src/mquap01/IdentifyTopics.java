/**
 * Testing string pattern matching algorithms
 *  Identify "Topics" "Topic" in a document
 */
package mquap01;

/**
 *
 * @author Janelle Achondo, Caryl Shainet Parro
 */
public class IdentifyTopics {
    public String text;
    public String pattern;
    
    public IdentifyTopics(){ //CONSTRUCTOR 
    }
    
    /**
     * @param text sets the string this class -> text
     */
    public void setText(String text){
        this.text = text;
    }
    
    public String getString(){
        return text;
    }
    
    /**
     * @param text gets the whole text
     * @param pattern the string to search @param text
     * @return if the pattern exists in text or not
     */
    public boolean brute_force(String text, String pattern){ 
        int length = text.length();//length of the text
        int p_length = pattern.length();//length of the pattern;

        //loop condition
        for(int i=0;i<=length-p_length;i++){
            //initialization of j
            int j=0;
            while((j < p_length) && (text.charAt(i+j) == pattern.charAt(j))){
                    j++;
            }
            if(j == p_length){
                    //System.out.println("TOPICS CONFIRMED!\n"); //debug output
                    return true;
            }
        }

        //System.out.println("INVALID FILE!\n"); //debug output
        return false;
    } 
}
