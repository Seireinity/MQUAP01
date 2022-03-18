/*  12/30/2021: Stopwords removal is needed
    02/24/2022: Testing pre-prototype with text preprocessing
    03/09/2022: Testing initial prototype with txt file
    03/10/2022: Saving data space by reducing hashsets
 */
package mquap01;
import java.util.ArrayList;

/**
 *
 * @author Janelle Achondo, Caryl Shainet Parro
 */
public class Stopwords {
    public String str; //topic per line
    String[] strArr;
    ArrayList<String> stopwords_courseTopics = new ArrayList<>();
    ArrayList<String> stopwords_certTopics = new ArrayList<>();
    
    String[] stopwords = { "a", "about", "above", "across", "after", "again",
            "against", "all", "almost", "alone", "along", "already", "also",
            "although", "always", "among", "an", "and", "another", "any",
            "anybody", "anyone", "anything", "anywhere", "are", "area",
            "areas", "around", "as", "ask", "asked", "asking", "asks", "at",
            "away", "b", "back", "backed", "backing", "backs", "be", "became",
            "because", "become", "becomes", "been", "before", "began",
            "behind", "being", "beings", "best", "better", "between", "big",
            "both", "but", "by", "c", "came", "can", "cannot", "case", "cases",
            "certain", "certainly", "clear", "clearly", "come", "could", "d",
            "did", "differ", "different", "differently", "do", "does", "done",
            "down", "down", "downed", "downing", "downs", "during", "e",
            "each", "early", "either", "end", "ended", "ending", "ends",
            "enough", "even", "evenly", "ever", "every", "everybody",
            "everyone", "everything", "everywhere", "f", "face", "faces",
            "fact", "facts", "far", "felt", "few", "find", "finds", "first",
            "for", "four", "from", "full", "fully", "further", "furthered",
            "furthering", "furthers", "g", "gave", "general", "generally",
            "get", "gets", "give", "given", "gives", "go", "going", "good",
            "goods", "got", "great", "greater", "greatest", "group", "grouped",
            "grouping", "groups", "h", "had", "has", "have", "having", "he",
            "her", "here", "herself", "high", "high", "high", "higher",
            "highest", "him", "himself", "his", "how", "however", "i", "if",
            "important", "in", "interest", "interested", "interesting",
            "interests", "into", "is", "it", "its", "itself", "j", "just", "k",
            "keep", "keeps", "kind", "knew", "know", "known", "knows", "l",
            "large", "largely", "last", "later", "latest", "least", "less",
            "let", "lets", "like", "likely", "long", "longer", "longest", "m",
            "made", "make", "making", "man", "many", "may", "me", "member",
            "members", "men", "might", "more", "most", "mostly", "mr", "mrs",
            "much", "must", "my", "myself", "n", "necessary", "need", "needed",
            "needing", "needs", "never", "new", "new", "newer", "newest",
            "next", "no", "nobody", "non", "noone", "not", "nothing", "now",
            "nowhere", "number", "numbers", "o", "of", "off", "often", "old",
            "older", "oldest", "on", "once", "one", "only", "open", "opened",
            "opening", "opens", "or", "order", "ordered", "ordering", "orders",
            "other", "others", "our", "out", "over", "p", "part", "parted",
            "parting", "parts", "per", "perhaps", "place", "places", "point",
            "pointed", "pointing", "points", "possible", "present",
            "presented", "presenting", "presents", "problem", "problems",
            "put", "puts", "q", "quite", "r", "rather", "really", "right",
            "right", "room", "rooms", "s", "said", "same", "saw", "say",
            "says", "second", "seconds", "see", "seem", "seemed", "seeming",
            "seems", "sees", "several", "shall", "she", "should", "show",
            "showed", "showing", "shows", "side", "sides", "since", "small",
            "smaller", "smallest", "so", "some", "somebody", "someone",
            "something", "somewhere", "state", "states", "still", "still",
            "such", "sure", "t", "take", "taken", "than", "that", "the",
            "their", "them", "then", "there", "therefore", "these", "they",
            "thing", "things", "think", "thinks", "this", "those", "though",
            "thought", "thoughts", "three", "through", "thus", "to", "today",
            "together", "too", "took", "toward", "turn", "turned", "turning",
            "turns", "two", "u", "under", "until", "up", "upon", "us", "use",
            "used", "uses", "v", "very", "w", "want", "wanted", "wanting",
            "wants", "was", "way", "ways", "we", "well", "wells", "went",
            "were", "what", "when", "where", "whether", "which", "while",
            "who", "whole", "whose", "why", "will", "with", "within",
            "without", "work", "worked", "working", "works", "would", "x", "y",
            "year", "years", "yet", "you", "young", "younger", "youngest",
            "your", "yours", "z" };
    
    
    public Stopwords(){ //CONSTRUCTOR
    }
    
    //------------------------------------ ENCAPSULATION FIELDS (GETTERS AND SETTERS)
    public String getString(){
        return str;
    }
    
    /**
     * @param userStr sets the string per line in file to this class -> str
     */
    public void setString(String userStr){
        this.str = userStr;
    }
    
    public ArrayList<String> getList_courseTopics(){
        return (stopwords_courseTopics); 
    } 
    
    public ArrayList<String> getList_certTopics(){
        return (stopwords_certTopics); 
    }
    
    //------------------------------------ METHODS
    
    public void course_StringToArray(){
        str = str.trim().replaceAll("\\s+" , " ");
        String strArray[] = str.split(" "); //split in array
        
        for(String topic : strArray){ //add topics from array to an ArrayList
            stopwords_courseTopics.add(topic);
        }
        
        removeStopword(stopwords_courseTopics);
    }
    
    public void cert_StringToArray(){
        str = str.trim().replaceAll("\\s+" , " ");
        String strArray[] = str.split(" "); //split in array
        
        for(String topic : strArray){ //add topics from array to an ArrayList
            stopwords_certTopics.add(topic);
        }
        
        removeStopword(stopwords_certTopics);
    }
    
    /**
     * @param topics After splitting the words from String Array(strArray) to String ArrayList (words), will check for stopwords then remove all
     */
    public void removeStopword(ArrayList<String> topics){
        
        for(int i=0; i<stopwords.length; i++){
            if(topics.contains(stopwords[i])){
                topics.remove(stopwords[i]);
            }
        }
    }
    
     
    
}
