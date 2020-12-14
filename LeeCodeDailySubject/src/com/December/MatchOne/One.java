package com.December.MatchOne;

import java.util.HashMap;
import java.util.Map;

public class One {
    Map<String, String> map = new HashMap<>();
    public One() {
        map.put("G", "g");
        map.put("()", "o");
        map.put("(al)", "al");
    }
    public String interpret(String command) {
        int index = 0;
        StringBuilder res = new StringBuilder();
        while (index < command.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(command.charAt(index));
            while (!map.containsKey(sb.toString())) {
                index++;
                sb.append((command.charAt(index)));
            }
            res.append(map.get(sb.toString()));
        }
        return res.toString();

    }
}
