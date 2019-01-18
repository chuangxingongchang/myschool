package com.school.service;

import com.school.entity.TSchool;

public interface SchoolService {
    int selectBySchoolname(String schoolname);
    String selectByFkSchoolId(int fkSchoolId);
    boolean insertSchool(TSchool school);
    boolean checkThisSchool(TSchool school);

}
