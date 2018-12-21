package com.school.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPlurExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TPlurExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andFkUnitIsNull() {
            addCriterion("fk_unit is null");
            return (Criteria) this;
        }

        public Criteria andFkUnitIsNotNull() {
            addCriterion("fk_unit is not null");
            return (Criteria) this;
        }

        public Criteria andFkUnitEqualTo(Integer value) {
            addCriterion("fk_unit =", value, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andFkUnitNotEqualTo(Integer value) {
            addCriterion("fk_unit <>", value, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andFkUnitGreaterThan(Integer value) {
            addCriterion("fk_unit >", value, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andFkUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_unit >=", value, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andFkUnitLessThan(Integer value) {
            addCriterion("fk_unit <", value, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andFkUnitLessThanOrEqualTo(Integer value) {
            addCriterion("fk_unit <=", value, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andFkUnitIn(List<Integer> values) {
            addCriterion("fk_unit in", values, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andFkUnitNotIn(List<Integer> values) {
            addCriterion("fk_unit not in", values, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andFkUnitBetween(Integer value1, Integer value2) {
            addCriterion("fk_unit between", value1, value2, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andFkUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_unit not between", value1, value2, "fkUnit");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNull() {
            addCriterion("releaseTime is null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNotNull() {
            addCriterion("releaseTime is not null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeEqualTo(Date value) {
            addCriterionForJDBCDate("releaseTime =", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("releaseTime <>", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("releaseTime >", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("releaseTime >=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThan(Date value) {
            addCriterionForJDBCDate("releaseTime <", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("releaseTime <=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIn(List<Date> values) {
            addCriterionForJDBCDate("releaseTime in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("releaseTime not in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("releaseTime between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("releaseTime not between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andCountsIsNull() {
            addCriterion("counts is null");
            return (Criteria) this;
        }

        public Criteria andCountsIsNotNull() {
            addCriterion("counts is not null");
            return (Criteria) this;
        }

        public Criteria andCountsEqualTo(Integer value) {
            addCriterion("counts =", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotEqualTo(Integer value) {
            addCriterion("counts <>", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThan(Integer value) {
            addCriterion("counts >", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("counts >=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThan(Integer value) {
            addCriterion("counts <", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsLessThanOrEqualTo(Integer value) {
            addCriterion("counts <=", value, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsIn(List<Integer> values) {
            addCriterion("counts in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotIn(List<Integer> values) {
            addCriterion("counts not in", values, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsBetween(Integer value1, Integer value2) {
            addCriterion("counts between", value1, value2, "counts");
            return (Criteria) this;
        }

        public Criteria andCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("counts not between", value1, value2, "counts");
            return (Criteria) this;
        }

        public Criteria andPersonsIsNull() {
            addCriterion("persons is null");
            return (Criteria) this;
        }

        public Criteria andPersonsIsNotNull() {
            addCriterion("persons is not null");
            return (Criteria) this;
        }

        public Criteria andPersonsEqualTo(Integer value) {
            addCriterion("persons =", value, "persons");
            return (Criteria) this;
        }

        public Criteria andPersonsNotEqualTo(Integer value) {
            addCriterion("persons <>", value, "persons");
            return (Criteria) this;
        }

        public Criteria andPersonsGreaterThan(Integer value) {
            addCriterion("persons >", value, "persons");
            return (Criteria) this;
        }

        public Criteria andPersonsGreaterThanOrEqualTo(Integer value) {
            addCriterion("persons >=", value, "persons");
            return (Criteria) this;
        }

        public Criteria andPersonsLessThan(Integer value) {
            addCriterion("persons <", value, "persons");
            return (Criteria) this;
        }

        public Criteria andPersonsLessThanOrEqualTo(Integer value) {
            addCriterion("persons <=", value, "persons");
            return (Criteria) this;
        }

        public Criteria andPersonsIn(List<Integer> values) {
            addCriterion("persons in", values, "persons");
            return (Criteria) this;
        }

        public Criteria andPersonsNotIn(List<Integer> values) {
            addCriterion("persons not in", values, "persons");
            return (Criteria) this;
        }

        public Criteria andPersonsBetween(Integer value1, Integer value2) {
            addCriterion("persons between", value1, value2, "persons");
            return (Criteria) this;
        }

        public Criteria andPersonsNotBetween(Integer value1, Integer value2) {
            addCriterion("persons not between", value1, value2, "persons");
            return (Criteria) this;
        }

        public Criteria andSettlemethodIsNull() {
            addCriterion("settleMethod is null");
            return (Criteria) this;
        }

        public Criteria andSettlemethodIsNotNull() {
            addCriterion("settleMethod is not null");
            return (Criteria) this;
        }

        public Criteria andSettlemethodEqualTo(String value) {
            addCriterion("settleMethod =", value, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodNotEqualTo(String value) {
            addCriterion("settleMethod <>", value, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodGreaterThan(String value) {
            addCriterion("settleMethod >", value, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodGreaterThanOrEqualTo(String value) {
            addCriterion("settleMethod >=", value, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodLessThan(String value) {
            addCriterion("settleMethod <", value, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodLessThanOrEqualTo(String value) {
            addCriterion("settleMethod <=", value, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodLike(String value) {
            addCriterion("settleMethod like", value, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodNotLike(String value) {
            addCriterion("settleMethod not like", value, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodIn(List<String> values) {
            addCriterion("settleMethod in", values, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodNotIn(List<String> values) {
            addCriterion("settleMethod not in", values, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodBetween(String value1, String value2) {
            addCriterion("settleMethod between", value1, value2, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andSettlemethodNotBetween(String value1, String value2) {
            addCriterion("settleMethod not between", value1, value2, "settlemethod");
            return (Criteria) this;
        }

        public Criteria andWordtimeIsNull() {
            addCriterion("wordTime is null");
            return (Criteria) this;
        }

        public Criteria andWordtimeIsNotNull() {
            addCriterion("wordTime is not null");
            return (Criteria) this;
        }

        public Criteria andWordtimeEqualTo(String value) {
            addCriterion("wordTime =", value, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeNotEqualTo(String value) {
            addCriterion("wordTime <>", value, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeGreaterThan(String value) {
            addCriterion("wordTime >", value, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeGreaterThanOrEqualTo(String value) {
            addCriterion("wordTime >=", value, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeLessThan(String value) {
            addCriterion("wordTime <", value, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeLessThanOrEqualTo(String value) {
            addCriterion("wordTime <=", value, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeLike(String value) {
            addCriterion("wordTime like", value, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeNotLike(String value) {
            addCriterion("wordTime not like", value, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeIn(List<String> values) {
            addCriterion("wordTime in", values, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeNotIn(List<String> values) {
            addCriterion("wordTime not in", values, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeBetween(String value1, String value2) {
            addCriterion("wordTime between", value1, value2, "wordtime");
            return (Criteria) this;
        }

        public Criteria andWordtimeNotBetween(String value1, String value2) {
            addCriterion("wordTime not between", value1, value2, "wordtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("endTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("endTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("endTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("endTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("endTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("endTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andWorkcontentIsNull() {
            addCriterion("workContent is null");
            return (Criteria) this;
        }

        public Criteria andWorkcontentIsNotNull() {
            addCriterion("workContent is not null");
            return (Criteria) this;
        }

        public Criteria andWorkcontentEqualTo(String value) {
            addCriterion("workContent =", value, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentNotEqualTo(String value) {
            addCriterion("workContent <>", value, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentGreaterThan(String value) {
            addCriterion("workContent >", value, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentGreaterThanOrEqualTo(String value) {
            addCriterion("workContent >=", value, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentLessThan(String value) {
            addCriterion("workContent <", value, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentLessThanOrEqualTo(String value) {
            addCriterion("workContent <=", value, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentLike(String value) {
            addCriterion("workContent like", value, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentNotLike(String value) {
            addCriterion("workContent not like", value, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentIn(List<String> values) {
            addCriterion("workContent in", values, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentNotIn(List<String> values) {
            addCriterion("workContent not in", values, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentBetween(String value1, String value2) {
            addCriterion("workContent between", value1, value2, "workcontent");
            return (Criteria) this;
        }

        public Criteria andWorkcontentNotBetween(String value1, String value2) {
            addCriterion("workContent not between", value1, value2, "workcontent");
            return (Criteria) this;
        }

        public Criteria andFkPublisherIsNull() {
            addCriterion("fk_publisher is null");
            return (Criteria) this;
        }

        public Criteria andFkPublisherIsNotNull() {
            addCriterion("fk_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andFkPublisherEqualTo(Integer value) {
            addCriterion("fk_publisher =", value, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkPublisherNotEqualTo(Integer value) {
            addCriterion("fk_publisher <>", value, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkPublisherGreaterThan(Integer value) {
            addCriterion("fk_publisher >", value, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkPublisherGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_publisher >=", value, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkPublisherLessThan(Integer value) {
            addCriterion("fk_publisher <", value, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkPublisherLessThanOrEqualTo(Integer value) {
            addCriterion("fk_publisher <=", value, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkPublisherIn(List<Integer> values) {
            addCriterion("fk_publisher in", values, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkPublisherNotIn(List<Integer> values) {
            addCriterion("fk_publisher not in", values, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkPublisherBetween(Integer value1, Integer value2) {
            addCriterion("fk_publisher between", value1, value2, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkPublisherNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_publisher not between", value1, value2, "fkPublisher");
            return (Criteria) this;
        }

        public Criteria andFkAcceptIsNull() {
            addCriterion("fk_accept is null");
            return (Criteria) this;
        }

        public Criteria andFkAcceptIsNotNull() {
            addCriterion("fk_accept is not null");
            return (Criteria) this;
        }

        public Criteria andFkAcceptEqualTo(Integer value) {
            addCriterion("fk_accept =", value, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andFkAcceptNotEqualTo(Integer value) {
            addCriterion("fk_accept <>", value, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andFkAcceptGreaterThan(Integer value) {
            addCriterion("fk_accept >", value, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andFkAcceptGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_accept >=", value, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andFkAcceptLessThan(Integer value) {
            addCriterion("fk_accept <", value, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andFkAcceptLessThanOrEqualTo(Integer value) {
            addCriterion("fk_accept <=", value, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andFkAcceptIn(List<Integer> values) {
            addCriterion("fk_accept in", values, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andFkAcceptNotIn(List<Integer> values) {
            addCriterion("fk_accept not in", values, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andFkAcceptBetween(Integer value1, Integer value2) {
            addCriterion("fk_accept between", value1, value2, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andFkAcceptNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_accept not between", value1, value2, "fkAccept");
            return (Criteria) this;
        }

        public Criteria andWorkaddressIsNull() {
            addCriterion("workAddress is null");
            return (Criteria) this;
        }

        public Criteria andWorkaddressIsNotNull() {
            addCriterion("workAddress is not null");
            return (Criteria) this;
        }

        public Criteria andWorkaddressEqualTo(String value) {
            addCriterion("workAddress =", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressNotEqualTo(String value) {
            addCriterion("workAddress <>", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressGreaterThan(String value) {
            addCriterion("workAddress >", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressGreaterThanOrEqualTo(String value) {
            addCriterion("workAddress >=", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressLessThan(String value) {
            addCriterion("workAddress <", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressLessThanOrEqualTo(String value) {
            addCriterion("workAddress <=", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressLike(String value) {
            addCriterion("workAddress like", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressNotLike(String value) {
            addCriterion("workAddress not like", value, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressIn(List<String> values) {
            addCriterion("workAddress in", values, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressNotIn(List<String> values) {
            addCriterion("workAddress not in", values, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressBetween(String value1, String value2) {
            addCriterion("workAddress between", value1, value2, "workaddress");
            return (Criteria) this;
        }

        public Criteria andWorkaddressNotBetween(String value1, String value2) {
            addCriterion("workAddress not between", value1, value2, "workaddress");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconIsNull() {
            addCriterion("fk_workIcon is null");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconIsNotNull() {
            addCriterion("fk_workIcon is not null");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconEqualTo(Integer value) {
            addCriterion("fk_workIcon =", value, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconNotEqualTo(Integer value) {
            addCriterion("fk_workIcon <>", value, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconGreaterThan(Integer value) {
            addCriterion("fk_workIcon >", value, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_workIcon >=", value, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconLessThan(Integer value) {
            addCriterion("fk_workIcon <", value, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconLessThanOrEqualTo(Integer value) {
            addCriterion("fk_workIcon <=", value, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconIn(List<Integer> values) {
            addCriterion("fk_workIcon in", values, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconNotIn(List<Integer> values) {
            addCriterion("fk_workIcon not in", values, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconBetween(Integer value1, Integer value2) {
            addCriterion("fk_workIcon between", value1, value2, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkiconNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_workIcon not between", value1, value2, "fkWorkicon");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateIsNull() {
            addCriterion("fk_workState is null");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateIsNotNull() {
            addCriterion("fk_workState is not null");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateEqualTo(Integer value) {
            addCriterion("fk_workState =", value, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateNotEqualTo(Integer value) {
            addCriterion("fk_workState <>", value, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateGreaterThan(Integer value) {
            addCriterion("fk_workState >", value, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_workState >=", value, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateLessThan(Integer value) {
            addCriterion("fk_workState <", value, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateLessThanOrEqualTo(Integer value) {
            addCriterion("fk_workState <=", value, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateIn(List<Integer> values) {
            addCriterion("fk_workState in", values, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateNotIn(List<Integer> values) {
            addCriterion("fk_workState not in", values, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateBetween(Integer value1, Integer value2) {
            addCriterion("fk_workState between", value1, value2, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkWorkstateNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_workState not between", value1, value2, "fkWorkstate");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeIsNull() {
            addCriterion("fk_locationType is null");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeIsNotNull() {
            addCriterion("fk_locationType is not null");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeEqualTo(Integer value) {
            addCriterion("fk_locationType =", value, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeNotEqualTo(Integer value) {
            addCriterion("fk_locationType <>", value, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeGreaterThan(Integer value) {
            addCriterion("fk_locationType >", value, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_locationType >=", value, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeLessThan(Integer value) {
            addCriterion("fk_locationType <", value, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeLessThanOrEqualTo(Integer value) {
            addCriterion("fk_locationType <=", value, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeIn(List<Integer> values) {
            addCriterion("fk_locationType in", values, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeNotIn(List<Integer> values) {
            addCriterion("fk_locationType not in", values, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeBetween(Integer value1, Integer value2) {
            addCriterion("fk_locationType between", value1, value2, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkLocationtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_locationType not between", value1, value2, "fkLocationtype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeIsNull() {
            addCriterion("fk_timeType is null");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeIsNotNull() {
            addCriterion("fk_timeType is not null");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeEqualTo(Integer value) {
            addCriterion("fk_timeType =", value, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeNotEqualTo(Integer value) {
            addCriterion("fk_timeType <>", value, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeGreaterThan(Integer value) {
            addCriterion("fk_timeType >", value, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_timeType >=", value, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeLessThan(Integer value) {
            addCriterion("fk_timeType <", value, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeLessThanOrEqualTo(Integer value) {
            addCriterion("fk_timeType <=", value, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeIn(List<Integer> values) {
            addCriterion("fk_timeType in", values, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeNotIn(List<Integer> values) {
            addCriterion("fk_timeType not in", values, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeBetween(Integer value1, Integer value2) {
            addCriterion("fk_timeType between", value1, value2, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkTimetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_timeType not between", value1, value2, "fkTimetype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeIsNull() {
            addCriterion("fk_workType is null");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeIsNotNull() {
            addCriterion("fk_workType is not null");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeEqualTo(Integer value) {
            addCriterion("fk_workType =", value, "fkWorktype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeNotEqualTo(Integer value) {
            addCriterion("fk_workType <>", value, "fkWorktype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeGreaterThan(Integer value) {
            addCriterion("fk_workType >", value, "fkWorktype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_workType >=", value, "fkWorktype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeLessThan(Integer value) {
            addCriterion("fk_workType <", value, "fkWorktype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeLessThanOrEqualTo(Integer value) {
            addCriterion("fk_workType <=", value, "fkWorktype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeIn(List<Integer> values) {
            addCriterion("fk_workType in", values, "fkWorktype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeNotIn(List<Integer> values) {
            addCriterion("fk_workType not in", values, "fkWorktype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeBetween(Integer value1, Integer value2) {
            addCriterion("fk_workType between", value1, value2, "fkWorktype");
            return (Criteria) this;
        }

        public Criteria andFkWorktypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_workType not between", value1, value2, "fkWorktype");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}