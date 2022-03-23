/*  03/12/22: Try source code with multidimensional array :D, works! But I need to display the words :')
    03/17/22: testing with prototype
source: https://stackoverflow.com/questions/36300485/how-to-resolve-the-difference-between-the-values-attained-in-the-web-api-and-the
 */
package mquap01;
import edu.cmu.lti.lexical_db.ILexicalDatabase;
import edu.cmu.lti.lexical_db.NictWordNet;
import edu.cmu.lti.ws4j.RelatednessCalculator;
import edu.cmu.lti.ws4j.impl.HirstStOnge;
import edu.cmu.lti.ws4j.impl.JiangConrath;
import edu.cmu.lti.ws4j.impl.LeacockChodorow;
import edu.cmu.lti.ws4j.impl.Lesk;
import edu.cmu.lti.ws4j.impl.Lin;
import edu.cmu.lti.ws4j.impl.Path;
import edu.cmu.lti.ws4j.impl.Resnik;
import edu.cmu.lti.ws4j.impl.WuPalmer;
import java.io.PrintStream;

/**
 *
 * @author Janelle Achondo, Caryl Shainet Parro
 */
public class SemanticSimilarity {
    
    private static ILexicalDatabase db = new NictWordNet();
    
    public double[][] getSimilarityMatrix(String[] words1, String[] words2, RelatednessCalculator rc ){
    
        double[][] result = new double[words1.length][words2.length];
        
        for (int i=0; i<words1.length; i++ ){
            for ( int j=0; j<words2.length; j++ ) {
                double score = rc.calcRelatednessOfWords(words1[i], words2[j]);
                result[i][j] = score;
             }
         }
         return result;
    }
    
    public void compute (String[] words1, String[] words2){
        
        RelatednessCalculator rc1 = new WuPalmer(db);
        double[][] s1 = getSimilarityMatrix(words1, words2, rc1);
      
        for (int i = 0; i <= words1.length; i++) {
        
            for (int j = 0; j <= words2.length; j++) {
                if(i==0 && j==0) {
                    System.out.print(" " + "\t"); 
                } else if(i==0) {
                    System.out.printf("%30s", words2[j-1]);
                } else if(j==0) {
                    System.out.printf("%-20s", words1[i-1]);
                } else {
                    System.out.printf("%-30s", s1[i-1][j-1]);
                }
            }
            
            System.out.println();
        }
    } //end of compute()
}
