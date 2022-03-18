/*
03/15/22 - Read file and splitting text class
 */
package mquap01;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 *
 * @author Janelle Achondo, Caryl Shainet Parro
 */
public class ReadFile extends Stopwords {

  

    //COURSE
    private String course_file;
    public List<String> course_topics; //Create arraylist to get topics only
    private List<String> course_title;   //create arraylist to get the title only
    private String[] course_split;
    public String[] courseTopics; //topics arraylist transfer to String array
    
    //CERTIFICATION
    private String cert_file;
    public List<String> cert_topics; 
    private List<String> cert_title;   
    private String[] cert_split;
    public String[] certificationTopics; //certificationTopics arraylist transfer to String array
    
    //PATTERN
    private String pattern;
    
    //FOR STOPWORDS() CLASS
    private ArrayList<String> course_tempArray;
    private String[] course_listToArray;
    
    private ArrayList<String> cert_tempArray;
    private String[] cert_listToArray;
    
    public Stopwords s;
    
    public ReadFile()throws IOException{ //CONSTRUCTOR
        course_topics = new ArrayList<>();
        course_title = new ArrayList<>();
        
        cert_topics = new ArrayList<>();
        cert_title = new ArrayList<>();
        
        pattern = "[topic]?s?:";
        
        course_tempArray = new ArrayList<>();
        cert_tempArray = new ArrayList<>();
        
        s = new Stopwords();
    }
    
    //------------------------------------ ENCAPSULATION FIELDS (GETTERS AND SETTERS)
    
      /**
     * @return the cert_tempArray
     */
    public ArrayList<String> getCert_tempArray() {
        return cert_tempArray;
    }

    /**
     * @param cert_tempArray the cert_tempArray to set
     */
    public void setCert_tempArray(ArrayList<String> cert_tempArray) {
        this.cert_tempArray = cert_tempArray;
    }

    /**
     * @return the cert_listToArray
     */
    public String[] getCert_listToArray() {
        return cert_listToArray;
    }

    /**
     * @param cert_listToArray the cert_listToArray to set
     */
    public void setCert_listToArray(String[] cert_listToArray) {
        this.cert_listToArray = cert_listToArray;
    }

    /**
     * @return the course_tempArray
     */
    public ArrayList<String> getCourse_TempArray() {
        return course_tempArray;
    }

    /**
     * @param course_tempArray the tempArray to set
     */
    public void setCourse_TempArray(ArrayList<String> course_tempArray) {
        this.course_tempArray = course_tempArray;
    }

    /**
     * @return the listToArray
     */
    public String[] getCourse_listToArray() {
        return course_listToArray;
    }

    /**
     * @param course_listToArray the listToArray to set
     */
    public void setCourse_listToArray(String[] course_listToArray) {
        this.course_listToArray = course_listToArray;
    }
    
    /**
     * @return the course_file
     */
    public String getCourse_file() {
        return course_file;
    }

    /**
     * @param course_file the course_file to set
     */
    public void setCourse_file(String course_file) {
        this.course_file = course_file;
    }

    /**
     * @return the course_topics
     */
    public List<String> getCourse_topics() {
        return course_topics;
    }

    /**
     * @param course_topics the course_topics to set
     */
    public void setCourse_topics(List<String> course_topics) {
        this.course_topics = course_topics;
    }

    /**
     * @return the course_title
     */
    public List<String> getCourse_title() {
        return course_title;
    }

    /**
     * @param course_title the course_title to set
     */
    public void setCourse_title(List<String> course_title) {
        this.course_title = course_title;
    }

    /**
     * @return the cert_file
     */
    public String getCert_file() {
        return cert_file;
    }

    /**
     * @param cert_file the cert_file to set
     */
    public void setCert_file(String cert_file) {
        this.cert_file = cert_file;
    }

    /**
     * @return the cert_topics
     */
    public List<String> getCert_topics() {
        return cert_topics;
    }

    /**
     * @param cert_topics the cert_topics to set
     */
    public void setCert_topics(List<String> cert_topics) {
        this.cert_topics = cert_topics;
    }

    /**
     * @return the cert_title
     */
    public List<String> getCert_title() {
        return cert_title;
    }

    /**
     * @param cert_title the cert_title to set
     */
    public void setCert_title(List<String> cert_title) {
        this.cert_title = cert_title;
    }
    
    /**
     * @return the cert_split
     */
    public String[] getCert_split() {
        return cert_split;
    }

    /**
     * @param cert_split the cert_split to set
     */
    public void setCert_split(String[] cert_split) {
        this.cert_split = cert_split;
    }

    /**
     * @return the certificationTopics
     */
    public String[] getCertificationTopics() {
        return certificationTopics;
    }

    /**
     * @param certificationTopics the certificationTopics to set
     */
    public void setCertificationTopics(String[] certificationTopics) {
        this.certificationTopics = certificationTopics;
    }

    /**
     * @return the course_split
     */
    public String[] getCourse_split() {
        return course_split;
    }

    /**
     * @param course_split the course_split to set
     */
    public void setCourse_split(String[] course_split) {
        this.course_split = course_split;
    }

    /**
     * @return the courseTopics
     */
    public String[] getCourseTopics() {
        return courseTopics;
    }

    /**
     * @param courseTopics the courseTopics to set
     */
    public void setCourseTopics(String[] courseTopics) {
        this.courseTopics = courseTopics;
    }
    
    //------------------------------------ METHODS
    
    public void splitCourse(String course_file){
        course_split = course_file.toLowerCase().split(pattern);
        course_title.add(course_split[0]);
        course_topics.add(course_split[1]);
        
        course_listToArray(course_topics);
    }
    
    public void splitCertification(String cert_file){
        cert_split = cert_file.toLowerCase().split(pattern);
        cert_title.add(cert_split[0]);
        cert_topics.add(cert_split[1]);
        
        cert_listToArray(cert_topics);
    }
    
    public void course_listToArray(List<String> course_topics){
        courseTopics = course_topics.get(0).split(System.lineSeparator());
    }
    
    public void cert_listToArray(List<String> cert_topics){
        certificationTopics = cert_topics.get(0).split(System.lineSeparator());
    }
    
    public void course_removeStopwords(){
        for(int i=1; i<courseTopics.length; i++){
            s.setString(courseTopics[i]);
            s.course_StringToArray();
        }
        
        //convert ArrayList to Array for RemoveDuplicates() class
        course_tempArray = s.getList_courseTopics(); 
        course_listToArray = new String[course_tempArray.size()];
        course_listToArray = course_tempArray.toArray(course_listToArray);
    }
    
    public void cert_removeStopwords(){
        for(int i=1; i<certificationTopics.length; i++){
            s.setString(certificationTopics[i]);
            s.cert_StringToArray();
        }
        
        //convert ArrayList to Array for RemoveDuplicates() class
        cert_tempArray = s.getList_certTopics(); 
        cert_listToArray = new String[cert_tempArray.size()];
        cert_listToArray = cert_tempArray.toArray(cert_listToArray);
    }
    
    
}
