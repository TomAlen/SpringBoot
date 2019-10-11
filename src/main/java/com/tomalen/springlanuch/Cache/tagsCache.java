package com.tomalen.springlanuch.Cache;

import com.tomalen.springlanuch.DTO.TagCacheDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author alen zhong
 * @date 19-9-7
 *
 * 定义一个标签的缓存类
 */
public class tagsCache {

    public static List<TagCacheDTO> getTags () {

        ArrayList<TagCacheDTO> tagCacheDTOS = new ArrayList<>();
        //添加开发语言
        TagCacheDTO programLanguage = new TagCacheDTO();
        programLanguage.setCategoryTag("开发语言");
        programLanguage.setTags(Arrays.asList("javascript" ,"php","css" ,"html","html5" ,"java","node.js" ,"python","c++" ,"c","golang" ,"objective-c","typescript" ,"shell c#","swift" ,"sass","bash" ,"ruby","less" ,"asp.net","lua scala" ,"coffeescript","actionscript" ,"rust","erlang"));
        tagCacheDTOS.add(programLanguage);

        //添加框架
        TagCacheDTO frame = new TagCacheDTO();
        frame.setCategoryTag("开发框架");
        frame.setTags(Arrays.asList("spring" ,"express" ,"django" ,"flask" ,"yii" ,"ruby-on-rails " ,"tornado" ,"koa" ,"struts" ,"springMvc" ,"mybatis" ,"springboot"));
        tagCacheDTOS.add(frame);

        //服务器
        TagCacheDTO server = new TagCacheDTO();
        server.setCategoryTag("服务器");
        server.setTags(Arrays.asList("linux" ,"nginx" ,"docker" ,"apache" ,"ubuntu" ,"centos " ,"tomcat" ,"unix" ,"hadoop" ,"windows-server" ,"deepin"));
        tagCacheDTOS.add(server);

        return tagCacheDTOS;
    }

    //判断非法字符
    public static String validTags(String tags) {

        //将返回的tags进行分离
        String[] split = StringUtils.split(tags, ",");
        List<TagCacheDTO> tagDTO = getTags();

        //对二维数组的tags依次拿出，封装成一个List集合
        List<String> tagList = tagDTO.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        //把从前端返回的tags也封装成stream,将与集合的tag数据进行校检,如果传入的tag不等于封装的原tags，就返回非法字符集合.
        String inValid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));


        //将非法字符集返回。
        return inValid;
    }




}
