package world.xuewei.service;

import world.xuewei.mapper.*;

import javax.annotation.Resource;

/**
 * : 基础业务逻辑类
 *
 * @author: XUEW
 * @date 2021/2/28 下午9:20
 * @Version: 1.0
 */
public class BaseService {

    @Resource
    protected AddressMapper addressMapper;

    @Resource
    protected CartMapper cartMapper;

    @Resource
    protected ClassifyMapper classifyMapper;

    @Resource
    protected CollectionMapper collectionMapper;

    @Resource
    protected CommodityCommentMapper commodityCommentMapper;

    @Resource
    protected CommodityMapper commodityMapper;

    @Resource
    protected OrderMapper orderMapper;

    @Resource
    protected UserMapper userMapper;

}
