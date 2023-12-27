package world.xuewei.service.impl;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.stereotype.Service;
import world.xuewei.entity.Classify;
import world.xuewei.entity.Commodity;
import world.xuewei.service.BaseService;
import world.xuewei.service.CommodityService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author XUEW
 * @ClassName CommodityServiceImpl
 * 商品【咖啡豆】表(Commodity)表业务接口实现类
 * @date 2021-02-28 21:07:20
 * @Version 1.0
 **/
@Service("commodityService")
public class CommodityServiceImpl extends BaseService implements CommodityService {

    @Override
    public boolean insert(Commodity commodity) {
        return commodityMapper.insert(commodity) == 1;
    }

    @Override
    public boolean deleteById(Integer id) {
        return commodityMapper.deleteById(id) == 1;
    }

    @Override
    public Commodity getById(Integer id) {
        Commodity commodity = commodityMapper.getById(id);
        // 获取分类名称
        Classify classify = classifyMapper.getById(commodity.getClassifyId());
        if (ObjectUtil.isNotEmpty(classify)) {
            commodity.setClassify(classify.getName());
        }
        // 计算折扣
        Double originalPrice = commodity.getOriginalPrice();
        Double nowPrice = commodity.getNowPrice();
        Double discount = new BigDecimal(nowPrice / originalPrice).multiply(new BigDecimal(10)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        commodity.setDiscount(discount);
        // 获取平均星星数
        Double avgStar = commodityCommentMapper.getAvgStar(commodity.getId());
        if (ObjectUtil.isNotEmpty(avgStar)) {
            avgStar = new BigDecimal(avgStar).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        commodity.setStars(ObjectUtil.isNotEmpty(avgStar) ? avgStar.intValue() : null);
        return commodity;
    }

    @Override
    public List<Commodity> listCommoditys() {
        List<Commodity> commodities = commodityMapper.listCommoditys();
        commodities.forEach(temp -> {
            // 获取分类名称
            Classify classify = classifyMapper.getById(temp.getClassifyId());
            if (ObjectUtil.isNotEmpty(classify)) {
                temp.setClassify(classify.getName());
            }
            // 计算折扣
            Double originalPrice = temp.getOriginalPrice();
            Double nowPrice = temp.getNowPrice();
            Double discount = new BigDecimal(nowPrice / originalPrice).multiply(new BigDecimal(10)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            temp.setDiscount(discount);
            // 获取平均星星数
            Double avgStar = commodityCommentMapper.getAvgStar(temp.getId());
            if (ObjectUtil.isNotEmpty(avgStar)) {
                avgStar = new BigDecimal(avgStar).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            temp.setStars(ObjectUtil.isNotEmpty(avgStar) ? avgStar.intValue() : null);
        });
        return commodities;
    }

    @Override
    public List<Commodity> listCommoditys(Commodity commodity) {
        List<Commodity> commodities = commodityMapper.listCommoditys(commodity);
        commodities.forEach(temp -> {
            // 获取分类名称
            Classify classify = classifyMapper.getById(temp.getClassifyId());
            if (ObjectUtil.isNotEmpty(classify)) {
                temp.setClassify(classify.getName());
            }
            // 计算折扣
            Double originalPrice = temp.getOriginalPrice();
            Double nowPrice = temp.getNowPrice();
            Double discount = new BigDecimal(nowPrice / originalPrice).multiply(new BigDecimal(10)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            temp.setDiscount(discount);
            // 获取平均星星数
            Double avgStar = commodityCommentMapper.getAvgStar(temp.getId());
            if (ObjectUtil.isNotEmpty(avgStar)) {
                avgStar = new BigDecimal(avgStar).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            temp.setStars(ObjectUtil.isNotEmpty(avgStar) ? avgStar.intValue() : null);
        });
        return commodities;
    }

    @Override
    public List<Commodity> listCommoditys(String keyWord) {
        List<Commodity> commodities = commodityMapper.listCommoditysByKeyWord("%" + keyWord + "%");
        commodities.forEach(temp -> {
            // 获取分类名称
            Classify classify = classifyMapper.getById(temp.getClassifyId());
            if (ObjectUtil.isNotEmpty(classify)) {
                temp.setClassify(classify.getName());
            }
            // 计算折扣
            Double originalPrice = temp.getOriginalPrice();
            Double nowPrice = temp.getNowPrice();
            Double discount = new BigDecimal(nowPrice / originalPrice).multiply(new BigDecimal(10)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            temp.setDiscount(discount);
            // 获取平均星星数
            Double avgStar = commodityCommentMapper.getAvgStar(temp.getId());
            if (ObjectUtil.isNotEmpty(avgStar)) {
                avgStar = new BigDecimal(avgStar).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            temp.setStars(ObjectUtil.isNotEmpty(avgStar) ? avgStar.intValue() : null);
        });
        return commodities;
    }

    @Override
    public int countCommoditys(Commodity commodity) {
        return commodityMapper.countCommoditys(commodity);
    }

    @Override
    public boolean update(Commodity commodity) {
        return commodityMapper.update(commodity) == 1;
    }

    @Override
    public List<Commodity> listCommoditysOrderBySaleCount() {
        List<Commodity> commodities = commodityMapper.listCommoditysOrderBySaleCount();
        commodities.forEach(temp -> {
            // 获取分类名称
            Classify classify = classifyMapper.getById(temp.getClassifyId());
            if (ObjectUtil.isNotEmpty(classify)) {
                temp.setClassify(classify.getName());
            }
            // 计算折扣
            Double originalPrice = temp.getOriginalPrice();
            Double nowPrice = temp.getNowPrice();
            Double discount = new BigDecimal(nowPrice / originalPrice).multiply(new BigDecimal(10)).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            temp.setDiscount(discount);
            // 获取平均星星数
            Double avgStar = commodityCommentMapper.getAvgStar(temp.getId());
            if (ObjectUtil.isNotEmpty(avgStar)) {
                avgStar = new BigDecimal(avgStar).setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            temp.setStars(ObjectUtil.isNotEmpty(avgStar) ? avgStar.intValue() : null);
        });
        return commodities;
    }

}