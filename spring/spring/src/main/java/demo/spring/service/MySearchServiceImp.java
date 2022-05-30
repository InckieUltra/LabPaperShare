package demo.spring.service;

import demo.spring.entity.parper;
import demo.spring.mapper.MySearpaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mySearchService")
public class MySearchServiceImp implements MySearchService{
    @Autowired
    private MySearpaper mySearpaper;
    @Override
    public List<parper> Findpaper1(int paper_id) { return this.mySearpaper.Findpaper1(paper_id); }

    @Override
    public List<parper> Findpaper2(String title) {
        return this.mySearpaper.Findpaper2(title);
    }

    @Override
    public List<parper> Findpaper3(String name) {
        return this.mySearpaper.Findpaper3(name);
    }

    @Override
    public List<parper> Findpaper4(String summary) {
        return this.mySearpaper.Findpaper4(summary);
    }

    @Override
    public List<parper> Findpaper5(String type) { return this.mySearpaper.Findpaper5(type); }
}
