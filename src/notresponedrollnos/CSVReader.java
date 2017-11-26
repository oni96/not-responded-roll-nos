/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notresponedrollnos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Primus
 */
class CSVReader {
    File file;
    String rows[];
    public CSVReader(File file) {
        this.file = file;
    }
    
    public void readData(){
          
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            rows = br.readLine().split(",");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> calculate(int start,int stop,int row){
            FileInputStream fis = null;
            ArrayList<String> current = new ArrayList<>();
            ArrayList<String> remainingList = new ArrayList<>();
            int i = 0;
            
        try {
            fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            br.readLine();
            String line;
            while((line=br.readLine())!=null){
                String s[] = line.split(",");
                current.add(s[row]);
            }
            
            for(int j=start;j<=stop;j++){
                if(!current.contains(String.valueOf(j)))
                    remainingList.add(String.valueOf(j));
            }
            
            //System.out.println(remainingList);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(CSVReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return remainingList;
    }

    public String[] getRowlen() {
        return rows;
    }
    
}
