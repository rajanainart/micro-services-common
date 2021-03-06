package com.rajanainart.data.provider;

import com.rajanainart.data.Database;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("org.hibernate.dialect.PostgreSQLDialect")
public class PostgreSqlDbProvider implements DbSpecificProvider {
    public String getParameterRegex() {
        return "[\\?][a-zA-Z0-9\\_]*";
    }

    public String getParameterKey() {
        return "\\?";
    }

    public String getParameterizedQuery(String query) {
        Pattern pattern = Pattern.compile(getParameterRegex());
        Matcher matcher = pattern.matcher(query);
        String  updated = query;
        while (matcher.find())
            updated = matcher.replaceAll(getParameterKey());
        return updated;
    }

    public List<String> getQueryParameters(String query) {
        List<String> params = new ArrayList<>();
        Pattern pattern = Pattern.compile(getParameterRegex());
        Matcher matcher = pattern.matcher(query);
        while (matcher.find())
            params.add(matcher.group().replaceFirst(getParameterKey(), ""));
        return params;
    }

    public String selectCurrentSequenceString(String sequenceName) {
        return String.format("SELECT CURRVAL('%s')", sequenceName);
    }

    public List<Map<String, Object>> selectDbSpecificMapList(Database db, String query, Database.Parameter ... parameters) {
        return null;
    }
}
