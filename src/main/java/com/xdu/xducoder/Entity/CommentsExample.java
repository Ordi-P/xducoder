package com.xdu.xducoder.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentsExample() {
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

        public Criteria andCommentIDIsNull() {
            addCriterion("CommentID is null");
            return (Criteria) this;
        }

        public Criteria andCommentIDIsNotNull() {
            addCriterion("CommentID is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIDEqualTo(String value) {
            addCriterion("CommentID =", value, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDNotEqualTo(String value) {
            addCriterion("CommentID <>", value, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDGreaterThan(String value) {
            addCriterion("CommentID >", value, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDGreaterThanOrEqualTo(String value) {
            addCriterion("CommentID >=", value, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDLessThan(String value) {
            addCriterion("CommentID <", value, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDLessThanOrEqualTo(String value) {
            addCriterion("CommentID <=", value, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDLike(String value) {
            addCriterion("CommentID like", value, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDNotLike(String value) {
            addCriterion("CommentID not like", value, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDIn(List<String> values) {
            addCriterion("CommentID in", values, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDNotIn(List<String> values) {
            addCriterion("CommentID not in", values, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDBetween(String value1, String value2) {
            addCriterion("CommentID between", value1, value2, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentIDNotBetween(String value1, String value2) {
            addCriterion("CommentID not between", value1, value2, "commentID");
            return (Criteria) this;
        }

        public Criteria andCommentTitleIsNull() {
            addCriterion("CommentTitle is null");
            return (Criteria) this;
        }

        public Criteria andCommentTitleIsNotNull() {
            addCriterion("CommentTitle is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTitleEqualTo(String value) {
            addCriterion("CommentTitle =", value, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleNotEqualTo(String value) {
            addCriterion("CommentTitle <>", value, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleGreaterThan(String value) {
            addCriterion("CommentTitle >", value, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleGreaterThanOrEqualTo(String value) {
            addCriterion("CommentTitle >=", value, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleLessThan(String value) {
            addCriterion("CommentTitle <", value, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleLessThanOrEqualTo(String value) {
            addCriterion("CommentTitle <=", value, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleLike(String value) {
            addCriterion("CommentTitle like", value, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleNotLike(String value) {
            addCriterion("CommentTitle not like", value, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleIn(List<String> values) {
            addCriterion("CommentTitle in", values, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleNotIn(List<String> values) {
            addCriterion("CommentTitle not in", values, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleBetween(String value1, String value2) {
            addCriterion("CommentTitle between", value1, value2, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentTitleNotBetween(String value1, String value2) {
            addCriterion("CommentTitle not between", value1, value2, "commentTitle");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("`Comment` is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("`Comment` is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("`Comment` =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("`Comment` <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("`Comment` >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("`Comment` >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("`Comment` <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("`Comment` <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("`Comment` like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("`Comment` not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("`Comment` in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("`Comment` not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("`Comment` between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("`Comment` not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentUserIsNull() {
            addCriterion("CommentUser is null");
            return (Criteria) this;
        }

        public Criteria andCommentUserIsNotNull() {
            addCriterion("CommentUser is not null");
            return (Criteria) this;
        }

        public Criteria andCommentUserEqualTo(String value) {
            addCriterion("CommentUser =", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserNotEqualTo(String value) {
            addCriterion("CommentUser <>", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserGreaterThan(String value) {
            addCriterion("CommentUser >", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserGreaterThanOrEqualTo(String value) {
            addCriterion("CommentUser >=", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserLessThan(String value) {
            addCriterion("CommentUser <", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserLessThanOrEqualTo(String value) {
            addCriterion("CommentUser <=", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserLike(String value) {
            addCriterion("CommentUser like", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserNotLike(String value) {
            addCriterion("CommentUser not like", value, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserIn(List<String> values) {
            addCriterion("CommentUser in", values, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserNotIn(List<String> values) {
            addCriterion("CommentUser not in", values, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserBetween(String value1, String value2) {
            addCriterion("CommentUser between", value1, value2, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentUserNotBetween(String value1, String value2) {
            addCriterion("CommentUser not between", value1, value2, "commentUser");
            return (Criteria) this;
        }

        public Criteria andCommentDateIsNull() {
            addCriterion("CommentDate is null");
            return (Criteria) this;
        }

        public Criteria andCommentDateIsNotNull() {
            addCriterion("CommentDate is not null");
            return (Criteria) this;
        }

        public Criteria andCommentDateEqualTo(Date value) {
            addCriterion("CommentDate =", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotEqualTo(Date value) {
            addCriterion("CommentDate <>", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateGreaterThan(Date value) {
            addCriterion("CommentDate >", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CommentDate >=", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateLessThan(Date value) {
            addCriterion("CommentDate <", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateLessThanOrEqualTo(Date value) {
            addCriterion("CommentDate <=", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateIn(List<Date> values) {
            addCriterion("CommentDate in", values, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotIn(List<Date> values) {
            addCriterion("CommentDate not in", values, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateBetween(Date value1, Date value2) {
            addCriterion("CommentDate between", value1, value2, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotBetween(Date value1, Date value2) {
            addCriterion("CommentDate not between", value1, value2, "commentDate");
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