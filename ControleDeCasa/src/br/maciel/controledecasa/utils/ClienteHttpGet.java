package br.maciel.controledecasa.utils;

import java.net.URI;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClienteHttpGet implements Runnable{

    private String url="";
    
    /*
     * Proprio contrutor ja requisita a url e inicia a Thread;
     */
    public ClienteHttpGet(String urlParam) {
        super();
        url=urlParam;
        //System.out.println("url="+url);
        Thread t = new Thread(this);
        t.start();
    }
    
    public void fim() {
     
    }
    
	@Override
	public void run() {
        HttpClient cliente = new DefaultHttpClient();
        HttpGet requiscao = new HttpGet();
        try {
            requiscao.setURI(new URI(url));
            cliente.execute(requiscao);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
