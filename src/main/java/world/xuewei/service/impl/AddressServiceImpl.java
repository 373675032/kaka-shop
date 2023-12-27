package world.xuewei.service.impl;

import org.springframework.stereotype.Service;
import world.xuewei.entity.Address;
import world.xuewei.mapper.AddressMapper;
import world.xuewei.service.AddressService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XUEW
 * @ClassName AddressServiceImpl
 * 收货地址(Address)表业务接口实现类
 * @date 2021-04-26 10:25:26
 * @Version 1.0
 **/
@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;

    @Override
    public boolean insert(Address address) {
        return addressMapper.insert(address) == 1;
    }

    @Override
    public boolean deleteById(Integer id) {
        return addressMapper.deleteById(id) == 1;
    }

    @Override
    public Address getById(Integer id) {
        return addressMapper.getById(id);
    }

    @Override
    public List<Address> listAddresss() {
        return addressMapper.listAddresss();
    }

    @Override
    public List<Address> listAddresss(Address address) {
        return addressMapper.listAddresss(address);
    }

    @Override
    public int countAddresss(Address address) {
        return addressMapper.countAddresss(address);
    }

    @Override
    public boolean update(Address address) {
        return addressMapper.update(address) == 1;
    }

}
