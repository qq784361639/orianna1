package com.mhc.orianna.core.base.config.util;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import com.mhc.bs.common.base.page.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author maihe
 */
public class BeanUtil extends BeanUtils {
    static Object[] EMPTY_PARAM = new Object[0];
    static Map<Class<?>, Map<String, Method>> methodCache = new ConcurrentHashMap<Class<?>, Map<String, Method>>(20);

    public static <R, T> R copyPorp2DO(Class<R> destClazz, T src) throws RuntimeException {
        try {
            return copyPorp2DO(destClazz, src, null);
        } catch (Exception e) {
            throw new RuntimeException("Copy prop error.", e);
        }
    }

    public static <R, T> R copyPorp2DO(Class<R> destClazz, T src, IConvert<R, T> iConvert) throws RuntimeException {
        try {
            R dest = destClazz.newInstance();
            BeanUtils.copyProperties(src, dest);
            if (iConvert != null) {
                iConvert.convert(dest, src);
            }
            return dest;
        } catch (Exception e) {
            throw new RuntimeException("Copy prop error.", e);
        }
    }

    public static <T, R> List<R> copyPorp2DOs(Class<R> destClazz, List<T> obis, IConvert<R, T>... iConvert) throws RuntimeException {
        try {
            if (CollectionUtils.isEmpty(obis)) {
                return null;
            }
            List<R> list = Lists.newArrayList();
            R destObj = null;
            for (T obi : obis) {
                destObj = destClazz.newInstance();
                BeanUtils.copyProperties(obi, destObj);
                if (iConvert.length == 1) {
                    iConvert[0].convert(destObj, obi);
                }
                list.add(destObj);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Copy prop error.", e);
        }
    }

    public static <R, T> PageInfo<R> convertPage2PageInfo(Class<R> clazz, Page<T> page, IConvert<R,T>... iConvert) {
        PageInfo<R> pageInfo = copyPorp2DO(PageInfo.class, page);
        pageInfo.setTotal(Integer.valueOf(page.getTotal() + ""));
        pageInfo.setPages(Integer.valueOf(page.getPages() + ""));
        pageInfo.setRecords(copyPorp2DOs(clazz, page.getRecords(),iConvert));
        return pageInfo;
    }

    //对批量复制的特殊字段做处理
    public interface IConvert<R, T> {
        /**
         * <p> 对象特殊字段转换 </p>
         */
        void convert(R v, T t);
    }

    public static <R> R createCloneBean(Object obi, Class<R> destClaz) {
        try {
            R destObj = destClaz.newInstance();
            BeanUtils.copyProperties(obi, destObj);
            return destObj;
        } catch (Exception e) {
            throw new RuntimeException("Copy prop error.", e);
        }

    }

    public static void copyNonNullProperties(Object target, Object in) {
        if (in == null || target == null || target.getClass() != in.getClass()) {
            return;
        }

        final BeanWrapper src = new BeanWrapperImpl(in);
        final BeanWrapper trg = new BeanWrapperImpl(target);

        for (final Field property : target.getClass().getDeclaredFields()) {
            Object providedObject = src.getPropertyValue(property.getName());
            if (providedObject != null && !(providedObject instanceof Collection<?>)) {
                trg.setPropertyValue(
                        property.getName(),
                        providedObject);
            }
        }
    }

    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    //入参全部非空
    public static Boolean paramNotNull(Object... objects) {
        for (Object obj : objects) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }
}
