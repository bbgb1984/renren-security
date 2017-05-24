package io.renren.utils;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaCacheUtils {

	public final static LoadingCache<String, Object> accessTokenCache = CacheBuilder
			.newBuilder()
//			缓存有效期2分钟
			.expireAfterWrite(20, TimeUnit.MINUTES).maximumSize(1000)
			.build(new CacheLoader<String, Object>() {
				@Override
				public Object load(String arg0) throws Exception {
					return "";// key为空值，value为空
				}
			});
	
	public final static LoadingCache<String, Object> userInfoCache = CacheBuilder
			.newBuilder()
			//			缓存有效期2分钟
			.expireAfterWrite(20, TimeUnit.MINUTES).maximumSize(1000)
			.build(new CacheLoader<String, Object>() {
				@Override
				public Object load(String arg0) throws Exception {
					return "";// key为空值，value为空
				}
			});
}
