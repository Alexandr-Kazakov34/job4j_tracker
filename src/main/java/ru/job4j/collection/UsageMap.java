package ru.job4j.collection;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Rem@.mail", "Kazakov A.S");
        map.put("Rem@.mail", "Sidorov V.V");
        map.put("Ikon@.ail", "Kazakov A.S");
        map.put("Non@maill", "Petrov A.S");
        map.put("Non@maill", "Logvin A.S");

        for (String s : map.keySet()) {
            String readLine = map.get(s);
            System.out.println(readLine);
        }

        for (Map.Entry<String, String> m : map.entrySet()) {
            System.out.println(m);
        }
    }
}
