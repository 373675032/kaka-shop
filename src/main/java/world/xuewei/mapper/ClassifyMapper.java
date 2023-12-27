package world.xuewei.mapper;

import org.apache.ibatis.annotations.Mapper;
import world.xuewei.entity.Classify;

import java.util.List;

/**
 * 归类(Classify)表数据库访问层
 *
 * @author XUEW
 **/
@Mapper
public interface ClassifyMapper {

    /**
     * @param classify 实例对象
     * @return 影响行数
     * 添加Classify
     */
    int insert(Classify classify);

    /**
     * @param id 主键
     * @return 影响行数
     * 删除Classify
     */
    int deleteById(Integer id);

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    Classify getById(Integer id);

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    List<Classify> listClassifys();

    /**
     * @param classify 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    List<Classify> listClassifys(Classify classify);

    /**
     * @param classify 实例对象
     * @return 结果数量
     * 实体作为筛选条件获取结果数量
     */
    int countClassifys(Classify classify);

    /**
     * @param classify
     * @return 影响行数
     * 修改Classify, 根据 classify 的主键修改数据
     */
    int update(Classify classify);

}