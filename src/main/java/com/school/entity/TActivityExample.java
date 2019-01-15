package com.school.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TActivityExample() {
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

        public Criteria andTitlesIsNull() {
            addCriterion("titles is null");
            return (Criteria) this;
        }

        public Criteria andTitlesIsNotNull() {
            addCriterion("titles is not null");
            return (Criteria) this;
        }

        public Criteria andTitlesEqualTo(String value) {
            addCriterion("titles =", value, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesNotEqualTo(String value) {
            addCriterion("titles <>", value, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesGreaterThan(String value) {
            addCriterion("titles >", value, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesGreaterThanOrEqualTo(String value) {
            addCriterion("titles >=", value, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesLessThan(String value) {
            addCriterion("titles <", value, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesLessThanOrEqualTo(String value) {
            addCriterion("titles <=", value, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesLike(String value) {
            addCriterion("titles like", value, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesNotLike(String value) {
            addCriterion("titles not like", value, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesIn(List<String> values) {
            addCriterion("titles in", values, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesNotIn(List<String> values) {
            addCriterion("titles not in", values, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesBetween(String value1, String value2) {
            addCriterion("titles between", value1, value2, "titles");
            return (Criteria) this;
        }

        public Criteria andTitlesNotBetween(String value1, String value2) {
            addCriterion("titles not between", value1, value2, "titles");
            return (Criteria) this;
        }

        public Criteria andImagesIsNull() {
            addCriterion("images is null");
            return (Criteria) this;
        }

        public Criteria andImagesIsNotNull() {
            addCriterion("images is not null");
            return (Criteria) this;
        }

        public Criteria andImagesEqualTo(String value) {
            addCriterion("images =", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotEqualTo(String value) {
            addCriterion("images <>", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThan(String value) {
            addCriterion("images >", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesGreaterThanOrEqualTo(String value) {
            addCriterion("images >=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThan(String value) {
            addCriterion("images <", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLessThanOrEqualTo(String value) {
            addCriterion("images <=", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesLike(String value) {
            addCriterion("images like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotLike(String value) {
            addCriterion("images not like", value, "images");
            return (Criteria) this;
        }

        public Criteria andImagesIn(List<String> values) {
            addCriterion("images in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotIn(List<String> values) {
            addCriterion("images not in", values, "images");
            return (Criteria) this;
        }

        public Criteria andImagesBetween(String value1, String value2) {
            addCriterion("images between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andImagesNotBetween(String value1, String value2) {
            addCriterion("images not between", value1, value2, "images");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andActivitytimeIsNull() {
            addCriterion("activityTime is null");
            return (Criteria) this;
        }

        public Criteria andActivitytimeIsNotNull() {
            addCriterion("activityTime is not null");
            return (Criteria) this;
        }

        public Criteria andActivitytimeEqualTo(Date value) {
            addCriterionForJDBCDate("activityTime =", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("activityTime <>", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeGreaterThan(Date value) {
            addCriterionForJDBCDate("activityTime >", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("activityTime >=", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeLessThan(Date value) {
            addCriterionForJDBCDate("activityTime <", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("activityTime <=", value, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeIn(List<Date> values) {
            addCriterionForJDBCDate("activityTime in", values, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("activityTime not in", values, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("activityTime between", value1, value2, "activitytime");
            return (Criteria) this;
        }

        public Criteria andActivitytimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("activityTime not between", value1, value2, "activitytime");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPrecautionsIsNull() {
            addCriterion("precautions is null");
            return (Criteria) this;
        }

        public Criteria andPrecautionsIsNotNull() {
            addCriterion("precautions is not null");
            return (Criteria) this;
        }

        public Criteria andPrecautionsEqualTo(String value) {
            addCriterion("precautions =", value, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsNotEqualTo(String value) {
            addCriterion("precautions <>", value, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsGreaterThan(String value) {
            addCriterion("precautions >", value, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsGreaterThanOrEqualTo(String value) {
            addCriterion("precautions >=", value, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsLessThan(String value) {
            addCriterion("precautions <", value, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsLessThanOrEqualTo(String value) {
            addCriterion("precautions <=", value, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsLike(String value) {
            addCriterion("precautions like", value, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsNotLike(String value) {
            addCriterion("precautions not like", value, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsIn(List<String> values) {
            addCriterion("precautions in", values, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsNotIn(List<String> values) {
            addCriterion("precautions not in", values, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsBetween(String value1, String value2) {
            addCriterion("precautions between", value1, value2, "precautions");
            return (Criteria) this;
        }

        public Criteria andPrecautionsNotBetween(String value1, String value2) {
            addCriterion("precautions not between", value1, value2, "precautions");
            return (Criteria) this;
        }

        public Criteria andClaimIsNull() {
            addCriterion("claim is null");
            return (Criteria) this;
        }

        public Criteria andClaimIsNotNull() {
            addCriterion("claim is not null");
            return (Criteria) this;
        }

        public Criteria andClaimEqualTo(String value) {
            addCriterion("claim =", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimNotEqualTo(String value) {
            addCriterion("claim <>", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimGreaterThan(String value) {
            addCriterion("claim >", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimGreaterThanOrEqualTo(String value) {
            addCriterion("claim >=", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimLessThan(String value) {
            addCriterion("claim <", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimLessThanOrEqualTo(String value) {
            addCriterion("claim <=", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimLike(String value) {
            addCriterion("claim like", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimNotLike(String value) {
            addCriterion("claim not like", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimIn(List<String> values) {
            addCriterion("claim in", values, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimNotIn(List<String> values) {
            addCriterion("claim not in", values, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimBetween(String value1, String value2) {
            addCriterion("claim between", value1, value2, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimNotBetween(String value1, String value2) {
            addCriterion("claim not between", value1, value2, "claim");
            return (Criteria) this;
        }

        public Criteria andObjectsIsNull() {
            addCriterion("objects is null");
            return (Criteria) this;
        }

        public Criteria andObjectsIsNotNull() {
            addCriterion("objects is not null");
            return (Criteria) this;
        }

        public Criteria andObjectsEqualTo(String value) {
            addCriterion("objects =", value, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsNotEqualTo(String value) {
            addCriterion("objects <>", value, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsGreaterThan(String value) {
            addCriterion("objects >", value, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsGreaterThanOrEqualTo(String value) {
            addCriterion("objects >=", value, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsLessThan(String value) {
            addCriterion("objects <", value, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsLessThanOrEqualTo(String value) {
            addCriterion("objects <=", value, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsLike(String value) {
            addCriterion("objects like", value, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsNotLike(String value) {
            addCriterion("objects not like", value, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsIn(List<String> values) {
            addCriterion("objects in", values, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsNotIn(List<String> values) {
            addCriterion("objects not in", values, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsBetween(String value1, String value2) {
            addCriterion("objects between", value1, value2, "objects");
            return (Criteria) this;
        }

        public Criteria andObjectsNotBetween(String value1, String value2) {
            addCriterion("objects not between", value1, value2, "objects");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNull() {
            addCriterion("organizer is null");
            return (Criteria) this;
        }

        public Criteria andOrganizerIsNotNull() {
            addCriterion("organizer is not null");
            return (Criteria) this;
        }

        public Criteria andOrganizerEqualTo(String value) {
            addCriterion("organizer =", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotEqualTo(String value) {
            addCriterion("organizer <>", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThan(String value) {
            addCriterion("organizer >", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerGreaterThanOrEqualTo(String value) {
            addCriterion("organizer >=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThan(String value) {
            addCriterion("organizer <", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLessThanOrEqualTo(String value) {
            addCriterion("organizer <=", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerLike(String value) {
            addCriterion("organizer like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotLike(String value) {
            addCriterion("organizer not like", value, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerIn(List<String> values) {
            addCriterion("organizer in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotIn(List<String> values) {
            addCriterion("organizer not in", values, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerBetween(String value1, String value2) {
            addCriterion("organizer between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andOrganizerNotBetween(String value1, String value2) {
            addCriterion("organizer not between", value1, value2, "organizer");
            return (Criteria) this;
        }

        public Criteria andCurrentnumIsNull() {
            addCriterion("currentNum is null");
            return (Criteria) this;
        }

        public Criteria andCurrentnumIsNotNull() {
            addCriterion("currentNum is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentnumEqualTo(Integer value) {
            addCriterion("currentNum =", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumNotEqualTo(Integer value) {
            addCriterion("currentNum <>", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumGreaterThan(Integer value) {
            addCriterion("currentNum >", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("currentNum >=", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumLessThan(Integer value) {
            addCriterion("currentNum <", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumLessThanOrEqualTo(Integer value) {
            addCriterion("currentNum <=", value, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumIn(List<Integer> values) {
            addCriterion("currentNum in", values, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumNotIn(List<Integer> values) {
            addCriterion("currentNum not in", values, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumBetween(Integer value1, Integer value2) {
            addCriterion("currentNum between", value1, value2, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCurrentnumNotBetween(Integer value1, Integer value2) {
            addCriterion("currentNum not between", value1, value2, "currentnum");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andFkUseridIsNull() {
            addCriterion("fk_userid is null");
            return (Criteria) this;
        }

        public Criteria andFkUseridIsNotNull() {
            addCriterion("fk_userid is not null");
            return (Criteria) this;
        }

        public Criteria andFkUseridEqualTo(Integer value) {
            addCriterion("fk_userid =", value, "fkUserid");
            return (Criteria) this;
        }

        public Criteria andFkUseridNotEqualTo(Integer value) {
            addCriterion("fk_userid <>", value, "fkUserid");
            return (Criteria) this;
        }

        public Criteria andFkUseridGreaterThan(Integer value) {
            addCriterion("fk_userid >", value, "fkUserid");
            return (Criteria) this;
        }

        public Criteria andFkUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_userid >=", value, "fkUserid");
            return (Criteria) this;
        }

        public Criteria andFkUseridLessThan(Integer value) {
            addCriterion("fk_userid <", value, "fkUserid");
            return (Criteria) this;
        }

        public Criteria andFkUseridLessThanOrEqualTo(Integer value) {
            addCriterion("fk_userid <=", value, "fkUserid");
            return (Criteria) this;
        }

        public Criteria andFkUseridIn(List<Integer> values) {
            addCriterion("fk_userid in", values, "fkUserid");
            return (Criteria) this;
        }

        public Criteria andFkUseridNotIn(List<Integer> values) {
            addCriterion("fk_userid not in", values, "fkUserid");
            return (Criteria) this;
        }

        public Criteria andFkUseridBetween(Integer value1, Integer value2) {
            addCriterion("fk_userid between", value1, value2, "fkUserid");
            return (Criteria) this;
        }

        public Criteria andFkUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_userid not between", value1, value2, "fkUserid");
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