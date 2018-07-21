/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoping;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author RICARDO
 */
public class Atack implements Runnable{

    public Atack(String dns, long counter, long how_big) 
    {
        this.dns = dns;
        this.counter = counter;
        this.how_big = how_big;
    }
    
    @Override
    public void run() 
    {
        try 
        {
            startAtack();
        }
        catch (IOException e)
        {
            System.out.println("gone wrong kido ( -_-)");
            e.printStackTrace();
        }
    }
    
    private void startAtack() throws IOException
    {
        Process cmd_comand = Runtime.getRuntime().exec(this.getCommand());
        InputStream inputstream = cmd_comand.getInputStream();
        BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
        this.generalOutput = bufferedinputstream;
    }

    private String getCommand()
    {
        return "ping "+dns+" -n "+counter+((how_big == -1)? " -t ":" -l "+how_big);
    }
    
    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public long getHow_big() {
        return how_big;
    }

    public void setHow_big(long how_big) {
        this.how_big = how_big;
    }

    public BufferedInputStream getGeneralOutput() {
        return generalOutput;
    }

    public void setGeneralOutput(BufferedInputStream generalOutput) {
        this.generalOutput = generalOutput;
    }
    
    
    
    private String  dns;
    private long    counter,
                    how_big;
    
    BufferedInputStream generalOutput;
    
}
