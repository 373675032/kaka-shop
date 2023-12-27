package world.xuewei.mapper;

import org.apache.ibatis.annotations.Mapper;
import world.xuewei.entity.Commodity;

import java.util.List;

/**
 * 商品【咖啡豆】表(Commodity)表数据库访问层
 *
 * @author XUEW
 **/
@Mapper
public interface CommodityMapper {

    /**
     * @param commodity 实例对象
     * @return 影响行数
     * 添加Commodity
     */
    int insert(Commodity commodity);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除Commodity
     */
    int deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    Commodity getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Commodity> listCommoditys();

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Commodity> listCommoditysOrderBySaleCount();

    /**
     * @param commodity 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Commodity> listCommoditys(Commodity commodity);

    /**
     * @param keyWord 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Commodity> listCommoditysByKeyWord(String keyWord);

    /**
     * @param commodity 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countCommoditys(Commodity commodity);

    /**
     * @param commodity
     * @return 影响行数
     * 修改Commodity, 根据 commodity 的主键修改数据
     */
    int update(Commodity commodity);
}