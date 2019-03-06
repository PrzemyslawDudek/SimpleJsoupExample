package pl.dudecode.SimpleJsoupExample.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import pl.dudecode.SimpleJsoupExample.models.News;

import java.io.IOException;

@Service
public class JsoupNewsService {

    public News getFirstNewsFromTVN24() throws IOException {
        Document doc = Jsoup.connect("https://fakty.tvn24.pl/").get();
        Elements sections = doc.select(".main-six-elements");
        Element section = sections.first();
        Element article = section.select(".first").first();
        Element link = article.select("a").first();
        Element title = article.selectFirst("h1");
        Element img = article.selectFirst("img");

        News news = new News();
        news.setTitle(title.text());
        news.setImgURL(img.attr("data-original"));
        news.setMoreURL(link.attr("href"));
        return news;
    }

    public News getFirstNewsFromOnet() throws IOException {
        Document doc = Jsoup.connect("https://www.onet.pl/").get();
        Elements sections = doc.select(".sectionLineMax");
        Element section = sections.first();
        Element article = section.selectFirst("a");
        Element title = article.selectFirst(".title");
        Element img = article.selectFirst("img");

        News news = new News();
        news.setTitle(title.text());
        news.setImgURL(img.attr("src"));
        news.setMoreURL(article.attr("href"));

        return news;
    }

    public News getFirstNewsFromWP() throws IOException {

        Document doc = Jsoup.connect("https://www.wp.pl/").get();
        Elements sections = doc.select(".jIlknD");
        Element section = sections.first();
        Element article = section.selectFirst(".ibboXd");
        Element link = article.selectFirst("a");
        Element title = article.selectFirst(".gxKMbd");

        News news = new News();
        news.setTitle(title.text());
        news.setMoreURL(link.attr("href"));

        return news;
    }
}
