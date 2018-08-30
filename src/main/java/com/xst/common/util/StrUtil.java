package com.xst.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author honey
 * @version 创建时间：2016-1-10 下午01:10:54
 * @E-mail honey123987@126.com
 */

public class StrUtil extends StringUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(StrUtil.class);

    public static double getDouble(Object obj) {
        if (null != obj) {
            String oo = obj.toString();
            try {
                return Double.valueOf(oo);
            } catch (Exception e) {
                return 0;
            }
        } else {
            return 0;
        }

    }

    public static double getDouble(Map<String, Object> map, String key) {

        if (map == null || map.isEmpty()) {
            return 0;
        } else {
            String k = getString(map, key);
            return getDouble(k);
        }
    }

    public static int getInteger(Object obj) {
        if (null != obj) {
            String oo = obj.toString();
            try {
                return Integer.valueOf(oo);
            } catch (Exception e) {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public static int getInteger(Map<String, Object> map, String key) {

        if (map == null || map.isEmpty()) {
            return -1;
        } else {
            String k = getString(map, key);
            return getInteger(k, -1);
        }
    }

    public static int getInteger01(Map<String, String> map, String key) {

        if (map == null || map.isEmpty()) {
            return -1;
        } else {
            Map<String, Object> mapt = new HashMap<>();
            mapt.putAll(map);
            String k = getString(mapt, key);
            return getInteger(k, -1);
        }
    }

    public static int getInteger(Object obj, int def) {

        if (null != obj) {
            String oo = obj.toString().trim();
            try {
                return Integer.valueOf(oo);
            } catch (Exception e) {
                return def;
            }
        } else {
            return def;
        }
    }

    public static boolean isNotEmpty(Object obj) {
        if (obj == null) {
            return false;
        } else if (obj.toString().trim().length() < 1) {
            return false;
        } else {
            return true;
        }
    }

    public static String getString(Object obj) {
        if (obj == null) {
            return "";
        } else if (obj.toString().trim().length() < 1) {
            return "";
        } else {
            return obj.toString().trim();
        }
    }


    public static String getString(Map<String, Object> map, String key) {
        return getString(map, key, "");
    }

    public static String getString(Map<String, Object> map, String key, String def) {
        if (def == null) {
            def = "";
        }
        if (map == null) {
            return def;
        } else {
            if (map.containsKey(key)) {
                return getString(map.get(key));
            } else {
                return def;
            }
        }
    }

    public static String getString01(Map<String, String> map, String key) {
        if (map == null) {
            return null;
        } else {
            if (map.containsKey(key)) {
                return getString(map.get(key));
            } else {
                return null;
            }
        }
    }


    public static List<Integer> getListIds(String ids) {
        List<Integer> list = new ArrayList<Integer>();
        if (ids != null) {
            String[] k = ids.split(",");
            for (int i = 0; i < k.length; i++) {
                list.add(getInteger(k[i]));
            }
            return list;
        } else {
            return null;
        }

    }

    public static String getIds(List<Integer> list) {
        StringBuffer sb = new StringBuffer();
        for (Integer integer : list) {
            sb.append(",'");
            sb.append(integer);
            sb.append("'");
        }
        if (sb.length() > 0) {
            return sb.substring(1);
        } else {
            return "";
        }

    }

    public static long getLong(Object obj) {

        try {
            return Long.valueOf(obj + "");
        } catch (Exception e) {
            return -1l;
        }

    }

    public static boolean isNotEmpty(Map<String, Object> map, String string) {
        if (map == null) {
            return false;
        } else {
            if (map.containsKey(string) && map.get(string).toString().trim().length() > 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
