package com.tomalen.springlanuch.Servrice;

import com.tomalen.springlanuch.DTO.QuestionDTO;
import com.tomalen.springlanuch.DTO.SearchByQuery;
import com.tomalen.springlanuch.DTO.paginitionDTO;
import com.tomalen.springlanuch.Mapper.QuestionExtMapper;
import com.tomalen.springlanuch.Mapper.QuestionMapper;
import com.tomalen.springlanuch.Mapper.UserMapper;
import com.tomalen.springlanuch.exception.TomalenErrorCode;
import com.tomalen.springlanuch.exception.TomalenException;
import com.tomalen.springlanuch.pojo.Question;
import com.tomalen.springlanuch.pojo.QuestionExample;
import com.tomalen.springlanuch.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author:钟炜宏
 * Date:2019/8/27
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    /**
     * @param page 分页信息的当前页
     * @param size 每页的大小
     * @param search
     * @return
     */
    //找出问题和与之绑定的user
    public paginitionDTO findQuestion(Integer page, Integer size, String search) {
        paginitionDTO<QuestionDTO> paginitionDTO = new paginitionDTO();

        //将搜索的添加组合

        //搜索条件不为空
        if (StringUtils.isNotBlank(search)) {
            //得到tag，去掉 ， 号
            String[] split = StringUtils.split(search, " ");
            //利用steam lambda表达式用 | 连接数据库查询条件
            search = Arrays.stream(split).collect(Collectors.joining("|"));
        }
        SearchByQuery countBySearch = new SearchByQuery();
        countBySearch.setSearch(search);
        Integer total = questionExtMapper.countBySearch(countBySearch);

        //查询总数
       /* QuestionExample questionExample = new QuestionExample();
        Integer total = (int) questionMapper.countByExample(questionExample);*/
        //计算出返回页面的分页信息
        paginitionDTO.setPaginition(total, page, size);
        if (page < 1) {
            page = 1;
        }

        if (page > paginitionDTO.getTotalPage()) {
            page = paginitionDTO.getTotalPage();
        }
        //计算出偏移量
        //5*(i-1)
        long offset;
        offset = size * (page - 1);
        if(offset < 0) {
            offset = 1;
        }


       /* QuestionExample example = new QuestionExample();
        example.setOffset(offset);
        example.setLimit(size);
        example.setOrderByClause("gmt_create desc");
        List<Question> questions = questionMapper.selectByExample(example);
*/
        SearchByQuery searchByQuery = new SearchByQuery();
        searchByQuery.setSearch(search);
        searchByQuery.setPage(offset);
        searchByQuery.setSize(size);
        List<Question> questions = questionExtMapper.selectBySearch(searchByQuery);


        List<QuestionDTO> questionDTOList = new ArrayList<>(0);
        for (Question question : questions) {
            QuestionDTO questionDTO = new QuestionDTO();
            //根据creator查出user
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            //工具类将Question赋值到QuestionDTO中
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            //将questionDTO添加进List集合中
            questionDTOList.add(questionDTO);
        }
        //把questionDTOList数据插入进去

        paginitionDTO.setData(questionDTOList);
        return paginitionDTO;
    }

    /**
     * 根据userId查出相应的分页信息。
     *
     * @param userId
     * @param page
     * @param size
     * @return
     */
    public paginitionDTO list(Integer userId, Integer page, Integer size) {
        paginitionDTO<QuestionDTO> paginitionDTO = new paginitionDTO();
        //查询总数
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCreatorEqualTo(userId);
        Integer total = (int) questionMapper.countByExample(questionExample);

        //Integer total = questionMapper.findTotalByCreateId(userId);
        //计算出返回页面的分页信息

        paginitionDTO.setPaginition(total, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginitionDTO.getTotalPage()) {
            page = paginitionDTO.getTotalPage();
        }
        //计算出偏移量
        //5*(i-1)
        long offset;
        offset = size * (page - 1);
        if (offset <= 0) {
            offset = 1;
        }


        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andCreatorEqualTo(userId);
        example.setOffset(offset);
        example.setLimit(size);
        List<Question> questions = questionMapper.selectByExample(example);


        List<QuestionDTO> questionDTOList = new ArrayList<>(0);

        for (Question question : questions) {
            QuestionDTO questionDTO = new QuestionDTO();
            //根据creator查出user
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            //工具类将Question赋值到QuestionDTO中
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            //将questionDTO添加进List集合中
            questionDTOList.add(questionDTO);
        }
        //把questionDTOList数据插入进去
        paginitionDTO.setData(questionDTOList);
        return paginitionDTO;
    }

    //根据id查找问题
    public QuestionDTO findById(Integer id) {
        QuestionDTO questionDTO = new QuestionDTO();
        Question question = questionMapper.selectByPrimaryKey(id);
        if (question == null) {
            throw new TomalenException(TomalenErrorCode.QUESTION_NOT_FOUND);
        }
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }


    //根据问题id是否存在更新或者插入
    public void insertOrUpdate(Question question) {
        if (question.getId() == null) {
            // 插入
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            question.setViewCount(0);
            question.setCommentCount(0);
            question.setLikeCount(0);
            questionMapper.insert(question);
        } else {
            // 更新
            question.setGmtModified(System.currentTimeMillis());
            questionMapper.updateByPrimaryKey(question);
        }
    }

    //增加阅读数
    public void insertCView(Integer id) {
        /*//先查出问题的原阅读数
        Question question = new Question();
        Question byPrimaryKey = questionMapper.selectByPrimaryKey(id);
        question.setViewCount(byPrimaryKey.getViewCount() + 1);
        //条件为主键进行更新
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andIdEqualTo(id);
        questionMapper.updateByExampleSelective(question, example);*/

        //先根据主键搜出问题
        Question question1 = questionMapper.selectByPrimaryKey(id);
        //步长为1
        question1.setViewCount(1);
        questionExtMapper.incViewCount(question1);

    }


    //根据tag模糊查询将相关问题查出显示到前台页面
    public List<QuestionDTO> selectRelated(QuestionDTO relatedQuestion) {
        //为空 ，返回一个空集合
        if (StringUtils.isBlank(relatedQuestion.getTag())) {
            return new ArrayList<QuestionDTO>();
        }
        //得到tag，去掉 ， 号
        String[] split = StringUtils.split(relatedQuestion.getTag(), ",");
        //利用steam lambda表达式用 | 连接数据库查询条件
        String tags = Arrays.stream(split).collect(Collectors.joining("|"));
        //设置条件
        Question question = new Question();
        question.setId(relatedQuestion.getId());
        question.setTag(tags);

        //获取出相关问题
        List<Question> questions = questionExtMapper.selectByRelated(question);

        //把questions转换为QuestionDTO
        List<QuestionDTO> questionDTOS = questions.stream().map(question1 -> {
            QuestionDTO questionDTO = new QuestionDTO();
            //赋值 将questions的值复制给QuestionDTO
            BeanUtils.copyProperties(question1, questionDTO);
            return questionDTO;
        }).collect(Collectors.toList());

        return questionDTOS;
    }

    //找出自己提问的个数
    public Integer findCount(Integer id) {
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andCreatorEqualTo(id);
        Integer count = (int) questionMapper.countByExample(questionExample);
        return count;

    }
}
