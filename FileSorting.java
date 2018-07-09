/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesorting;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
/**
 *
 * @author sridhar
 */

class fileNames implements Comparable<fileNames>
{
    
    /*The class that defines the characteristics of filenames*/
    
    String name;
    int number;
    String strChars;
    boolean underScore;
    boolean numberbool;
    boolean charbool;
    
    public fileNames(String name, String filenumber, String strChars, boolean underScore)
    {
        this.name = name;        
        this.underScore = underScore;
        if(filenumber != null && !filenumber.isEmpty())
        {
            this.numberbool=true;
            this.number = Integer.parseInt(filenumber);
        }
        else
        {
            this.numberbool = false;
        }
        
        
        if(strChars != null && !strChars.isEmpty())
        {
            this.charbool=true;
            this.strChars = strChars;
        }
        else
        {
            this.charbool = false;
        }
        
    }
    
    @Override
    public int compareTo(fileNames o) {
        
        try
        {
            if(this.numberbool && !o.numberbool)
            {
                return -1;
            }
            else if(!this.numberbool && o.numberbool)
            {
                return 1;                
            }
            else
            {
                if(this.underScore && !o.underScore)
                {
                    return 1;
                }
                else if(!this.underScore && o.underScore)
                {
                    //System.out.println("returnign   -1");
                    return -1;
                }
                else
                {
                    if(this.charbool && !o.charbool)
                    {
                        return 1;                        
                    }
                    else if (!this.charbool && o.charbool)
                    {
                        return -1;                        
                    }
                    else
                    {
                        //System.out.println(this.number +" "+o.number);
                        //System.out.println(this.strChars +" "+o.strChars);
                        if(this.number < o.number)
                        {
                            return -1;
                        }
                        else
                        {
                            if(this.strChars.compareTo(o.strChars) == 0)
                            {
                                return 0;
                            }
                            else if(this.strChars.compareTo(o.strChars) < 0)
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
            }           
        }catch(Exception e){}    return -1;}
}




class FilePull
{
    
    
    private ArrayList<String> fileList = new ArrayList<String>();
    
    public ArrayList<fileNames> list= new ArrayList<fileNames>();
    public FilePull(String path)
    {
        
        /*The filenames are parsed and separate objects are created
        to store characters of filename, numbers. Also boolean variables
        to see if there are numbers/characters/underscore in the given filename*/
        File f = new File(path);
        File[] filePointers = f.listFiles();
        for(int i = 0;i<filePointers.length;i++)
        {
            fileList.add(filePointers[i].getName());
            String fileN = filePointers[i].getName();
            
            ArrayList<Integer> fileNo = new ArrayList<>();
            ArrayList<Character> fileChars = new ArrayList<>();
            boolean flag = false;
            for(int j=0;j<fileN.length();j++)
            {
                if((int)fileN.charAt(j) >= 48 && (int)fileN.charAt(j) <= 57)
                {
                    fileNo.add(Integer.parseInt(String.valueOf(fileN.charAt(j))));
                }
                else if((int)fileN.charAt(j) == 95)
                {
                    flag =true;                    
                }
                else
                {
                    fileChars.add(fileN.charAt(j));
                }               
            }
            String fileNumbers = new String();            
            for(int j =0;j<fileNo.size();j++)
            {
                fileNumbers += fileNo.get(j);
            }         
            String fileCharnames = new String();
            for(int j =0;j<fileChars.size();j++)
            {
                fileCharnames += Character.toString(fileChars.get(j));
            }
            fileNames filepointer = new fileNames(fileN, fileNumbers, fileCharnames, flag);
            list.add(filepointer);           
        }        
    }
    
    public void displayFiles()
    {
        for(int i =0;i<list.size();i++)
        {
            System.out.println(list.get(i).name);
        }        
    }
}


public class FileSorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Enter the path:");
        Scanner input = new Scanner(System.in);
        String filepath = input.next();
        //String filepath = "/home/sridhar/test_folder";
        FilePull fP = new FilePull(filepath);
        //fP.displayFiles();
        Collections.sort(fP.list);
        fP.displayFiles();        
    }    
}