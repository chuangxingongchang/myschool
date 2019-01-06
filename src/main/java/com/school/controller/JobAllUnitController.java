package com.school.controller;

import com.school.entity.TSettle;
import com.school.entity.TTime;
import com.school.entity.TUnit;
import com.school.entity.TWorktype;
import com.school.service.JobAllUnitService;
import com.school.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;

@RestController
@RequestMapping("/unitAllType")
public class JobAllUnitController {
    @Autowired
    private JobAllUnitService allTypeService;
    private ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
    private Message ms = new Message();

    /**
     * @return 描述：查询t_worktype表获取所有工作类型
     */
    @RequestMapping("/getAllWorkType")
    public ModelAndView getWorkType() {
        List<TWorktype> worktypeList = allTypeService.selectAllWorkType();
        try {
            if (worktypeList.size() > 0) {
                ms.setStatus(true);
            } else {
                ms.setStatus(false);
            }
        } catch (Exception e) {
            ms.setStatus(false);
        } finally {
            mav.addObject("ms", ms);
            mav.addObject("workType", worktypeList);
            return mav;
        }
    }
    @RequestMapping("/getAllTimeType")
    public ModelAndView getTimeType() {
        List<TTime> timetypeList = allTypeService.selectAllTime();
        try {
            if (timetypeList.size() > 0) {
                ms.setStatus(true);
            } else {
                ms.setStatus(false);
            }
        } catch (Exception e) {
            ms.setStatus(false);
        } finally {
            mav.addObject("ms", ms);
            mav.addObject("timetype", timetypeList);
            return mav;
        }
    }
    @RequestMapping("/getunitType")
    public ModelAndView getunitType() {
        List<TUnit> unitList = allTypeService.selectAllUnit();
        try {
            if (unitList.size() > 0) {
                ms.setStatus(true);
            } else {
                ms.setStatus(false);
            }
        } catch (Exception e) {
            ms.setStatus(false);
        } finally {
            mav.addObject("ms", ms);
            mav.addObject("unitType", unitList);
            return mav;
        }
    }
    @RequestMapping("/getsettleType")
    public ModelAndView getsettleType() {
        List<TSettle> settleList = allTypeService.selectAllSettle();
        try {
            if (settleList.size() > 0) {
                ms.setStatus(true);
            } else {
                ms.setStatus(false);
            }
        } catch (Exception e) {
            ms.setStatus(false);
        } finally {
            mav.addObject("ms", ms);
            mav.addObject("settleType", settleList);
            return mav;
        }
    }
}
