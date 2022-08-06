package com.example.demo.data;

public class data implements Comparable<data>{
    public String shortUrl = "";
    public String longUrl = "";
    public int codeUsed = 0;
    public int urlUsed = 0;
    public data(){

    }
   public data(String shortUrl,String longUrl,int codeUsed,int urlUsed){
    super();

    this.urlUsed = urlUsed;
    this.codeUsed = codeUsed;
    this.longUrl = longUrl;
    this.shortUrl = shortUrl;
   }

   public int compareTo(data o){
        if(o.urlUsed>this.urlUsed){
            return 1;
        }

        return -1;
   }
}
