package com.example.demo.service;

import com.example.demo.data.data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

@Service
public class service {
    ArrayList<data> ls;

    service() {

        ls = new ArrayList<>();
    }
// generate code contains alphanumeric string
    public String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789" + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
//check list if it contains url then it adds in ans and return
    public ArrayList<data> getcode(String url) {
        ArrayList<data> ans = new ArrayList<>();

        for (data v : ls) {
            if (v.longUrl.equals(url)) {
                //increments url used counts
                v.urlUsed++;
                ans.add(v);
                break;
            }
        }

        if (ans.size() > 0) {
            return ans;
        }
        //if data is not present in list then it created the code for it ans appended it in ls and ans
        String code = getAlphaNumericString(10);
        data d = new data(code, url, 0, 1);
        ls.add(d);
        ans.add(d);
        return ans;

    }
// check ls if any url has already used this code if "yes" it return url data in ans else return empty array
    public ArrayList<data> geturl(String code) {

        ArrayList<data> ans = new ArrayList<>();
        for (data v : ls) {
            if (v.shortUrl.equals(code)) {
                //increments the code used count
                v.codeUsed++;
                ans.add(v);
                break;
            }
        }

        // returns ans array
        return ans;
    }

    //this function is for analytics functionality where it sorts the list w.r.t mostly used url
    public ArrayList<data> getAnalytics() {
        Collections.sort(ls);
        return ls;
    }
}
