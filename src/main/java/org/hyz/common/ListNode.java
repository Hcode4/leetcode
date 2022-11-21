package org.hyz.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huyz
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListNode<T> {

    T val;

    ListNode<T> next;
}
