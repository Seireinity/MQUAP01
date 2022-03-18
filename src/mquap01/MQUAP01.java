
package mquap01;

/**
 * 03/09/2022: Testing initial prototype with txt file
 * @author Janelle Achondo, Caryl Shainet Parro
 * 1. Alternative to Excel (.txt) file. Reads text from file    
 * //Create like set string for Porter Stemmer to loop through the array of stem words or try array
 */

import java.lang.String;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.Arrays;


public class MQUAP01 {
    

    public static void main(String[] args) throws CloneNotSupportedException{
        
        /**
         *  [Use SemanticSimilarity() class]
         * ------------------------------------
         *  Left side -> Files -> Right click MQUAP01 -> Properties -> Libraries -> Add JAR -> 
         *  MQUAP01 > lib > Select all and Open
         * 
        */
        
        try{
            //*********************************** IGNORE
            //List<String> topics = new ArrayList<String>(); //Create arraylist to get topics only
            //List<String> title = new ArrayList<String>();   //create arraylist to get the title only
            //*********************************** IGNORE
            
            String course, certification;
            
            //INSTANTIATE FROM CLASSES (PorterStemmmer class NOT USED)
            IdentifyTopics it = new IdentifyTopics();
            //Stopwords stopwords = new Stopwords(); 
            ReadFile f = new ReadFile();
            RemoveDuplicates r = new RemoveDuplicates();


            String p = "topic"; //word to check in file
            //String pattern = "[topic]?s?:"; //regular expression (regex) pattern to only get the topics //*********************************** IGNORE

            //1. Reads files: CHANGE when you have the txt file in your folder, this is my folder
            course = new Scanner(new File("C:\\Users\\admin\\Documents\\NetBeansProjects\\MQUAP01\\Java Course Sample.txt")).useDelimiter("\\Z").next();
            certification = new Scanner(new File("C:\\Users\\admin\\Documents\\NetBeansProjects\\MQUAP01\\Java Certification Sample.txt")).useDelimiter("\\Z").next();
                    
            //Set course information to ReadFile class
            f.setCourse_file(course);
            System.out.println(f.getCourse_file()); //displays file
            
            //Set certification information to ReadFile class
            f.setCert_file(certification);
            System.out.println("\n\n" + f.getCert_file());
            
            
            //2. checks if word topic exist in file
            
            if((it.brute_force(course.toLowerCase(), p)) == true && (it.brute_force(certification.toLowerCase(), p)) == true){

                //3. if yes, split content to only get the topics list
                
                //*********************************** IGNORE
                //String [] res = content.toLowerCase().split(pattern);
                //title.add(res[0]); //title is stored in one element in one array
                //topics.add(res[1]); //topics is stored in one element in one array
                //*********************************** IGNORE
                
                System.out.println("\n\n COURSE TOPICS");
                System.out.println("---------------");
                f.splitCourse(course); //splits title and topics in file
                
                String[] courseT = f.getCourseTopics();
                
                for(String i: courseT)
                    System.out.println(i); //display course topics only
                
                
                System.out.println("\n\n CERTIFICATION TOPICS");
                System.out.println("----------------------");
                f.splitCertification(certification);
                
                String[] certificationT = f.getCertificationTopics();
                
                for(String i: certificationT)
                    System.out.println(i);  //display certification topics only
                
                 //Split that one element to multiple elements of file per line
                //String[] test = topics.get(0).split(System.lineSeparator()); //topics arraylist transfer to String array, each array element contains one topic :D ! (YEY! FINALLY!)
                
                System.out.println("");                
                
                //4. Remove stopwords and duplicates

                System.out.println("\nTopics extracted from file:");
                System.out.println("---------------------------");
                System.out.println("(duplicates removed)");
                
                f.cert_removeStopwords();
                String[] cert_listToArray = f.getCert_listToArray();
                r.removeDuplicates(cert_listToArray);
                
                String[] cert_keywords = r.getArrWithoutDuplicates();
                for(String i : cert_keywords)
                    System.out.println(i); //display certification topics
                
                System.out.println("\n\n");
                
                f.course_removeStopwords();
                String[] course_listToArray = f.getCourse_listToArray();
                r.removeDuplicates(course_listToArray);
                
                String[] course_keywords = r.getArrWithoutDuplicates();
                for(String i : course_keywords)
                    System.out.println(i); //display course topics
                
                //test with word_net
                System.out.println("\n\n Semantic Similarity \n");
                SemanticSimilarity ss = new SemanticSimilarity();
                //ss.compute(cert_keywords, course_keywords); //checking for number of words bcuz cert < course
                ss.compute(course_keywords, cert_keywords);
                
                
                
                
                //*********************************** IGNORE
                /*f.cert_removeStopwords();
                String[] cert_listToArray = f.getCert_listToArray();
                r.removeDuplicates(cert_listToArray);
                    
               /*for(int i=1; i<courseT.length; i++){
                    stopwords.setString(courseT[i]);
                    stopwords.StringToArray();
                } 
                
                for(int i=1; i<certificationT.length; i++){
                    stopwords.setString(certificationT[i]);
                    stopwords.StringToArray();
                } 
                
                ArrayList<String> topicsList = stopwords.getList(); //create an ArrayList to remove elements 

                //String[] arr = new String[arraySample.size()]; //then .toArray() to convert back to array
               // arr = arraySample.toArray(arr);// stopwords class

                for(String s : topicsList)
                        System.out.println(s + " ");

                //System.out.println("\n Remove duplicates: "); //remove duplicates by using LinkedHashSet
                   
                //LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>( Arrays.asList(arr)); 
               // String[] arrWithoutDuplicates = linkedHashSet.toArray(new String[] {});
               // System.out.println(Arrays.toString(arrWithoutDuplicates));
                
               /* System.out.println("\n\n Display String[] listToArray");
                String[] p2 = f.getCourse_listToArray();
                
                for(String i : p2)
                        System.out.println(i);
                
                System.out.println("\n Remove duplicates: ");
                
                String[] p3 = f.getListToArray();
                r.removeDuplicates(p3);*/
                //*********************************** IGNORE
                
            }
            else{
                System.out.println("Invalid.");
            }
        } catch (IOException e){
            System.out.println(e);
        } 
    }
    
}
