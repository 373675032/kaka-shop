package world.xuewei.mapper;

import org.apache.ibatis.annotations.Mapper;
import world.xuewei.entity.Collection;

import java.util.List;

/**
 * 收藏表(Collection)表数据库访问层
 *
 * @author XUEW
 **/
@Mapper
public interface CollectionMapper {

    /**
     * @param collection 实例对象
     * @return 影响行数
     * 添加Collection
     */
    int insert(Collection collection);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除Collection
     */
    int deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    Collection getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Collection> listCollections();

    /**
     * @param collection 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Collection> listCollections(Collection collection);

    /**
     * @param collection 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countCollections(Collection collection);

    /**
     * @param collection
     * @return 影响行数
     * 修改Collection, 根据 collection 的主键修改数据
     */
    int update(Collection collection);

}