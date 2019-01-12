package com.school.entity;

import java.util.ArrayList;
import java.util.List;

public class TIncomeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TIncomeExample() {
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

        public Criteria andFkUidIsNull() {
            addCriterion("fk_uid is null");
            return (Criteria) this;
        }

        public Criteria andFkUidIsNotNull() {
            addCriterion("fk_uid is not null");
            return (Criteria) this;
        }

        public Criteria andFkUidEqualTo(Integer value) {
            addCriterion("fk_uid =", value, "fkUid");
            return (Criteria) this;
        }

        public Criteria andFkUidNotEqualTo(Integer value) {
            addCriterion("fk_uid <>", value, "fkUid");
            return (Criteria) this;
        }

        public Criteria andFkUidGreaterThan(Integer value) {
            addCriterion("fk_uid >", value, "fkUid");
            return (Criteria) this;
        }

        public Criteria andFkUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fk_uid >=", value, "fkUid");
            return (Criteria) this;
        }

        public Criteria andFkUidLessThan(Integer value) {
            addCriterion("fk_uid <", value, "fkUid");
            return (Criteria) this;
        }

        public Criteria andFkUidLessThanOrEqualTo(Integer value) {
            addCriterion("fk_uid <=", value, "fkUid");
            return (Criteria) this;
        }

        public Criteria andFkUidIn(List<Integer> values) {
            addCriterion("fk_uid in", values, "fkUid");
            return (Criteria) this;
        }

        public Criteria andFkUidNotIn(List<Integer> values) {
            addCriterion("fk_uid not in", values, "fkUid");
            return (Criteria) this;
        }

        public Criteria andFkUidBetween(Integer value1, Integer value2) {
            addCriterion("fk_uid between", value1, value2, "fkUid");
            return (Criteria) this;
        }

        public Criteria andFkUidNotBetween(Integer value1, Integer value2) {
            addCriterion("fk_uid not between", value1, value2, "fkUid");
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

        public Criteria andMoneytimeIsNull() {
            addCriterion("moneyTime is null");
            return (Criteria) this;
        }

        public Criteria andMoneytimeIsNotNull() {
            addCriterion("moneyTime is not null");
            return (Criteria) this;
        }

        public Criteria andMoneytimeEqualTo(String value) {
            addCriterion("moneyTime =", value, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeNotEqualTo(String value) {
            addCriterion("moneyTime <>", value, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeGreaterThan(String value) {
            addCriterion("moneyTime >", value, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeGreaterThanOrEqualTo(String value) {
            addCriterion("moneyTime >=", value, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeLessThan(String value) {
            addCriterion("moneyTime <", value, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeLessThanOrEqualTo(String value) {
            addCriterion("moneyTime <=", value, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeLike(String value) {
            addCriterion("moneyTime like", value, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeNotLike(String value) {
            addCriterion("moneyTime not like", value, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeIn(List<String> values) {
            addCriterion("moneyTime in", values, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeNotIn(List<String> values) {
            addCriterion("moneyTime not in", values, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeBetween(String value1, String value2) {
            addCriterion("moneyTime between", value1, value2, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneytimeNotBetween(String value1, String value2) {
            addCriterion("moneyTime not between", value1, value2, "moneytime");
            return (Criteria) this;
        }

        public Criteria andMoneysIsNull() {
            addCriterion("moneys is null");
            return (Criteria) this;
        }

        public Criteria andMoneysIsNotNull() {
            addCriterion("moneys is not null");
            return (Criteria) this;
        }

        public Criteria andMoneysEqualTo(Double value) {
            addCriterion("moneys =", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysNotEqualTo(Double value) {
            addCriterion("moneys <>", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysGreaterThan(Double value) {
            addCriterion("moneys >", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysGreaterThanOrEqualTo(Double value) {
            addCriterion("moneys >=", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysLessThan(Double value) {
            addCriterion("moneys <", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysLessThanOrEqualTo(Double value) {
            addCriterion("moneys <=", value, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysIn(List<Double> values) {
            addCriterion("moneys in", values, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysNotIn(List<Double> values) {
            addCriterion("moneys not in", values, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysBetween(Double value1, Double value2) {
            addCriterion("moneys between", value1, value2, "moneys");
            return (Criteria) this;
        }

        public Criteria andMoneysNotBetween(Double value1, Double value2) {
            addCriterion("moneys not between", value1, value2, "moneys");
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