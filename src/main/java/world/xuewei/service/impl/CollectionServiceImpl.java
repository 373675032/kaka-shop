package world.xuewei.service.impl;

import org.springframework.stereotype.Service;
import world.xuewei.entity.Collection;
import world.xuewei.service.BaseService;
import world.xuewei.service.CollectionService;

import java.util.List;

/**
 * @author XUEW
 * @ClassName CollectionServiceImpl
 * 收藏表(Collection)表业务接口实现类
 * @date 2021-02-28 21:07:19
 * @Version 1.0
 **/
@Service("collectionService")
public class CollectionServiceImpl extends BaseService implements CollectionService {

    @Override
    public boolean insert(Collection collection) {
        return collectionMapper.insert(collection) == 1;
    }

    @Override
    public boolean deleteById(Integer id) {
        return collectionMapper.deleteById(id) == 1;
    }

    @Override
    public Collection getById(Integer id) {
        return collectionMapper.getById(id);
    }

    @Override
    public List<Collection> listCollections() {
        return collectionMapper.listCollections();
    }

    @Override
    public List<Collection> listCollections(Collection collection) {
        return collectionMapper.listCollections(collection);
    }

    @Override
    public int countCollections(Collection collection) {
        return collectionMapper.countCollections(collection);
    }

    @Override
    public boolean update(Collection collection) {
        return collectionMapper.update(collection) == 1;
    }

}