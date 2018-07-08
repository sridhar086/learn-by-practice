/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazoninterview;

/**
 *
 * @author sridhar
 */

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

class logs 
{

String id;
String str;
boolean num;
String total;
public logs(String id,String str,boolean num,String total)
{
    this.id = id;
    this.str=str;
    this.num = num;
    this.total = total;
    
}

}


class comparison implements Comparator<logs>
{

    @Override
    public int compare(logs o1, logs o2) {
        
        //System.out.println("comparing "+o1.total+" "+o2.total);
    
    if(o1.num && o2.num)
    {
        if(o1.str.compareTo(o2.str) == 0)
        {
            if(o1.id.compareTo(o2.id)<0)
            {
                return -1;
            }
            else if (o1.id.compareTo(o2.id) == 0)
            {
                return 0;
            }
            else
            {
            return 1;
            }

        }
        else if(o1.str.compareTo(o2.str) < 0)
        {
            //System.out.println("comparison of numbers o1 less than o2");
            return 1;
        }
        else
        {
            //System.out.println("comparison of numbers o1 greater than o2");
            return -1;
        }

    }
    else if(o1.num && !o2.num)
    {
        //System.out.println("number in first one and no number second one");
        return 1;

    }
    else if(!o1.num && o2.num)
    {
        //System.out.println("no number in first one and number second one o1 is bigger than o2");        
        return -1;
    }
    else
    {
        if(o1.str.compareTo(o2.str) == 0)
        {
            if(o1.id.compareTo(o2.id)<0)
            {
                return -1;
            }
            else if(o1.id.compareTo(o2.id) == 0)
            {
                return 0;
            }
            else
            {
                return 1;
            }

        }
        else if(o1.str.compareTo(o2.str) < 0)
        {
            return -1;
        }
        else
        {
        return 1;
        }

    }
        
        
    }
    
}

public class AmazonInterview
{ 
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> reorderLines(int logFileSize, List<String> logfile) 
	{
	    List<logs> loglist = new ArrayList<>();
	    
	    for(int i =0;i<logfile.size();i++)
	    {
	        
	        String id1 = logfile.get(i).split(" ",2)[0];
	        String str1 = logfile.get(i).split(" ",2)[1];
	        
	        //String id2 = logfile.get(i+1).split(" ",2)[0];
	        //String str2 = logfile.get(i+1).split(" ",2)[1];
	        boolean num1 = Pattern.compile("[0-9]").matcher(str1).find();
	        //boolean num2 = Pattern.compile("[0-9]").matcher(str2).find();
	        logs l = new logs(id1,str1,num1,logfile.get(i));
	        loglist.add(l);
	        
	    }
	    //Collections.sort(loglist, new comparison());
            loglist.sort(new comparison());
	    
	    List<String> ret = new ArrayList<>();
	    for(int i=0;i<logfile.size();i++)
	    {
                //System.out.println(loglist.get(i).total);
	        ret.add(loglist.get(i).total);
	    }
	    return ret;
	
	}
    
    public static void main(String[] args) {
        // TODO code application logic here
       List<String> an = new ArrayList<>();
       an.add("a1 9 2 3 1");
       an.add("g1 Act car");
       an.add("zo4 4 7");
       an.add("ab1 off KEY dog");
       an.add("a8 act zoo");
       
       AmazonInterview s = new AmazonInterview();
       List<String> ret = s.reorderLines(an.size(),an);
       
       for(int i =0;i<ret.size();i++)
       {
           System.out.println(ret.get(i));
       }
    } 
    // METHOD SIGNATURE ENDS
}
