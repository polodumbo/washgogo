package com.project.washgogo.domain.dao;

import com.project.washgogo.domain.vo.OrderListVO;
import com.project.washgogo.domain.vo.OrderVO;
import com.project.washgogo.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDAO {
    private final OrderMapper orderMapper;
    //    주문내역 가져오기
    public List<OrderVO> getList() { return orderMapper.getList(); }
    //    주문번호로 조회
    public OrderVO findByBoardNumber(Long orderNumber){
        return orderMapper.select(orderNumber);
    }
    //    수거 신청
    public void applyRequest(OrderVO orderVO, OrderListVO orderListVO) { orderMapper.insert(orderVO, orderListVO);}
    //    이용 내역
    public OrderVO getLog(Long orderNumber) { return orderMapper.select(orderNumber);}
    //    총 수량 구하기
    public int getTotalQuantity() { return orderMapper.getTotalQuantity();}
    //    총 금액 구하기
    public int getTotalPrice() { return orderMapper.getTotalPrice(); }
    //    수거 취소
    public boolean removeRequest(Long orderNumber) { return orderMapper.delete(orderNumber) == 1;}
}
