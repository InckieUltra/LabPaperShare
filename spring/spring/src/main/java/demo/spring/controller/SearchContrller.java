package demo.spring.controller;
import demo.spring.entity.Searchfind;
import demo.spring.entity.SendPaper;
import demo.spring.entity.parper;
import demo.spring.service.MySearchServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchContrller {
    @Autowired
    private MySearchServiceImp mySearchServiceImp;
    @CrossOrigin

    @PostMapping("/api/search")
    public List<SendPaper> Findpaper_id(@RequestBody Searchfind searchfind) {
        System.out.println(searchfind.getValue1());
        List<SendPaper> paperList = new ArrayList<SendPaper>();
        if(searchfind.getValue1().equals("版号"))
        {
            try {
                int paper_id_change = Integer.parseInt(searchfind.getPaper_id1());
                for(int i=0;i<this.mySearchServiceImp.Findpaper1(paper_id_change).size();i++){
                    int key = 0;
                    for(int j=0;j<paperList.size();j++){
                        if(this.mySearchServiceImp.Findpaper1(paper_id_change).get(i).getPaper_id() == paperList.get(j).getPaper_id()){
                            System.out.println("123456");
                            paperList.get(j).setRole_name(paperList.get(j).getRole_name()+','+this.mySearchServiceImp.Findpaper1(paper_id_change).get(i).getRole_name());
                            key = 1;
                        }
                    }
                    if(key ==1){
                        continue;
                    }
                    SendPaper sendPaper = new SendPaper();
                    sendPaper.setConference(this.mySearchServiceImp.Findpaper1(paper_id_change).get(i).getConference());
                    sendPaper.setField(this.mySearchServiceImp.Findpaper1(paper_id_change).get(i).getField());
                    sendPaper.setPaper_id(this.mySearchServiceImp.Findpaper1(paper_id_change).get(i).getPaper_id());
                    sendPaper.setRole_name(this.mySearchServiceImp.Findpaper1(paper_id_change).get(i).getRole_name());
                    sendPaper.setSummary(this.mySearchServiceImp.Findpaper1(paper_id_change).get(i).getSummary());
                    sendPaper.setTitle(this.mySearchServiceImp.Findpaper1(paper_id_change).get(i).getTitle());
                    sendPaper.setType(this.mySearchServiceImp.Findpaper1(paper_id_change).get(i).getType());
                    paperList.add(sendPaper);
                }
                return paperList;}
                catch (Exception exception){
                return null;
            }
        }
        else if(searchfind.getValue1().equals("2")){
            for(int i=0;i<this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).size();i++){
                int key = 0;
                for(int j=0;j<paperList.size();j++){
                    if(this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).get(i).getPaper_id() == paperList.get(j).getPaper_id()) {
                        paperList.get(j).setRole_name(paperList.get(j).getRole_name() + ',' + this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).get(i).getRole_name());
                        key=1;
                    }
                }
                if(key == 1)
                    continue;
                SendPaper sendPaper = new SendPaper();
                sendPaper.setConference(this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).get(i).getConference());
                sendPaper.setField(this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).get(i).getField());
                sendPaper.setPaper_id(this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).get(i).getPaper_id());
                sendPaper.setRole_name(this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).get(i).getRole_name());
                sendPaper.setSummary(this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).get(i).getSummary());
                sendPaper.setTitle(this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).get(i).getTitle());
                sendPaper.setType(this.mySearchServiceImp.Findpaper2(searchfind.getPaper_id1()).get(i).getType());
                paperList.add(sendPaper);
            }
            return paperList;
        }
        else if(searchfind.getValue1().equals("3"))
        {
            for(int i=0;i<this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).size();i++){
                int key =0;
                for(int j=0;j<paperList.size();j++){
                    if(this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).get(i).getPaper_id() == paperList.get(j).getPaper_id()){
                        paperList.get(j).setRole_name(paperList.get(j).getRole_name()+','+this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).get(i).getRole_name());
                        key = 1;
                    }
                }
                if(key == 1)
                    continue;
                SendPaper sendPaper = new SendPaper();
                sendPaper.setConference(this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).get(i).getConference());
                sendPaper.setField(this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).get(i).getField());
                sendPaper.setPaper_id(this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).get(i).getPaper_id());
                sendPaper.setRole_name(this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).get(i).getRole_name());
                sendPaper.setSummary(this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).get(i).getSummary());
                sendPaper.setTitle(this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).get(i).getTitle());
                sendPaper.setType(this.mySearchServiceImp.Findpaper3(searchfind.getPaper_id1()).get(i).getType());
                paperList.add(sendPaper);
            }
            return paperList;
        }
        else if(searchfind.getValue1().equals("4"))
        {
            for(int i=0;i<this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).size();i++){
                int key = 0;
                for(int j=0;j<paperList.size();j++){
                    if(this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).get(i).getPaper_id() == paperList.get(j).getPaper_id()){
                        paperList.get(j).setRole_name(paperList.get(j).getRole_name()+','+this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).get(i).getRole_name());
                        key = 1;
                    }
                }
                if(key == 1)
                    continue;
                SendPaper sendPaper = new SendPaper();
                sendPaper.setConference(this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).get(i).getConference());
                sendPaper.setField(this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).get(i).getField());
                sendPaper.setPaper_id(this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).get(i).getPaper_id());
                sendPaper.setRole_name(this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).get(i).getRole_name());
                sendPaper.setSummary(this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).get(i).getSummary());
                sendPaper.setTitle(this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).get(i).getTitle());
                sendPaper.setType(this.mySearchServiceImp.Findpaper4(searchfind.getPaper_id1()).get(i).getType());
                paperList.add(sendPaper);
            }
            return paperList;
        }
        else if(searchfind.getValue1().equals("5"))
        {
            for(int i=0;i<this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).size();i++){
                int key = 0;
                for(int j=0;j<paperList.size();j++){
                    if(this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).get(i).getPaper_id() == paperList.get(j).getPaper_id()){
                        paperList.get(j).setRole_name(paperList.get(j).getRole_name()+','+this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).get(i).getRole_name());
                        key = 1;
                    }
                }
                if(key == 1)
                    continue;
                SendPaper sendPaper = new SendPaper();
                sendPaper.setConference(this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).get(i).getConference());
                sendPaper.setField(this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).get(i).getField());
                sendPaper.setPaper_id(this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).get(i).getPaper_id());
                sendPaper.setRole_name(this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).get(i).getRole_name());
                sendPaper.setSummary(this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).get(i).getSummary());
                sendPaper.setTitle(this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).get(i).getTitle());
                sendPaper.setType(this.mySearchServiceImp.Findpaper5(searchfind.getPaper_id1()).get(i).getType());
                paperList.add(sendPaper);
            }
            return paperList;
        }
        return null;
    }
}
