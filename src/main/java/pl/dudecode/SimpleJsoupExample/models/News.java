package pl.dudecode.SimpleJsoupExample.models;

import lombok.Data;

@Data
public class News {
    private String title;
    private String content;
    private String imgURL;
    private String moreURL;
}
