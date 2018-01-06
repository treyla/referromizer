package com.treyla.referromizer.domain;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    private UUID id;
    private String name;
    private String url;
    private String refIdRegex;
    private String refUrlRegex;

    Provider() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Matcher getRefIdMatcher(String refId) {
        Pattern pattern = Pattern.compile(refIdRegex);
        return pattern.matcher(refId);
    }

    public Matcher getRefUrlMatcher(String refUrl) {
        Pattern pattern = Pattern.compile(refUrlRegex);
        return pattern.matcher(refUrl);
    }

    public boolean isRefIdValid(String refId) {
        return getRefIdMatcher(refId).matches();
    }

    public boolean isRefUrlValid(String refUrl) {
        return getRefUrlMatcher(refUrl).matches();
    }

}