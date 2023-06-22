package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Response {
    String TotalNews;
    List<Articles> articles;
}
