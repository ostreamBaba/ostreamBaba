package com.example.demo.dao;

import com.example.demo.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ Create by ostreamBaba on 18-6-27
 * @ √Ë ˆ
 */


public interface OrderRepository extends JpaRepository<Orders,Long> {

     Orders save(Orders order);

     Orders findByAdoptAndOrderUserId(Integer adopt,Integer id);

     List<Orders> findAllByAdoptAndOrderUserId(Integer adopt,Integer id);

     /*List<Orders> findAllByAdopt(Integer adopt);*/

     Orders findByOrderId(Integer orderId);

     @Transactional
     @Modifying
     @Query(value = "update orders o set o.adopt=?1 WHERE o.order_id=?2",nativeQuery = true)
     int updateAdoptById(Integer adopt,Integer id);
}
