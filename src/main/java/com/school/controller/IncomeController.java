package com.school.controller;

import com.school.entity.TIncome;
import com.school.service.IncomeService;
import com.school.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@RestController
@RequestMapping("/income")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;
    private Message ms = new Message();
    private ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());

    /**
     * @param fkUid
     * @return
     * 描述:根据用户id获取当前用户的收入明细
     */
    @RequestMapping("/myincome")
    public ModelAndView getMyAllincome(int fkUid){
        List<TIncome> incomeList = incomeService.selectAllIncome(fkUid);
        if(incomeList.size()>0){
            ms.setStatus(true);
        }else {
            ms.setStatus(false);
        }
        mav.addObject("inm",ms);
        mav.addObject("inmlist",incomeList);
        return mav;
    }
}
