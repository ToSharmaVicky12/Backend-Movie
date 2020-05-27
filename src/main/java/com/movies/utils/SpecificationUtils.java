package com.movies.utils;


import org.apache.commons.lang3.StringUtils;

public class SpecificationUtils {

    private SpecificationUtils() {
    }


    public static String wrapWithWildcards(String name) {
        return "%" + name + "%";
    }

    public static String fixForEnum(String name) {
        return StringUtils.defaultString(name).replaceAll(" ", "_");
    }


}
