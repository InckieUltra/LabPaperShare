package demo.spring.service;

import demo.spring.entity.parper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MySearchService {

    public List<parper> Findpaper1(int paper_id);
    public List<parper> Findpaper2(String title);
    public List<parper> Findpaper3(String name);
    public List<parper> Findpaper4(String summary);
    public List<parper> Findpaper5(String type);
}
