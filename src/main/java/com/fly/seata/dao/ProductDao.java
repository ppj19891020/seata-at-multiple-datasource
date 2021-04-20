package com.fly.seata.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fly.seata.common.storage.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author HelloWood
 */
@Mapper
public interface ProductDao extends BaseMapper<Product> {

    @Update("update storage set used = used + #{count},residue = residue - #{count} where id = #{productId} and residue > 0")
    int reduce(@Param("productId") Long productId,@Param("count") Integer count);

    /**
     * 插入库存
     * @return
     */
    @Insert("INSERT INTO `storage`(`product_id`, `total`, `used`, `residue`) VALUES (1000, 1000000, 0, 1000000)")
    int insert();

}
