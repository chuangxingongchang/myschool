package com.school.entity;

import java.util.ArrayList;
import java.util.List;

public class TSignupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSignupExample() {
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

        public Criteria andPkPluridIsNull() {
            addCriterion("pk_plurid is null");
            return (Criteria) this;
        }

        public Criteria andPkPluridIsNotNull() {
            addCriterion("pk_plurid is not null");
            return (Criteria) this;
        }

        public Criteria andPkPluridEqualTo(Integer value) {
            addCriterion("pk_plurid =", value, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkPluridNotEqualTo(Integer value) {
            addCriterion("pk_plurid <>", value, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkPluridGreaterThan(Integer value) {
            addCriterion("pk_plurid >", value, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkPluridGreaterThanOrEqualTo(Integer value) {
            addCriterion("pk_plurid >=", value, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkPluridLessThan(Integer value) {
            addCriterion("pk_plurid <", value, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkPluridLessThanOrEqualTo(Integer value) {
            addCriterion("pk_plurid <=", value, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkPluridIn(List<Integer> values) {
            addCriterion("pk_plurid in", values, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkPluridNotIn(List<Integer> values) {
            addCriterion("pk_plurid not in", values, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkPluridBetween(Integer value1, Integer value2) {
            addCriterion("pk_plurid between", value1, value2, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkPluridNotBetween(Integer value1, Integer value2) {
            addCriterion("pk_plurid not between", value1, value2, "pkPlurid");
            return (Criteria) this;
        }

        public Criteria andPkUidIsNull() {
            addCriterion("pk_uid is null");
            return (Criteria) this;
        }

        public Criteria andPkUidIsNotNull() {
            addCriterion("pk_uid is not null");
            return (Criteria) this;
        }

        public Criteria andPkUidEqualTo(Integer value) {
            addCriterion("pk_uid =", value, "pkUid");
            return (Criteria) this;
        }

        public Criteria andPkUidNotEqualTo(Integer value) {
            addCriterion("pk_uid <>", value, "pkUid");
            return (Criteria) this;
        }

        public Criteria andPkUidGreaterThan(Integer value) {
            addCriterion("pk_uid >", value, "pkUid");
            return (Criteria) this;
        }

        public Criteria andPkUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pk_uid >=", value, "pkUid");
            return (Criteria) this;
        }

        public Criteria andPkUidLessThan(Integer value) {
            addCriterion("pk_uid <", value, "pkUid");
            return (Criteria) this;
        }

        public Criteria andPkUidLessThanOrEqualTo(Integer value) {
            addCriterion("pk_uid <=", value, "pkUid");
            return (Criteria) this;
        }

        public Criteria andPkUidIn(List<Integer> values) {
            addCriterion("pk_uid in", values, "pkUid");
            return (Criteria) this;
        }

        public Criteria andPkUidNotIn(List<Integer> values) {
            addCriterion("pk_uid not in", values, "pkUid");
            return (Criteria) this;
        }

        public Criteria andPkUidBetween(Integer value1, Integer value2) {
            addCriterion("pk_uid between", value1, value2, "pkUid");
            return (Criteria) this;
        }

        public Criteria andPkUidNotBetween(Integer value1, Integer value2) {
            addCriterion("pk_uid not between", value1, value2, "pkUid");
            return (Criteria) this;
        }

        public Criteria andSignstateIsNull() {
            addCriterion("signstate is null");
            return (Criteria) this;
        }

        public Criteria andSignstateIsNotNull() {
            addCriterion("signstate is not null");
            return (Criteria) this;
        }

        public Criteria andSignstateEqualTo(String value) {
            addCriterion("signstate =", value, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateNotEqualTo(String value) {
            addCriterion("signstate <>", value, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateGreaterThan(String value) {
            addCriterion("signstate >", value, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateGreaterThanOrEqualTo(String value) {
            addCriterion("signstate >=", value, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateLessThan(String value) {
            addCriterion("signstate <", value, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateLessThanOrEqualTo(String value) {
            addCriterion("signstate <=", value, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateLike(String value) {
            addCriterion("signstate like", value, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateNotLike(String value) {
            addCriterion("signstate not like", value, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateIn(List<String> values) {
            addCriterion("signstate in", values, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateNotIn(List<String> values) {
            addCriterion("signstate not in", values, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateBetween(String value1, String value2) {
            addCriterion("signstate between", value1, value2, "signstate");
            return (Criteria) this;
        }

        public Criteria andSignstateNotBetween(String value1, String value2) {
            addCriterion("signstate not between", value1, value2, "signstate");
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