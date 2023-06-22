package com.example.demo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Articles {
    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String publishedAt;
}
