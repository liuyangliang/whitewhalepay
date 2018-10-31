package com.scut.whitewhalepay.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.scut.whitewhalepay.enity.BandCard;
import com.scut.whitewhalepay.service.BandCardService;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller
public class BandCardAction {
	@Autowired
	private BandCardService bandCardService;
	
	public String getAllBandCard(){
        List<BandCard> bandCardList = bandCardService.getAll();
        Map map = (Map) ActionContext.getContext().get("request");
        map.put("bandCardList", bandCardList);
        return SUCCESS;
    }
}
