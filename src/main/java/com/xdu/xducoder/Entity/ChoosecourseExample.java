package com.xdu.xducoder.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChoosecourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChoosecourseExample() {
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

        public Criteria andSTDNumIsNull() {
            addCriterion("STDNum is null");
            return (Criteria) this;
        }

        public Criteria andSTDNumIsNotNull() {
            addCriterion("STDNum is not null");
            return (Criteria) this;
        }

        public Criteria andSTDNumEqualTo(String value) {
            addCriterion("STDNum =", value, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumNotEqualTo(String value) {
            addCriterion("STDNum <>", value, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumGreaterThan(String value) {
            addCriterion("STDNum >", value, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumGreaterThanOrEqualTo(String value) {
            addCriterion("STDNum >=", value, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumLessThan(String value) {
            addCriterion("STDNum <", value, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumLessThanOrEqualTo(String value) {
            addCriterion("STDNum <=", value, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumLike(String value) {
            addCriterion("STDNum like", value, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumNotLike(String value) {
            addCriterion("STDNum not like", value, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumIn(List<String> values) {
            addCriterion("STDNum in", values, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumNotIn(List<String> values) {
            addCriterion("STDNum not in", values, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumBetween(String value1, String value2) {
            addCriterion("STDNum between", value1, value2, "STDNum");
            return (Criteria) this;
        }

        public Criteria andSTDNumNotBetween(String value1, String value2) {
            addCriterion("STDNum not between", value1, value2, "STDNum");
            return (Criteria) this;
        }

        public Criteria andCourseIDIsNull() {
            addCriterion("CourseID is null");
            return (Criteria) this;
        }

        public Criteria andCourseIDIsNotNull() {
            addCriterion("CourseID is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIDEqualTo(String value) {
            addCriterion("CourseID =", value, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDNotEqualTo(String value) {
            addCriterion("CourseID <>", value, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDGreaterThan(String value) {
            addCriterion("CourseID >", value, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDGreaterThanOrEqualTo(String value) {
            addCriterion("CourseID >=", value, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDLessThan(String value) {
            addCriterion("CourseID <", value, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDLessThanOrEqualTo(String value) {
            addCriterion("CourseID <=", value, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDLike(String value) {
            addCriterion("CourseID like", value, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDNotLike(String value) {
            addCriterion("CourseID not like", value, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDIn(List<String> values) {
            addCriterion("CourseID in", values, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDNotIn(List<String> values) {
            addCriterion("CourseID not in", values, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDBetween(String value1, String value2) {
            addCriterion("CourseID between", value1, value2, "courseID");
            return (Criteria) this;
        }

        public Criteria andCourseIDNotBetween(String value1, String value2) {
            addCriterion("CourseID not between", value1, value2, "courseID");
            return (Criteria) this;
        }

        public Criteria andStepIDIsNull() {
            addCriterion("stepID is null");
            return (Criteria) this;
        }

        public Criteria andStepIDIsNotNull() {
            addCriterion("stepID is not null");
            return (Criteria) this;
        }

        public Criteria andStepIDEqualTo(Integer value) {
            addCriterion("stepID =", value, "stepID");
            return (Criteria) this;
        }

        public Criteria andStepIDNotEqualTo(Integer value) {
            addCriterion("stepID <>", value, "stepID");
            return (Criteria) this;
        }

        public Criteria andStepIDGreaterThan(Integer value) {
            addCriterion("stepID >", value, "stepID");
            return (Criteria) this;
        }

        public Criteria andStepIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("stepID >=", value, "stepID");
            return (Criteria) this;
        }

        public Criteria andStepIDLessThan(Integer value) {
            addCriterion("stepID <", value, "stepID");
            return (Criteria) this;
        }

        public Criteria andStepIDLessThanOrEqualTo(Integer value) {
            addCriterion("stepID <=", value, "stepID");
            return (Criteria) this;
        }

        public Criteria andStepIDIn(List<Integer> values) {
            addCriterion("stepID in", values, "stepID");
            return (Criteria) this;
        }

        public Criteria andStepIDNotIn(List<Integer> values) {
            addCriterion("stepID not in", values, "stepID");
            return (Criteria) this;
        }

        public Criteria andStepIDBetween(Integer value1, Integer value2) {
            addCriterion("stepID between", value1, value2, "stepID");
            return (Criteria) this;
        }

        public Criteria andStepIDNotBetween(Integer value1, Integer value2) {
            addCriterion("stepID not between", value1, value2, "stepID");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNull() {
            addCriterion("RegDate is null");
            return (Criteria) this;
        }

        public Criteria andRegDateIsNotNull() {
            addCriterion("RegDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegDateEqualTo(Date value) {
            addCriterion("RegDate =", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotEqualTo(Date value) {
            addCriterion("RegDate <>", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThan(Date value) {
            addCriterion("RegDate >", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateGreaterThanOrEqualTo(Date value) {
            addCriterion("RegDate >=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThan(Date value) {
            addCriterion("RegDate <", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateLessThanOrEqualTo(Date value) {
            addCriterion("RegDate <=", value, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateIn(List<Date> values) {
            addCriterion("RegDate in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotIn(List<Date> values) {
            addCriterion("RegDate not in", values, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateBetween(Date value1, Date value2) {
            addCriterion("RegDate between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andRegDateNotBetween(Date value1, Date value2) {
            addCriterion("RegDate not between", value1, value2, "regDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNull() {
            addCriterion("CompleteDate is null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIsNotNull() {
            addCriterion("CompleteDate is not null");
            return (Criteria) this;
        }

        public Criteria andCompleteDateEqualTo(Date value) {
            addCriterion("CompleteDate =", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotEqualTo(Date value) {
            addCriterion("CompleteDate <>", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThan(Date value) {
            addCriterion("CompleteDate >", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CompleteDate >=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThan(Date value) {
            addCriterion("CompleteDate <", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateLessThanOrEqualTo(Date value) {
            addCriterion("CompleteDate <=", value, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateIn(List<Date> values) {
            addCriterion("CompleteDate in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotIn(List<Date> values) {
            addCriterion("CompleteDate not in", values, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateBetween(Date value1, Date value2) {
            addCriterion("CompleteDate between", value1, value2, "completeDate");
            return (Criteria) this;
        }

        public Criteria andCompleteDateNotBetween(Date value1, Date value2) {
            addCriterion("CompleteDate not between", value1, value2, "completeDate");
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