package com.xdu.xducoder.Entity;

import java.util.ArrayList;
import java.util.List;

public class StepsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StepsExample() {
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

        public Criteria andStepNameIsNull() {
            addCriterion("stepName is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("stepName is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("stepName =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("stepName <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("stepName >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("stepName >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("stepName <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("stepName <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("stepName like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("stepName not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(List<String> values) {
            addCriterion("stepName in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(List<String> values) {
            addCriterion("stepName not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("stepName between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("stepName not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionIsNull() {
            addCriterion("stepDescription is null");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionIsNotNull() {
            addCriterion("stepDescription is not null");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionEqualTo(String value) {
            addCriterion("stepDescription =", value, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionNotEqualTo(String value) {
            addCriterion("stepDescription <>", value, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionGreaterThan(String value) {
            addCriterion("stepDescription >", value, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("stepDescription >=", value, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionLessThan(String value) {
            addCriterion("stepDescription <", value, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionLessThanOrEqualTo(String value) {
            addCriterion("stepDescription <=", value, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionLike(String value) {
            addCriterion("stepDescription like", value, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionNotLike(String value) {
            addCriterion("stepDescription not like", value, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionIn(List<String> values) {
            addCriterion("stepDescription in", values, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionNotIn(List<String> values) {
            addCriterion("stepDescription not in", values, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionBetween(String value1, String value2) {
            addCriterion("stepDescription between", value1, value2, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepDescriptionNotBetween(String value1, String value2) {
            addCriterion("stepDescription not between", value1, value2, "stepDescription");
            return (Criteria) this;
        }

        public Criteria andStepUrlIsNull() {
            addCriterion("stepUrl is null");
            return (Criteria) this;
        }

        public Criteria andStepUrlIsNotNull() {
            addCriterion("stepUrl is not null");
            return (Criteria) this;
        }

        public Criteria andStepUrlEqualTo(String value) {
            addCriterion("stepUrl =", value, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlNotEqualTo(String value) {
            addCriterion("stepUrl <>", value, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlGreaterThan(String value) {
            addCriterion("stepUrl >", value, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlGreaterThanOrEqualTo(String value) {
            addCriterion("stepUrl >=", value, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlLessThan(String value) {
            addCriterion("stepUrl <", value, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlLessThanOrEqualTo(String value) {
            addCriterion("stepUrl <=", value, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlLike(String value) {
            addCriterion("stepUrl like", value, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlNotLike(String value) {
            addCriterion("stepUrl not like", value, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlIn(List<String> values) {
            addCriterion("stepUrl in", values, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlNotIn(List<String> values) {
            addCriterion("stepUrl not in", values, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlBetween(String value1, String value2) {
            addCriterion("stepUrl between", value1, value2, "stepUrl");
            return (Criteria) this;
        }

        public Criteria andStepUrlNotBetween(String value1, String value2) {
            addCriterion("stepUrl not between", value1, value2, "stepUrl");
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