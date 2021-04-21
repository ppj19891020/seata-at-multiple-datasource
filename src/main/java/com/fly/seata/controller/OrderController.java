package com.fly.seata.controller;

import com.fly.seata.common.OperationResponse;
import com.fly.seata.common.order.PlaceOrderRequestVO;
import com.fly.seata.service.OrderService;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HelloWoodes
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/normal/placeOrder")
    @ResponseBody
    public String normalPlaceOrder(HttpServletRequest request,@RequestBody PlaceOrderRequestVO placeOrderRequestVO) throws Exception {
        log.info("收到下单请求,用户:{}, 商品:{}", placeOrderRequestVO.getUserId(), placeOrderRequestVO.getProductId());
        String type = request.getHeader("type");
        OperationResponse operationResponse =  orderService.normalPlaceOrder(type,placeOrderRequestVO);
        if(operationResponse.isSuccess()){
            return "ok";
        }else{
            return "fail";
        }
    }

    @PostMapping("/seata/placeOrder")
    @ResponseBody
    public String seataPlaceOrder(HttpServletRequest request,@RequestBody PlaceOrderRequestVO placeOrderRequestVO) throws Exception {
        log.info("收到下单请求,用户:{}, 商品:{}", placeOrderRequestVO.getUserId(), placeOrderRequestVO.getProductId());
        String type = request.getHeader("type");
        OperationResponse operationResponse = orderService.seataPlaceOrder(type,placeOrderRequestVO);
        if(operationResponse.isSuccess()){
            return "ok";
        }else{
            return "fail";
        }
    }
}
