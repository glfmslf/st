package com.yy.st.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author yuyou
 * @since 2022/8/10 10:42
 */
@AllArgsConstructor
@Getter
public enum ClassEnum {

    LIST_NODE(1, ListNode.class),
    USER(2, User.class),
    ;

    private Integer id;
    private Class clazz;
}
