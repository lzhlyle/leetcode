package com.lzhlyle.leetcode.self.no468;

public class ValidateIpAddress {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            int cnt = 0;
            for (char c : IP.toCharArray())
                if (c == '.') cnt++;
            if (cnt == 3 && validIPv4(IP.split("\\.")))
                return "IPv4";
        } else if (IP.contains(":")) {
            int cnt = 0;
            for (char c : IP.toCharArray())
                if (c == ':') cnt++;
            if (cnt == 7 && validIPv6(IP.split(":")))
                return "IPv6";
        }
        return "Neither";
    }

    private boolean validIPv4(String[] arr) {
        if (arr.length != 4) return false;
        for (String str : arr) {
            if (str.isEmpty() || str.length() > 3) return false;
            if (str.length() > 1 && str.charAt(0) == '0') return false;
            for (char c : str.toCharArray())
                if (!Character.isDigit(c))
                    return false;
            int v = Integer.valueOf(str);
            if (v > 255) return false;
        }
        return true;
    }

    private boolean validIPv6(String[] arr) {
        if (arr.length != 8) return false;
        for (String str : arr) {
            if (str.isEmpty() || str.length() > 4) return false;
            str = str.toLowerCase();
            for (char c : str.toCharArray())
                if (!Character.isDigit(c) && !validIPv6EngChar(c))
                    return false;
        }
        return true;
    }

    private boolean validIPv6EngChar(char c) {
        return c >= 'a' && c <= 'f';
    }
}
