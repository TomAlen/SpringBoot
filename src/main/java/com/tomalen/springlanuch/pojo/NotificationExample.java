package com.tomalen.springlanuch.pojo;

import java.util.ArrayList;
import java.util.List;

public class NotificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public NotificationExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andNotifierIsNull() {
            addCriterion("notifier is null");
            return (Criteria) this;
        }

        public Criteria andNotifierIsNotNull() {
            addCriterion("notifier is not null");
            return (Criteria) this;
        }

        public Criteria andNotifierEqualTo(Integer value) {
            addCriterion("notifier =", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotEqualTo(Integer value) {
            addCriterion("notifier <>", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierGreaterThan(Integer value) {
            addCriterion("notifier >", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierGreaterThanOrEqualTo(Integer value) {
            addCriterion("notifier >=", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierLessThan(Integer value) {
            addCriterion("notifier <", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierLessThanOrEqualTo(Integer value) {
            addCriterion("notifier <=", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierIn(List<Integer> values) {
            addCriterion("notifier in", values, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotIn(List<Integer> values) {
            addCriterion("notifier not in", values, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierBetween(Integer value1, Integer value2) {
            addCriterion("notifier between", value1, value2, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotBetween(Integer value1, Integer value2) {
            addCriterion("notifier not between", value1, value2, "notifier");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(Integer value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(Integer value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(Integer value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(Integer value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(Integer value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<Integer> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<Integer> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(Integer value1, Integer value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(Integer value1, Integer value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andOuterIdIsNull() {
            addCriterion("outer_id is null");
            return (Criteria) this;
        }

        public Criteria andOuterIdIsNotNull() {
            addCriterion("outer_id is not null");
            return (Criteria) this;
        }

        public Criteria andOuterIdEqualTo(Integer value) {
            addCriterion("outer_id =", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotEqualTo(Integer value) {
            addCriterion("outer_id <>", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdGreaterThan(Integer value) {
            addCriterion("outer_id >", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("outer_id >=", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdLessThan(Integer value) {
            addCriterion("outer_id <", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdLessThanOrEqualTo(Integer value) {
            addCriterion("outer_id <=", value, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdIn(List<Integer> values) {
            addCriterion("outer_id in", values, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotIn(List<Integer> values) {
            addCriterion("outer_id not in", values, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdBetween(Integer value1, Integer value2) {
            addCriterion("outer_id between", value1, value2, "outerId");
            return (Criteria) this;
        }

        public Criteria andOuterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("outer_id not between", value1, value2, "outerId");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeIsNull() {
            addCriterion("notified_type is null");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeIsNotNull() {
            addCriterion("notified_type is not null");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeEqualTo(Integer value) {
            addCriterion("notified_type =", value, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeNotEqualTo(Integer value) {
            addCriterion("notified_type <>", value, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeGreaterThan(Integer value) {
            addCriterion("notified_type >", value, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("notified_type >=", value, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeLessThan(Integer value) {
            addCriterion("notified_type <", value, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeLessThanOrEqualTo(Integer value) {
            addCriterion("notified_type <=", value, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeIn(List<Integer> values) {
            addCriterion("notified_type in", values, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeNotIn(List<Integer> values) {
            addCriterion("notified_type not in", values, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeBetween(Integer value1, Integer value2) {
            addCriterion("notified_type between", value1, value2, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andNotifiedTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("notified_type not between", value1, value2, "notifiedType");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Long value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Long value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Long value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Long value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Long value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Long> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Long> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Long value1, Long value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Long value1, Long value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusIsNull() {
            addCriterion("notified_status is null");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusIsNotNull() {
            addCriterion("notified_status is not null");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusEqualTo(Integer value) {
            addCriterion("notified_status =", value, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusNotEqualTo(Integer value) {
            addCriterion("notified_status <>", value, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusGreaterThan(Integer value) {
            addCriterion("notified_status >", value, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("notified_status >=", value, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusLessThan(Integer value) {
            addCriterion("notified_status <", value, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusLessThanOrEqualTo(Integer value) {
            addCriterion("notified_status <=", value, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusIn(List<Integer> values) {
            addCriterion("notified_status in", values, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusNotIn(List<Integer> values) {
            addCriterion("notified_status not in", values, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusBetween(Integer value1, Integer value2) {
            addCriterion("notified_status between", value1, value2, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifiedStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("notified_status not between", value1, value2, "notifiedStatus");
            return (Criteria) this;
        }

        public Criteria andNotifierNameIsNull() {
            addCriterion("notifier_name is null");
            return (Criteria) this;
        }

        public Criteria andNotifierNameIsNotNull() {
            addCriterion("notifier_name is not null");
            return (Criteria) this;
        }

        public Criteria andNotifierNameEqualTo(String value) {
            addCriterion("notifier_name =", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameNotEqualTo(String value) {
            addCriterion("notifier_name <>", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameGreaterThan(String value) {
            addCriterion("notifier_name >", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameGreaterThanOrEqualTo(String value) {
            addCriterion("notifier_name >=", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameLessThan(String value) {
            addCriterion("notifier_name <", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameLessThanOrEqualTo(String value) {
            addCriterion("notifier_name <=", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameLike(String value) {
            addCriterion("notifier_name like", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameNotLike(String value) {
            addCriterion("notifier_name not like", value, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameIn(List<String> values) {
            addCriterion("notifier_name in", values, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameNotIn(List<String> values) {
            addCriterion("notifier_name not in", values, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameBetween(String value1, String value2) {
            addCriterion("notifier_name between", value1, value2, "notifierName");
            return (Criteria) this;
        }

        public Criteria andNotifierNameNotBetween(String value1, String value2) {
            addCriterion("notifier_name not between", value1, value2, "notifierName");
            return (Criteria) this;
        }

        public Criteria andOutTitleIsNull() {
            addCriterion("out_title is null");
            return (Criteria) this;
        }

        public Criteria andOutTitleIsNotNull() {
            addCriterion("out_title is not null");
            return (Criteria) this;
        }

        public Criteria andOutTitleEqualTo(String value) {
            addCriterion("out_title =", value, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleNotEqualTo(String value) {
            addCriterion("out_title <>", value, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleGreaterThan(String value) {
            addCriterion("out_title >", value, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleGreaterThanOrEqualTo(String value) {
            addCriterion("out_title >=", value, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleLessThan(String value) {
            addCriterion("out_title <", value, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleLessThanOrEqualTo(String value) {
            addCriterion("out_title <=", value, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleLike(String value) {
            addCriterion("out_title like", value, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleNotLike(String value) {
            addCriterion("out_title not like", value, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleIn(List<String> values) {
            addCriterion("out_title in", values, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleNotIn(List<String> values) {
            addCriterion("out_title not in", values, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleBetween(String value1, String value2) {
            addCriterion("out_title between", value1, value2, "outTitle");
            return (Criteria) this;
        }

        public Criteria andOutTitleNotBetween(String value1, String value2) {
            addCriterion("out_title not between", value1, value2, "outTitle");
            return (Criteria) this;
        }
    }

    /**
     */
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